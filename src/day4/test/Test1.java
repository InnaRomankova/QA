package day4.test;

import day4.entity.AutomatedTest;
import day4.entity.Result;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import org.junit.Assert;
import org.junit.Test;


public class Test1 {
    @Test
    public void test1(){
        Engineer automationEngineer = new AutomationEngineer ();
        day4.entity.Test automatedTest = new AutomatedTest (TestLevel.UNIT, 4);
        Assert.assertEquals (Result.PASSED, automatedTest.apply (automationEngineer));
    }
}