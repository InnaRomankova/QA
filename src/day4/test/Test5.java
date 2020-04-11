package day4.test;

import day4.entity.ManualTest;
import day4.entity.Result;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import org.junit.Assert;
import org.junit.Test;

public class Test5 {
    @Test
    public void test5(){
        Engineer automationEngineer = new AutomationEngineer ();
        day4.entity.Test manualTest = new ManualTest (TestLevel.API, 4);
        Assert.assertEquals (Result.FAILED, manualTest.apply (automationEngineer));
    }
}
