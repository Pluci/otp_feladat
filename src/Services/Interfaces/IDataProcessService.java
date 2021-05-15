package Services.Interfaces;

import DTOs.Customer;
import DTOs.Identification;
import DTOs.Payment;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

public interface IDataProcessService {
    Customer createCustomer(String data);
    Payment createPayment(String data) throws ParseException;
    void createReportByUser() throws IOException;
    void createReportByWebshop() throws IOException;
}
