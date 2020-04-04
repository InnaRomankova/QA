package day1;
/*3. Используя for вывести каждое четное число от 2 до 20 включительно и больше 10.*/

import java.util.ArrayList;
import java.util.List;

public class Task2_3 {
    public static void main(String[] args) {
        System.out.println ("Не совсем понятно условие задачи. Предлагаю 2 вероятных варианта трактовки условия и соответственно решения." + "\nВариант 1:");
        for (int i = 2; i <= 20; i += 2) {
            if (i > 10) {
                System.out.print (i + " ");
            }
        }
        System.out.println ("\nВариант 2:");
        List<Integer> list = new ArrayList<> ();
        for (int i = 2; i <= 20; i += 2) {
            System.out.print (i + " ");
            if (i > 10) {
                list.add (i);
            }
        }
        System.out.println ();
        for (int el : list) {
            System.out.print (el + " ");
        }
    }
}
