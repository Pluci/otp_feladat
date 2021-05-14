package Test.UnitTests.Repository;

import DTOs.Customer;
import DTOs.Identification;
import Repository.Customer.CustomerRepository;
import Repository.Customer.ICustomerRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Test_CustomerRepository {
    public ICustomerRepository repository;
    private String testData = "WS01;A01;Kovács János;Bp. 1192 Kosárfonó u. 18";

    @Before
    public void getDependencys(){
        this.repository = new CustomerRepository(new LinkedList<Customer>());
    }

    @Test
    public void testCreateCustomer(){
        Identification customerIdentification = new Identification("WS01", "A01");
        Customer expected = new Customer(customerIdentification, "Kovács János", "Bp. 1192 Kosárfonó u. 18");

        Customer actual = this.repository.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetCustomer(){
        Identification customerIdentification = new Identification("WS01", "A01");
        Customer test_customer = new Customer(customerIdentification, "Kovács János", "Bp. 1192 Kosárfonó u. 18");
        Customer expected = this.repository.create(test_customer);

        Customer actual = this.repository.get(expected.getId());

        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateCustomerName(){
        Identification customerIdentification = new Identification("WS01", "A01");
        Customer test_customer = new Customer(customerIdentification, "Kovács János", "Bp. 1192 Kosárfonó u. 18");
        Customer expected = this.repository.create(test_customer);
        expected.setAddress("Bp. 1311 Duna Pláza u. 1-3");

        Customer actual = this.repository.update(expected);

        assertEquals(expected.getName(), actual.getName());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteId(){
        Identification customerIdentification = new Identification("WS01", "A01");
        Customer test_customer = new Customer(customerIdentification, "Kovács János", "Bp. 1192 Kosárfonó u. 18");
        Customer expected = this.repository.create(test_customer);
        this.repository.delete(expected);

        Customer actual = this.repository.get(expected.getId());
    }
}
