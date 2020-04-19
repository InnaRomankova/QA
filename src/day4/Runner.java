package day4;

import day4.entity.AutomatedATest;
import day4.entity.ManualATest;
import day4.entity.ATest;
import day4.entity.TestLevel;
import day4.worker.AutomationEngineer;
import day4.worker.Engineer;
import day4.worker.TestEngineer;

public class Runner {
    public static void main(String[] args) {
        Engineer testEngineer = new TestEngineer ();
        Engineer automationEngineer = new AutomationEngineer ();
        ATest manualATest = new ManualATest (TestLevel.GUI, 15);
        ATest automatedATest = new AutomatedATest (TestLevel.API, 1);

        System.out.println (automationEngineer.executeTest (manualATest));
        System.out.println (testEngineer.executeTest (automatedATest));
        System.out.println (automationEngineer.executeTest (automatedATest));
        System.out.println (testEngineer.executeTest (manualATest));
    }
}
