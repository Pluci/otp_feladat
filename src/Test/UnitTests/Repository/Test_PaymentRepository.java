package Test.UnitTests.Repository;

import DTOs.Customer;
import DTOs.Identification;
import DTOs.Payment;
import DTOs.PaymentTypes;
import Repository.Customer.CustomerRepository;
import Repository.Payment.IPaymentRepository;
import Repository.Payment.PaymentRepository;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class Test_PaymentRepository {
    public IPaymentRepository repository;
    private String testData = "WS01;A01;card;2199;;4,90837E+15;2021.01.01";

    @Before
    public void getDependencys(){
        this.repository = new PaymentRepository(new LinkedList<Payment>());
    }

    @Test
    public void testCreatePayment() throws ParseException {
        Identification customerIdentification = new Identification("WS01", "A01");

        Payment expected = new Payment(customerIdentification, PaymentTypes.CARD, 2199, "4,90837E+15" , new SimpleDateFormat("yyyy.MM.dd").parse("2021.01.01 "));

        Payment actual = this.repository.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetPayment() throws ParseException {
        Identification customerIdentification = new Identification("WS01", "A01");
        Payment test_payment = new Payment(customerIdentification, PaymentTypes.CARD, 2199, "4,90837E+15" , new SimpleDateFormat("yyyy.MM.dd").parse("2021.01.01 "));

        Payment expected = this.repository.create(test_payment);

        Payment actual = this.repository.get(expected.getId());

        assertEquals(expected, actual);
    }

    @Test
    public void testUpdatePaymentTotal() throws ParseException {
        Identification customerIdentification = new Identification("WS01", "A01");
        Payment test_payment = new Payment(customerIdentification, PaymentTypes.CARD, 2199, "4,90837E+15" , new SimpleDateFormat("yyyy.MM.dd").parse("2021.01.01 "));
        Payment expected = this.repository.create(test_payment);
        expected.setTotal(5100);

        Payment actual = this.repository.update(expected);

        assertEquals(expected.getTotal(), actual.getTotal(), 0.000000001);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeletePayment() throws ParseException {
        Identification customerIdentification = new Identification("WS01", "A01");
        Payment test_payment = new Payment(customerIdentification, PaymentTypes.CARD, 2199, "4,90837E+15" , new SimpleDateFormat("yyyy.MM.dd").parse("2021.01.01 "));
        Payment expected = this.repository.create(test_payment);
        this.repository.delete(expected);

        Payment actual = this.repository.get(expected.getId());
    }
}
