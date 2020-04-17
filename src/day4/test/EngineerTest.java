package day4.test;

import day4.entity.AutomatedTest;
import day4.entity.ManualTest;
import day4.entity.Result;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;
import org.junit.Assert;
import org.junit.Test;

public class EngineerTest {
   private static final String MSG = "Test execution for %s by %s Anxiety %s is not correct!";

   private Engineer testEngineer = new TestEngineer ();
   private Engineer automationEngineer = new AutomationEngineer ();
    day4.entity.Test test;

    @Test
    public void verifySetInstabilityOneByGettingLessThanOne(){
        test = new AutomatedTest (TestLevel.API,-3);
        Assert.assertEquals ("Instability was set not correct!",1, test.getInstability ());
    }

    @Test
    public void verifySetInstabilityTenByGettingGreaterThanTen(){
        test = new AutomatedTest (TestLevel.API,12);
        Assert.assertEquals ("Instability was set not correct!",10, test.getInstability ());
    }

    @Test
    public void verifySetInstabilityBetweenOneAndTen(){
        test = new AutomatedTest (TestLevel.API,5);
        Assert.assertEquals ("Instability was set not correct!",5, test.getInstability ());
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
       test = new ManualTest (TestLevel.GUI,10);
       automationEngineer.setSkill (2);
       Assert.assertEquals (String.format (MSG, test.getClass ().getSimpleName (), automationEngineer.getClass ()
               .getSimpleName (), automationEngineer.getAnxiety ()), Result.FAILED, automationEngineer.executeTest (test));
   }

    // conditions in apply method: if1 (true || false) else (not evaluate), if2 (false);
    @Test
    public void verifyExecuteManualTestByAutomationEngineerPassed(){
        test = new ManualTest (TestLevel.API,4);
        automationEngineer.setSkill (6);
        Assert.assertEquals (String.format (MSG, test.getClass ().getSimpleName (), automationEngineer.getClass ()
                .getSimpleName (), automationEngineer.getAnxiety ()), Result.PASSED, automationEngineer.executeTest (test));
    }

    // conditions in apply method: if1 (false || true) else (not evaluate), if2 (true);
    @Test
    public void verifyExecuteAutomatedTestByTestEngineerFailed(){
        test = new AutomatedTest (TestLevel.GUI,10);
        testEngineer.setSkill (2);
        Assert.assertEquals (String.format (MSG, test.getClass ().getSimpleName (), testEngineer.getClass ()
                .getSimpleName (), testEngineer.getAnxiety ()), Result.FAILED, testEngineer.executeTest (test));
    }

    // conditions in apply method: if1 (false || true) else (not evaluate), if2 (false);
    @Test
    public void verifyExecuteAutomatedTestByTestEngineerPassed(){
        test = new AutomatedTest (TestLevel.API,4);
        testEngineer.setSkill (6);
        Assert.assertEquals (String.format (MSG, test.getClass ().getSimpleName (), testEngineer.getClass ()
                .getSimpleName (), testEngineer.getAnxiety ()), Result.PASSED, testEngineer.executeTest (test));
    }

    // conditions in apply method: if1 (false || false) else (true), if2 (true);
    @Test
    public void verifyExecuteManualTestByTestEngineerFailed(){
        test = new ManualTest (TestLevel.GUI,10);
        testEngineer.setSkill (2);
        Assert.assertEquals (String.format (MSG, test.getClass ().getSimpleName (), testEngineer.getClass ()
                .getSimpleName (), testEngineer.getAnxiety ()), Result.FAILED, testEngineer.executeTest (test));
    }

    // conditions in apply method: if1 (false || false) else (true), if2 (false);
    @Test
    public void verifyExecuteAutomatedTestByAutomationEngineerPassed(){
        test = new AutomatedTest (TestLevel.API,4);
        automationEngineer.setSkill (6);
        Assert.assertEquals (String.format (MSG, test.getClass ().getSimpleName (), automationEngineer.getClass ()
                .getSimpleName (), automationEngineer.getAnxiety ()), Result.PASSED, automationEngineer.executeTest (test));
    }
}
