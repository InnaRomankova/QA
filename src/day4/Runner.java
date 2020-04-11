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
        Test manualTest = new ManualTest (TestLevel.GUI, 4);
        Test automatedTest = new AutomatedTest (TestLevel.API, 1);
        System.out.println ("Result execute test1: " + manualTest.apply (automationEngineer));
        System.out.println ("Result execute test2: " + automatedTest.apply (testEngineer));
    }
 }
