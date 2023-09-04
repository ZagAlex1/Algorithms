package Lesson3.Seminar;


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
            Node next = node.next;
            node.next = prevNode;
            prevNode = node;
            node = next;
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

    public void sort() {
        Node node = head;
        while (node != null) {

            Node minValueNode = node;

            Node node2 = node.next;
            while (node2 != null) {

                node2 = node2.next;
            }
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.value);
            stringBuilder.append('\n');
            node = node.next;
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
