package day3;

public class Person extends Human {
    protected String name;
    protected String surname;

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    @Override
    void speak() {
        System.out.println (name + " " + surname + " can speak.");
    }
}
