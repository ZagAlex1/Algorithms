package Lesson1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Seminar {
    public static void main(String[] args) {
        int lastNumber = 20;
        AtomicInteger counter = new AtomicInteger();
        System.out.printf("(1) Сумма чисел от 1 до %d равна %d\n", lastNumber, sum(lastNumber, counter));
        System.out.println("Количество итераций: " + counter.get());
        System.out.printf("(2) Сумма чисел от 1 до %d равна %d\n", lastNumber, sumV2(lastNumber));

        counter.set(0);
        System.out.printf("Простые числа в диапазоне от 1 до %d:\n%s\n", lastNumber, findSimpleNumbers(lastNumber, counter));
        System.out.println("Количество итераций: " + counter.get());

        counter.set(0);
        long startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для номера %d равно: %d (рекурсия)\n", lastNumber, fb1(lastNumber, counter));
        System.out.println("Количество итераций: " + counter.get());
        long endTime = System.currentTimeMillis();
        System.out.printf("Операция выполнена за %d мс.", endTime - startTime);

        counter.set(0);
        startTime = System.currentTimeMillis();
        System.out.printf("Число Фибоначчи для номера %d равно: %d (цикл)\n", lastNumber, fb2(lastNumber, counter));
        System.out.println("Количество итераций: " + counter.get());
        endTime = System.currentTimeMillis();
        System.out.printf("Операция выполнена за %d мс.", endTime - startTime);
    }

    //Линейная сложность O(n)
    public static int sum(int lastNumber, AtomicInteger c) {
        int sum = 0;
        for (int i = 1; i <= lastNumber; i++) {
            sum += i;
            c.getAndIncrement();
        }
        return sum;
    }

    //Константная сложность O(1)
    public static int sumV2(int lastNumber) {
        return ((1 + lastNumber) * lastNumber) / 2;
    }

    //Квадратичная сложность O(n^2)
    public static ArrayList<Integer> findSimpleNumbers(int lastNumber, AtomicInteger counter) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= lastNumber; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter.getAndIncrement();
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        return result;
    }

    static void f(int n) {
        System.out.println(n);
        if (n >= 3) {
            f(n - 1);
            f(n - 2);
            f(n - 2);
        }
    }

    //Экспоненциальная сложность O(e^n)
    public static long fb1(int num, AtomicInteger counter) {
        counter.getAndIncrement();
        if (num == 0 || num == 1)
            return num;
        return fb1(num - 1, counter) + fb1(num - 2, counter);
    }

    //Линейная сложность
    public static int fb2(int num, AtomicInteger counter) {
        if (num == 0 || num == 1)
            return num;
        int[] array = new int[num + 1];
        array[0] = 0;
        array[1] = 1;
        for (int i = 2; i < array.length; i++) {
            counter.getAndIncrement();
            array[i] = array[i - 1] + array[i - 2];
        }
        return array[num];
    }
}
