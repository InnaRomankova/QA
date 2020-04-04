package day1;
/*1. Описать разницу между i++ и ++i, привести пример.*/

public class Task2_1 {
    public static void main(String[] args) {
        System.out.println ("i++ - префиксный инкремент - сначала увеличивает значение, потом возвращает его;" +
                "\n ++i - постфиксный инкремент - сначала возвращает значение, потом увеличивает его. " +
                "\n Пример:");
        int a1, i1 = 1;
        a1 = ++i1;
        System.out.println ("a1 = " + a1 + "\ni1 = " + i1);
        int a2, i2 = 1;
        a2 = i2++;
        System.out.println ("a2 = " + a2 + "\ni2 = " + i2);
    }
}
