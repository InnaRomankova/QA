package day1;
/*4. Пройти по массиву и поменять местами каждые 2 соседних элемента.*/

import java.util.*;

public class Task2_4 {
    private static final int RANGE_OF_NUMBERS = 10;
    private static final int ITERATION_STEP = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.print ("Задайте размер массива(введите простое целое число): ");
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
            list.add (random.nextInt (RANGE_OF_NUMBERS));
        }

        printList (list);

        System.out.println ();

        for (int i = 0; i < list.size (); i += ITERATION_STEP) {
            int num = list.get (i);
            list.set (i, list.get (i + 1));
            list.set (i + 1, num);

        }
        printList (list);
        scanner.close ();
    }


    public static void printList(List<Integer> list) {
        for (Integer value : list) {
            System.out.print (value + " ");
        }
    }
}
