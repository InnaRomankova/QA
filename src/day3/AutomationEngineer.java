package day3;

public class AutomationEngineer extends Engineer implements Executable {
    public AutomationEngineer(String name, String surname, int age) {
        super (name, surname, age);
    }

    @Override
    public void execute() {
        System.out.println (name + " " + surname + " is able to execute tests.");
    }

    @Override
    public String toString() {
        return "Automation engineer: " + name + " " + surname + ". " + name + " " + surname + " is " + age + ".";
    }
}
