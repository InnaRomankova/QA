package day4.test;

import day4.entity.ATest;
import day4.entity.AutomatedATest;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

public class InstabilityATest {
    private Engineer testEngineer = new TestEngineer ();
    private Engineer automationEngineer = new AutomationEngineer ();

    ATest ATest;

    @Test
    public void verifySetInstabilityOneByGettingLessThanOne(){
        ATest = new AutomatedATest (TestLevel.API,-3);
        Assert.assertEquals ("Instability was set not correct!",1, ATest.getInstability ());
    }

    @Test
    public void verifySetInstabilityTenByGettingGreaterThanTen(){
        ATest = new AutomatedATest (TestLevel.API,12);
        Assert.assertEquals ("Instability was set not correct!",10, ATest.getInstability ());
    }

    @Test
    public void verifySetInstabilityBetweenOneAndTen(){
        ATest = new AutomatedATest (TestLevel.API,5);
        Assert.assertEquals ("Instability was set not correct!",5, ATest.getInstability ());
    }
}
