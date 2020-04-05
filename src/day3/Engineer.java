package day3;

public class Engineer extends Person {


    public Engineer(String name, String surname, int age) {
        super (name, surname, age);
    }

    public void inventCode() {
        System.out.println (name + " " + surname + " can invent code.");
    }
}
