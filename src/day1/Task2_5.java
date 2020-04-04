package day1;
/*5. Циклически сдвинуть все элементы вправо на 2 позиции (1-й элемент станет 3-м, 2-й станет 4-м и т.д.)*/

import java.util.*;

public class Task2_5 {
    private static final int RANGE_OF_NUMBER = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Задайте размер массива (введите простое целое число): ");
        int lengthOfArray = 0;
        while (scanner.hasNext ()) {
            try {
                lengthOfArray = scanner.nextInt ();
                if (lengthOfArray > 0) {
                    break;
                } else {
                    System.out.print ("Invalid number! Try again: ");
                    scanner.nextLine ();
                }
            } catch (NoSuchElementException exp) {
                System.out.print ("Invalid input! Try again: ");
                scanner.nextLine ();
            }
        }
        List<Integer> list = new ArrayList<> (lengthOfArray);
        Random random = new Random ();
        for (int i = 0; i < lengthOfArray; i++) {
            list.add (random.nextInt (RANGE_OF_NUMBER));
        }
        printList (list);

        Collections.rotate (list,2);

        System.out.println ();
        printList (list);
        scanner.close ();
    }

    private static void printList(List<Integer> list) {
        for (int el : list) {
            System.out.print (el + " ");
        }
    }
}
