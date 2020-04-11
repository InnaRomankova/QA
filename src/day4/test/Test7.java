package day4.test;

import day4.entity.AutomatedTest;
import day4.entity.Result;
import day4.entity.TestLevel;
import day4.worker.Engineer;
import day4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

public class Test7 {
    @Test
    public void test7(){
        Engineer testEngineer = new TestEngineer ();
        day4.entity.Test automatedTest = new AutomatedTest (TestLevel.UNIT, 4);
        Assert.assertEquals (Result.PASSED, automatedTest.apply (testEngineer));
    }
}
