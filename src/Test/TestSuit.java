package Test;

import Test.UnitTests.Repository.Test_CustomerRepository;
import Test.UnitTests.Repository.Test_IdentificationRepository;
import Test.UnitTests.Repository.Test_PaymentRepository;
import Test.UnitTests.Service.Test_DataProcessService;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        Test_CustomerRepository.class,
        Test_IdentificationRepository.class,
        Test_PaymentRepository.class,
        Test_DataProcessService.class
})

public class TestSuit {
    public TestSuit(){

    }
}
