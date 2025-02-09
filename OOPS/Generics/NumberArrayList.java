package OOPS.Generics;

import java.util.Arrays;

// Wildcards Example
public class NumberArrayList<T extends Number> {
    private Object[] data;
    private static final int DEFAULT_SIZE = 10;
    private int size;

    public NumberArrayList() {
        this.data = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public void add(T item) {
        if (isFull()) {
            resize();
        }
        data[size++] = item;
    }

    private boolean isFull() {
        return size == data.length;
    }

    private void resize() {
        Object[] temp = new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void printList() {
        System.out.println(Arrays.toString(Arrays.copyOf(data, size)));
    }

    public static void printNumbers(NumberArrayList<? extends Number> list) {
        System.out.print("Numbers in list: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
