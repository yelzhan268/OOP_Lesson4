package lesson4.gb_collections.lists;

import java.util.Iterator;

import org.w3c.dom.Node;

import lesson4.gb_collections.GbList;
import lesson4.gb_collections.lists.util.ArrayIterator;

public class GbLinkedList<E> implements GbList<E> {
    private E[] values;
    private int size;
    private Node<E> head;

    public GbLinkedList() {
        this.size = size;
        this.values = (E[]) new Object[size];
    }

    @Override
    public void add(E value) {
        if (head == null) {
            this.head = new Node<>(value);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(value);
        }
        size++;
    }

    @Override
    public void add(int index, E value) {
        values[index] = value;
    }

    @Override
    public E get(int index) {
        int count = 0;
        Node<E> current = head;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.value;
    }

    @Override
    public void remove(E value) {
        // for (int i = 0; i < values.length; i++) {
        //     if (values[i].equals(value)) {
        //         removeByIndex(i);
        //         size--;
        //         return;
        //     }
        // }
        // throw new RuntimeException("Element was not found");
        // head = head.next;
        int count = 0;
        while (head == value) {
            count++;
            head = head.next;
            System.out.println(head);
        }
        removeByIndex(count);
        size--;
        // System.out.println(head);
    }
    @Override
    public void removeByIndex(int index) {
        if (index == 0) {
            head = head.next != null ? head = head.next : null;
            size--;
            return;
        }
        int count = 0;
        Node<E> prev = null;
        Node<E> current = head;
        while (count != index) {
            prev = current;
            current = current.next;
            count++;
        }
        if (prev != null) {
            prev.next = current.next;   
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(toArray());
    }
    public E[] toArray() {
        E[] result = (E[]) new Object[size];
        Node<E> prev = null;
        Node<E> current = head;
        int i = 0;
        while (current.next != null) {
            result[i] = current.value;
            current = current.next;
            i++;
        }
        return result;
    }
    private static class Node<E> {
        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        Node<E> current = head;
        while (current != null) {
            builder.append(current.value).append(", ");
            current = current.next;
        }
        if (builder.length() == 1) {
            return "[]";
        }
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
