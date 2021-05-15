package Test.UnitTests.Repository;

import DTOs.Identification;
import Repository.Identification.IIdentificationRepository;
import Repository.Identification.IdentificationRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class Test_IdentificationRepository {
    public IIdentificationRepository repository;
    private String testData = "WS01;A01;Kovács János;Bp. 1192 Kosárfonó u. 18";

    @Before
    public void getDependencys(){
        this.repository = new IdentificationRepository(new LinkedList<Identification>());
    }

    @Test
    public void testCreateIdentification(){
        Identification expected = new Identification("WS01", "A01");

        Identification actual = this.repository.create(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetIdentification(){
        Identification test_identification = new Identification("WS01", "A01");
        Identification expected = this.repository.create(test_identification);

        Identification actual = this.repository.get(expected.getId());

        assertEquals(expected, actual);
    }

    @Test
    public void testUpdateIdentification(){
        Identification test_identification = new Identification("WS01", "A01");
        Identification expected = this.repository.create(test_identification);
        expected.setCustomerId("V31");

        Identification actual = this.repository.update(expected);
        assertEquals(expected, actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteIdentification(){
        Identification test_identification = new Identification("WS01", "A01");
        Identification expected = this.repository.create(test_identification);
        this.repository.delete(expected);

        Identification actual = this.repository.get(expected.getId());
    }
}
