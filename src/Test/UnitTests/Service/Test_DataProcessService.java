package Test.UnitTests.Service;

import DTOs.Customer;
import DTOs.Identification;
import DTOs.Payment;
import DTOs.PaymentTypes;
import Repository.Customer.CustomerRepository;
import Repository.Customer.ICustomerRepository;
import Repository.Identification.IdentificationRepository;
import Repository.Payment.PaymentRepository;
import Services.DataProcessService;
import Services.Interfaces.IDataProcessService;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Test_DataProcessService {
    public IDataProcessService service;
    private String testCustomerData = "WS01;A01;Kovács János;Bp. 1192 Kosárfonó u. 18";
    private String testPaymentData = "WS01;A01;card;2199;;4,90837E+15;2021.01.01";

    @Before
    public void getDependencys(){
        this.service = new DataProcessService(
                new CustomerRepository(new LinkedList<Customer>()),
                new PaymentRepository(new LinkedList<Payment>()),
                new IdentificationRepository(new LinkedList<Identification>())
        );
    }

    @Test
    public void testCreateCustomer(){
        Identification customerIdentification = new Identification("WS01", "A01");
        Customer expected = new Customer(customerIdentification, "Kovács János", "Bp. 1192 Kosárfonó u. 18");

        Customer actual = this.service.createCustomer(testCustomerData);

        assertEquals(expected, actual);
    }

    @Test
    public void testCreatePayment() throws ParseException {
        Identification customerIdentification = new Identification("WS01", "A01");

        Payment expected = new Payment(customerIdentification, PaymentTypes.CARD, 2199, "4,90837E+15" , new SimpleDateFormat("yyyy.MM.dd").parse("2021.01.01 "));

        Payment actual = this.service.createPayment(testPaymentData);

        assertEquals(expected, actual);
    }
}
