package day4.test;

import day4.entity.ManualTest;
import day4.entity.Result;
import day4.entity.TestLevel;
import day4.worker.Engineer;
import day4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

public class Test12 {
    @Test
    public void test12(){
        Engineer testEngineer = new TestEngineer ();
        day4.entity.Test manualTest = new ManualTest (TestLevel.GUI, 4);
        Assert.assertEquals (Result.FAILED, manualTest.apply (testEngineer));
    }
}
