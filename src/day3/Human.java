package day3;

public abstract class Human {
    protected int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    void speak() {
        System.out.println ("can speak");
    }

}
