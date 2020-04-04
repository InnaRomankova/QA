package day1;
/*6. Используя Collection и Stream создать из массива коллекцию, отфильтровать оставив только
четные числа, и вывести каждое число от 2 до 20 включительно и больше 10 в порядке по возрастанию.*/

import java.util.*;
import java.util.stream.Collectors;

public class Task2_6 {
    private static final int RANGE_OF_NUMBER = 25;

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
        int[] array = new int[lengthOfArray];
        Random random = new Random ();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt (RANGE_OF_NUMBER);
        }
        System.out.print ("Создан массив: ");
        for (int el : array) {
            System.out.print (el + " ");
        }

        System.out.println ("\nОтфильтруем массив, оставив только четные числа, и выведем каждое число " +
                "от 2 до 20 включительно и больше 10 в порядке по возрастанию: ");
        List<Integer> list = Arrays
                .stream (array)
                .boxed ()
                .filter (x -> x % 2 == 0)
                .filter (x -> 20 >= x & x >= 2)
                .sorted ()
                .peek (x -> System.out.format ("%s ", x))
                .filter (x -> x >= 10)
                .collect (Collectors.toList ());

        System.out.println ();
        for (int el : list) {
            System.out.print (el + " ");
        }
        scanner.close ();
    }
}
