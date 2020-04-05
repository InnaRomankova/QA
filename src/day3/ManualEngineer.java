package day3;

public class ManualEngineer extends Engineer implements Executable {
    public ManualEngineer(String name, String surname, int age) {
        super (name, surname, age);
    }

    @Override
    public void execute() {
        System.out.println (name+" "+surname+" is able to execute tests.");
    }
    @Override
    public String toString() {
        return "Manual engineer: "+name+" "+surname+". "+name+" "+surname+ " is "+age+".";
    }
}
