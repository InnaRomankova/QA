package day4.test;


import day4.entity.*;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class ExecuteTestATest {

    private Engineer en;
    private ATest test;
    private int skill;
    private Result expected;

    public ExecuteTestATest(Engineer en, int skill, ATest test, Result expected) {
        this.en = en;
        this.test = test;
        this.skill = skill;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList (new Object[][]{
                {new AutomationEngineer (), 10, new AutomatedATest (TestLevel.GUI, 0), Result.PASSED},
                {new TestEngineer (), 1, new ManualATest (TestLevel.API, 0), Result.PASSED},
                {new AutomationEngineer (), 10, new ManualATest (TestLevel.UNIT, 0), Result.PASSED},
                {new TestEngineer (), 10, new ManualATest (TestLevel.UNIT, 10), Result.PASSED},
                {new TestEngineer (), 10, new AutomatedATest (TestLevel.API, 11), Result.PASSED},
                {new TestEngineer (), 1, new AutomatedATest (TestLevel.GUI, 10), Result.FAILED},
                {new TestEngineer (), 1, new ManualATest (TestLevel.GUI, 11), Result.FAILED},
                {new TestEngineer (), 1, new AutomatedATest (TestLevel.API, 0), Result.PASSED},
                {new AutomationEngineer (), 1, new AutomatedATest (TestLevel.UNIT, 11), Result.PASSED},
                {new AutomationEngineer (), 10, new AutomatedATest (TestLevel.API, 1), Result.PASSED},
                {new AutomationEngineer (), 1, new ManualATest (TestLevel.API, 10), Result.FAILED},
                {new AutomationEngineer (), 10, new ManualATest (TestLevel.GUI, 11), Result.PASSED},
                {new AutomationEngineer (), 1, new ManualATest (TestLevel.GUI, 1), Result.PASSED},
                {new TestEngineer (), 10, new ManualATest (TestLevel.API, 1), Result.PASSED},
                {new AutomationEngineer (), 10, new AutomatedATest (TestLevel.API, 10), Result.PASSED},
        });
    }

    @Test
    public void verifyExecuteTest() {
        en.setSkill (skill);
        Assert.assertEquals ("Test execution for %s by %s Anxiety %s is not correct!", expected,
                en.executeTest (test));
    }
}
