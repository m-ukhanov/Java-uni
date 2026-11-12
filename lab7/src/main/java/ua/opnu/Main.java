package ua.opnu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    static Predicate isPrime = o -> { // task 1
        int n = (int) o;

        if (n<2) return false;
        for (int i=2; i<=n/i; i++) {
            if (n%i==0) return false;
        }

        return true;
    };

    static Student[] filter(Student[] students, Predicate p) { // task 2
        Student[] result = new Student[students.length];
        int count = 0;

        for (Student student : students) {
            if (p.test(student)) {
                result[count++] = student;
            }
        }

        return Arrays.copyOf(result, count);
    }

    static Student[] filterWithTwoConditions(Student[] students, Predicate p1, Predicate p2) { // task 3
        return filter(students, p1.and(p2));
    }

    static void process(int[] array, Predicate p, Consumer c) {
        for (int i : array) {
            if (p.test(i)) {
                c.accept(i);
            }
        }
    }

    static int[] processArray(int[] input, Function f) {
        int[] result = new int[input.length];

        for (int i=0; i<input.length;i++) {
            result[i] = (int) f.apply(input[i]);
        }

        return result;
    }

    static String[] stringify(int[] input, Function f) {
        String[] result = new String[input.length];

        for (int i = 0; i < input.length; i++) {
            result[i] = (String) f.apply(input[i]);
        }
        return result;
    }

    public static void main(String args[]) {

        System.out.println("Task 1:");
        System.out.println(isPrime.test(2));
        System.out.println(isPrime.test(10));

        System.out.println("Task 2:");
        Student[] students = {
                new Student(new int[] {60, 80, 75, 60}, "AI-267", "Oleg Vasylenko"),
                new Student(new int[] {55, 75, 60, 65}, "AI-265", "Mykyta Tkach"),
                new Student(new int[] {95, 100, 90, 95}, "AI-263", "Mariya Melnyk"),
                new Student(new int[] {70, 50, 60, 75}, "AI-261", "Viktor Zaharchuk"),
                new Student(new int[] {65, 70, 75, 70}, "AI-267", "Olena Ivanenko"),
        };

        Predicate noDebts = o -> {
            Student student = (Student) o;
            for (int mark : student.getMarks()) {
                if (mark<60) return false;
            }
            return true;
        };

        Student[] successful = filter(students, noDebts);

        for (Student s : successful) {
            System.out.println(s.getName());
        }

        System.out.println("Task 3:");
        Predicate fromGroup267 = o -> {
            Student student = (Student) o;
            return student.getGroup().equals("AI-267");
        };

        Student[] successfulFrom267 = filterWithTwoConditions(students, noDebts, fromGroup267);

        for (Student s : successfulFrom267) {
            System.out.println(s.getName());
        }

        System.out.println("Task 4:");
        Consumer printName = o -> {
            Student s = (Student) o;
            System.out.println(s.getName());
        };
        Arrays.asList(students).forEach(printName);

        System.out.println("Task 5:");
        Predicate isOdd = o -> {
            int i = (int) o;
            if (i%2!=0) {
                return true;
            }
            return false;
        };
        Consumer printNumber = o -> {
            int i = (int) o;
            System.out.println(i);
        };

        int[] array = {1,2,3453,345,1234,163,7148,1468};

        process(array,isOdd,printNumber);

        System.out.println("Task 6:");

        array = new int[]{10, 21, 4, 6, 14, 32, 19, 15};

        Function power = o -> {
            int i = (int) o;
            return (int) Math.pow(2,i);
        };

        int[] results = processArray(array, power);
        for (int r : results) {
            System.out.println(r);
        }

        System.out.println("Task 7:");

        array = new int[10];
        for (int i = 0; i < 10; i++) {
            array[i] = i;
        }

        String[] words = {"Нуль", "Один", "Два", "Три", "Чотири", "П'ять", "Шість", "Сім", "Вісім", "Дев'ять"};

        Function numberToString = o -> {
            int i = (int) o;
            return words[i];
        };

        String[] result = stringify(array, numberToString);
        for (String r : result) {
            System.out.println(r);
        }

    }
}
