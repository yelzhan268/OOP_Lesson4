package lesson4.gb_collections.lists;

import lesson4.gb_collections.GbList;
import lesson4.gb_collections.lists.util.ArrayIterator;

import java.util.Iterator;

public class GbArrayList<E> implements GbList<E> {
    private E[] values;
    private int size;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public GbArrayList() {
        this.size = 0;
        this.capacity = 10;
        try {
            this.values = (E[]) new Object[capacity];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        
    }

    private void addCapacity() {
        capacity = capacity + capacity / 2;
        E[] array = (E[]) new Object[capacity];
        System.arraycopy(values, 0, array, 0, values.length);
        this.values = array;
    }

    @Override
    public void add(E value) {
        if (size == capacity) {
            addCapacity();
        }
        values[size++] = value;
    }

    @Override
    public void add(int index, E value) {

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public void remove(E value) {
        for (int i = 0; i < values.length; i++) {
            if (values[i].equals(value)) {
                removeByIndex(i);
                return;
            }
        }
        throw new RuntimeException("Element was not found");
    }

    @Override
    public void removeByIndex(int index) {
        capacity = capacity - 1;
        E[] res  = (E[]) new Object[capacity];
        System.arraycopy(values, 0, res, 0, index);
        int amountElementsAfterIndex = values.length - index - 1;
        System.arraycopy(values, index + 1, res, index, amountElementsAfterIndex);
        size--;
        values = res;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<>(values);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        int i = 0;
        while (values[i] != null) {
            builder.append(values[i]).append(", ");
            i++;
        }
        if (builder.length() == 1)
            return "[]";
        builder.deleteCharAt(builder.length() - 1).deleteCharAt(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }
}
