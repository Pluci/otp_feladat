package Test.UnitTests;

import static org.junit.Assert.*;

import DTOs.Identification;
import Repository.Identification.IdentificationRepository;
import Services.IdService;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

public class Test_IdentificationService {
    public IdService idService;
    private String testData = "WS01;A01;Kovács János;Bp. 1192 Kosárfonó u. 18";

    @Before
    public void getDependencys(){
        idService = new IdService(new IdentificationRepository(new LinkedList<Identification>()));
    }

    @Test
    public void testSetId(){
        Identification expected = new Identification("WS01", "A01");

        Identification actual = this.idService.setId("WS01", "A01");

        assertEquals(expected, actual);
    }

}
