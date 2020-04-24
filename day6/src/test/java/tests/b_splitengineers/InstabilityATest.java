package tests.b_splitengineers;


import entity.ATest;
import entity.AutomatedATest;
import entity.ManualATest;
import entity.TestLevel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class InstabilityATest {
    private ATest test;
    private int expected;

    public InstabilityATest(ATest test, int expected) {
        this.test = test;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers() {
        return Arrays.asList (new Object[][]{
                {new ManualATest (TestLevel.UNIT, 0), 1},
                {new ManualATest (TestLevel.API, 1), 1},
                {new AutomatedATest (TestLevel.API, 10), 10},
                {new AutomatedATest (TestLevel.GUI, 11), 10},
        });
    }

    @Test
    public void verifyInstability() {
        Assert.assertEquals ("Test instability is not correct!", expected, test.getInstability ());
    }
}
