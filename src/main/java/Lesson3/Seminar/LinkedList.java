package Lesson3.Seminar;


import java.util.Comparator;

/**
 * Связный список
 *
 * @param <T>
 */

public class LinkedList<T> {

    /**
     * Указатель на первый элемент связного списка
     */
    private Node head;

    /**
     * Узел связного списка
     */
    public class Node {

        /**
         * Переменная которая указывает на следующий узел
         */
        public Node next;

        /**
         * Переменная указывающая на фактическое значение нашего узла
         */
        public T value;

    }

    /**
     * Добавление нового элемента в начало связного списка
     *
     * @param value значение
     */
    public void addFirst(T value) {
        Node node = new Node();
        node.value = value;
        if (head != null) {
            node.next = head;
        }
        head = node;
    }

    public void reverse() {
        Node node = head;
        Node prevNode = null;
        while (node != null) {
            Node buf = node.next;
            node.next = prevNode;
            prevNode = node;
            node = buf;
        }
        head = prevNode;
    }

    /**
     * Удалить первый элемент связного списка
     */
    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    /**
     * Добавить элемент в конец списка
     *
     * @param value
     */
    public void addLast(T value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
        } else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = node;
        }
    }

    /**
     * Удалить последний элемент связного списка
     */
    public void removeLast() {
        if (head == null) {
            return;
        }
        Node node = head;

        while (node.next != null) {
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
        head = null;
    }

    /**
     * Поиск элементов в связном списке по значению
     *
     * @param value значение
     * @return нашел или нет
     */
    public boolean contains(T value) {
        Node node = head;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void sort(Comparator<T> comparator) {
        Node node = head;
        while (node != null) {

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null) {
                if (comparator.compare(minValueNode.value, node2.value) > 0) {
                    minValueNode = node2;
                }
                node2 = node2.next;
            }

            if (minValueNode != node) {
                T buf = node.value;
                node.value = minValueNode.value;
                minValueNode.value = buf;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.value);
            stringBuilder.append('\n');
            node = node.next;
        }
        return stringBuilder.toString();
    }
}
