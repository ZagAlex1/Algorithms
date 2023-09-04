package Lesson3.Seminar;

import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
//        Employee employee1 = new Employee("CCCC",40);
//        LinkedList<Employee> employeeLinkedList = new LinkedList<>();
//        employeeLinkedList.addFirst(new Employee("AAAAAA",21));
//        employeeLinkedList.addFirst(new Employee("BBB",33));
//        employeeLinkedList.addFirst(employee1);
//
//        boolean res = employeeLinkedList.contains(employee1);
//        System.out.println(res);

        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.addFirst(1);
        numbers.addFirst(2);
        numbers.addFirst(3);
        numbers.addFirst(4);

        System.out.println(numbers.toString());
        numbers.reverse();
        System.out.println(numbers.toString());
    }
}
