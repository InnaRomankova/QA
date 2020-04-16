package day4;

import day4.entity.AutomatedTest;
import day4.entity.ManualTest;
import day4.entity.Test;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;

public class Runner {
    public static void main(String[] args) {
        Engineer testEngineer = new TestEngineer ();
        Engineer automationEngineer = new AutomationEngineer ();
        Test manualTest = new ManualTest (TestLevel.GUI, 15);
        Test automatedTest = new AutomatedTest (TestLevel.API, 1);

        System.out.println (automationEngineer.executeTest (manualTest));
        System.out.println (testEngineer.executeTest (automatedTest));
        System.out.println (automationEngineer.executeTest (automatedTest));
        System.out.println (testEngineer.executeTest (manualTest));
    }
}
