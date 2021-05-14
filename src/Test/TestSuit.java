package Test;

import Test.UnitTests.Test_CustomerService;
import Test.UnitTests.Test_PaymentService;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        Test_CustomerService.class,
        //Test_PaymentService.class
})

public class TestSuit {
    public TestSuit(){

    }
}
