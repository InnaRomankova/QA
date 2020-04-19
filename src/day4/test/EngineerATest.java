package day4.test;

import day4.entity.*;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

public class EngineerATest {
   private static final String MSG = "Test execution for %s by %s Anxiety %s is not correct!";

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

    @Test
    public void verifyDefaultAnxietyByTestEngineer (){
        Assert.assertEquals ("Default engineer anxiety is not correct!",3,testEngineer.getAnxiety ());
    }

    @Test
    public void verifySetAnxietyByTestEngineer (){
        testEngineer.setAnxiety (2);
        Assert.assertEquals ("Engineer anxiety was set not correct!",2,testEngineer.getAnxiety ());
    }

    @Test
    public void verifyRandomSkillByAutomationEngineer (){
        Assert.assertTrue ("Random engineer skill is not correct!",1<=automationEngineer.getSkill ()
                &&automationEngineer.getSkill ()<11);
    }

    @Test
    public void verifySetSkillByAutomationEngineer (){
        automationEngineer.setSkill (2);
        Assert.assertEquals ("Engineer skill was set not correct!",2,automationEngineer.getSkill ());
    }

   // conditions in apply method: if1 (true || false) else (not evaluate), if2 (true);
   @Test
    public void verifyExecuteManualTestByAutomationEngineerFailed(){
       ATest = new ManualATest (TestLevel.GUI,10);
       automationEngineer.setSkill (2);
       Assert.assertEquals (String.format (MSG, ATest.getClass ().getSimpleName (), automationEngineer.getClass ()
               .getSimpleName (), automationEngineer.getAnxiety ()), Result.FAILED, automationEngineer.executeTest (ATest));
   }

    // conditions in apply method: if1 (true || false) else (not evaluate), if2 (false);
    @Test
    public void verifyExecuteManualTestByAutomationEngineerPassed(){
        ATest = new ManualATest (TestLevel.API,4);
        automationEngineer.setSkill (6);
        Assert.assertEquals (String.format (MSG, ATest.getClass ().getSimpleName (), automationEngineer.getClass ()
                .getSimpleName (), automationEngineer.getAnxiety ()), Result.PASSED, automationEngineer.executeTest (ATest));
    }

    // conditions in apply method: if1 (false || true) else (not evaluate), if2 (true);
    @Test
    public void verifyExecuteAutomatedTestByTestEngineerFailed(){
        ATest = new AutomatedATest (TestLevel.GUI,10);
        testEngineer.setSkill (2);
        Assert.assertEquals (String.format (MSG, ATest.getClass ().getSimpleName (), testEngineer.getClass ()
                .getSimpleName (), testEngineer.getAnxiety ()), Result.FAILED, testEngineer.executeTest (ATest));
    }

    // conditions in apply method: if1 (false || true) else (not evaluate), if2 (false);
    @Test
    public void verifyExecuteAutomatedTestByTestEngineerPassed(){
        ATest = new AutomatedATest (TestLevel.API,4);
        testEngineer.setSkill (6);
        Assert.assertEquals (String.format (MSG, ATest.getClass ().getSimpleName (), testEngineer.getClass ()
                .getSimpleName (), testEngineer.getAnxiety ()), Result.PASSED, testEngineer.executeTest (ATest));
    }

    // conditions in apply method: if1 (false || false) else (true), if2 (true);
    @Test
    public void verifyExecuteManualTestByTestEngineerFailed(){
        ATest = new ManualATest (TestLevel.GUI,10);
        testEngineer.setSkill (2);
        Assert.assertEquals (String.format (MSG, ATest.getClass ().getSimpleName (), testEngineer.getClass ()
                .getSimpleName (), testEngineer.getAnxiety ()), Result.FAILED, testEngineer.executeTest (ATest));
    }

    // conditions in apply method: if1 (false || false) else (true), if2 (false);
    @Test
    public void verifyExecuteAutomatedTestByAutomationEngineerPassed(){
        ATest = new AutomatedATest (TestLevel.API,4);
        automationEngineer.setSkill (6);
        Assert.assertEquals (String.format (MSG, ATest.getClass ().getSimpleName (), automationEngineer.getClass ()
                .getSimpleName (), automationEngineer.getAnxiety ()), Result.PASSED, automationEngineer.executeTest (ATest));
    }
}
