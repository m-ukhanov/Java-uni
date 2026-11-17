package ua.opnu;

import java.util.Arrays;
import java.lang.reflect.Method;
import java.util.function.Predicate;

public class Main {

    public static <T> T[] filter(T[] input, Predicate<T> p) {
        T[] result = Arrays.copyOf(input, input.length);

        int counter = 0;
        for (T element : input) {
            if (p.test(element)) {
                result[counter] = element;
                counter++;
            }
        }

        return Arrays.copyOf(result,counter);
    }

    public static <T extends Comparable<T>, V extends T> boolean contains(T[] array, V element) {
        for (T item : array) {
            if(item.compareTo(element)==0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //TASK 1

        // 1. Порожнє значення (наприклад, у користувача немає по-батькові)
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення (наприклад, логін користувача)
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        System.out.println("get(): " + username.get()); // "admin"
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевіримо, що get() на порожньому об'єкті кидає помилку
        try {
            String test = middleName.get(); // має кинути IllegalStateException
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевіримо, що конструктор не приймає null
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }
        System.out.println("-----------------------\n");

        //TASK 2

        BookData[] books = {
                new BookData("Java", "Author A", 10, 35),
                new BookData("Python", "Author B", 5, 25),
                new BookData("C++", "Author C", 25, 135)
        };

        Arrays.sort(books); // Arrays.sort() викликає compareTo() автоматично
        for (BookData book : books)
            System.out.println(book);
        System.out.println("-----------------------\n");

        //TASK 3

        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        System.out.println("-----------------------\n");

        //TASK 4
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        String[] words = {"Java", "C", "Python", "Go"};

        System.out.println(Arrays.toString(
                filter(numbers, n -> n % 2 == 0)
        ));

        System.out.println(Arrays.toString(
                filter(words, s -> s.length() > 3)
        ));
        System.out.println("-----------------------\n");

        //TASK 5
        System.out.println(contains(words, "Java"));
        System.out.println(contains(words, "Ruby"));
        System.out.println("-----------------------\n");

        //TASK 6
        GenericTwoTuple<String, Integer> student = new GenericTwoTuple<>("Максим", 95);
        GenericThreeTuple<String, Integer, Double> studentInfo = new GenericThreeTuple<>("Максим", 95, 4.5);

        System.out.println(student);
        System.out.println(studentInfo);
    }
}