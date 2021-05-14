package Test.UnitTests;

import DTOs.Identification;
import org.junit.BeforeClass;
import DTOs.Customer;
import Services.CustomerService;
import org.junit.Test;

public class Test_CustomerService {
    private static CustomerService customerService;
    private String testData = "WS01;A01;Kovács János;Bp. 1192 Kosárfonó u. 18";

    @BeforeClass
    public static void getDependencys(){
        customerService = new CustomerService();
    }

    public Test_CustomerService(){

    }
    @Test
    public void TestSetCustomer(){
        Identification expectedIdentification = new Identification("WS01", "A01");
        Customer expected = new Customer(expectedIdentification, "Kovács János", "Bp. 1192 Kosárfonó u. 18");

        Customer actual = customerService.setCustomer(testData);

    }
}
