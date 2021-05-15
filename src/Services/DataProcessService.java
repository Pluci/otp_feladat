package Services;

import DTOs.Customer;
import DTOs.Identification;
import DTOs.Payment;
import DTOs.PaymentTypes;
import Repository.Customer.ICustomerRepository;
import Repository.Identification.IIdentificationRepository;
import Repository.Payment.IPaymentRepository;
import Repository.RepositoryBase;
import Services.Interfaces.IDataProcessService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class DataProcessService implements IDataProcessService {
    private static SimpleDateFormat DateFormater = new SimpleDateFormat("yyyy.MM.dd");

    private ICustomerRepository customerRepository;
    private IPaymentRepository paymentRepository;
    private IIdentificationRepository identificationRepository;

    public DataProcessService(ICustomerRepository customerRepository, IPaymentRepository paymentRepository, IIdentificationRepository identificationRepository) {
        this.customerRepository = customerRepository;
        this.paymentRepository = paymentRepository;
        this.identificationRepository = identificationRepository;
    }
    @Override
    public Customer createCustomer(String data) {
        List<String> customerDetails = new ArrayList<String>(Arrays.asList(data.split(";")));
        Identification identification = identificationRepository.create(new Identification(customerDetails.get(0), customerDetails.get(1)));
        return customerRepository.create(new Customer(identification, customerDetails.get(2), customerDetails.get(3)));
    }

    @Override
    public Payment createPayment(String data) throws ParseException {
        List<String> paymentDetails = new ArrayList<String>(Arrays.asList(data.split(";")));
        paymentDetails.removeIf(x -> x.isEmpty());
        Identification identification = identificationRepository.create(new Identification(paymentDetails.get(0), paymentDetails.get(1)));
        PaymentTypes paymentType;
        if (paymentDetails.get(2).equals("card")){
            paymentType = PaymentTypes.CARD;
        } else{
            paymentType = PaymentTypes.TRANSFER;
        }
        return paymentRepository.create(new Payment(identification, paymentType, Double.parseDouble(paymentDetails.get(3)), paymentDetails.get(4), DateFormater.parse(paymentDetails.get(5))));
    }

    @Override
    public void createReportByUser() throws IOException {
        FileWriter fw = new FileWriter("Data/report01.csv");
        List<Identification> identifications = identificationRepository.getAll();
        for(Identification identification : identifications){
            var customers = customerRepository.getByIdentification(identification);
            var payments = paymentRepository.getByIdentification(identification);
            var customer = customers.stream().findFirst().orElse(null) ;
            if (customer != null){
                fw.write(customer.toString());
                double sumOfPayments = payments.stream().map(x -> x.getTotal()).reduce(1.0, Double::sum);
                fw.write(", vásárlás összege: " + sumOfPayments);
                fw.write(System.lineSeparator());
            }
        }
        fw.close();
    }

    @Override
    public void createReportByWebshop() throws IOException {
        FileWriter fw = new FileWriter("Data/report02.csv");
        List<Identification> identifications = identificationRepository.getAllByShopNumber();
        for(Identification identification : identifications){
            var payments = paymentRepository.getByIdentificationShopNumber(identification);
            var paymentsByCard = payments.stream().filter(x -> x.getPaymentType().equals(PaymentTypes.CARD));
            var paymentsByTransaction = payments.stream().filter(x -> x.getPaymentType().equals(PaymentTypes.TRANSFER));
            double sumOfPaymentsByCard = paymentsByCard.map(x -> x.getTotal()).reduce(0.0, Double::sum);
            double sumOfPaymentsByTransaction = paymentsByTransaction.map(x -> x.getTotal()).reduce(0.0, Double::sum);
            fw.write("WEBSHOP: " + identification.getShopId() + ", Kártyás vásárlások összege: " + sumOfPaymentsByCard
                    + ", Átutalásos vásárlások összeges: " + sumOfPaymentsByTransaction);
            fw.write(System.lineSeparator());
        }
        fw.close();
    }
}
