package com.owen.array;


public class GenericArray<T> {

    private T[] data;

    private int size;

    @SuppressWarnings("unchecked")
    public GenericArray(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public int getCapacity() {
        return data.length;
    }

    public int getCount() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T find(int index) {
        return data[index];
    }

    public boolean insert(int index, T value) {
        checkIndex(index);
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
        return true;
    }

    public boolean delete(int index) {
        checkIndex(index);
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        if (size < data.length / 2) {
            resize(data.length / 2);
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];

        System.arraycopy(data, 0, newData, 0, size);

        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index不合法");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, capacity = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }

    public static void main(String[] args) {
        GenericArray<Integer> genericArray = new GenericArray<>(5);
        genericArray.insert(0, 1);
        genericArray.insert(0, 2);
        genericArray.insert(0, 3);
        genericArray.insert(0, 4);
        genericArray.insert(0, 5);
        System.out.println(genericArray.toString());

        genericArray.insert(0, 6);
        System.out.println(genericArray.toString());

        genericArray.delete(2);
        System.out.println(genericArray.toString());

        genericArray.delete(2);
        System.out.println(genericArray.toString());

    }
}
