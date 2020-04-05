package day3;

public class Runner {
    public static void main(String[] args) {
        Engineer automationEngineer = new AutomationEngineer ("Ivan", "Ivanov", 28);
        Engineer manualEngineer = new ManualEngineer ("Petr", "Petrov", 23);

        Engineer[] engineers = {automationEngineer, manualEngineer};
        for (Engineer engineer : engineers) {
            System.out.println (engineer);
        }
        System.out.println ();
        characteristics (automationEngineer);
        System.out.println ();
        characteristics (manualEngineer);

    }

    private static void characteristics(Engineer engineer) {
        if (engineer instanceof AutomationEngineer) {
            AutomationEngineer automationEngineer = (AutomationEngineer) engineer;
            automationEngineer.execute ();
        }
        if (engineer instanceof ManualEngineer) {
            ManualEngineer manualEngineer = (ManualEngineer) engineer;
            manualEngineer.execute ();
        }
        engineer.speak ();
        engineer.inventCode ();
    }

}
