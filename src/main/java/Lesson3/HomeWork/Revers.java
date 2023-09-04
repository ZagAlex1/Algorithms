package Lesson3.HomeWork;

import Lesson3.Seminar.LinkedList;

public class Revers {
    public void reverse() {
        LinkedList.Node node = head;
        LinkedList.Node prevNode = null;
        while (node != null) {
            LinkedList.Node next = node.next;
            node.next = prevNode;
            prevNode = node;
            node = next;
        }
        head = prevNode;
    }
}
