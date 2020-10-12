package com.owen.array;

public class Array {
    //定义整型数据data保存数据
    public int[] data;
    //定义数组长度
    private int n;
    //定义中实际个数
    private int count;

    //构造方法，定义数组大小
    public Array(int capacity) {
        data = new int[capacity];
        n = capacity;
        count = 0;
    }

    //根据索引，找到数据中的元素并返回
    public int find(int index) {
        return data[index];
    }

    //插入元素:头部插入，尾部插入
    public boolean insert(int index, int value) {
        if (index < 0 || index >= data.length) {
            System.out.println("插入位置不合法");
            return false;
        }
        if (count == n) {
            System.out.println("当前数组已满");
            return false;
        }
        if (count - index >= 0) System.arraycopy(data, index, data, index + 1, count - index);
        data[index] = value;
        count++;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index) {
        if (index < 0 || index >= data.length) {
            System.out.println("删除位置不合法");
            return false;
        }
        if (isEmpty()) {
            System.out.println("当前数组为空");
            return false;
        }
        if (count - index >= 0) System.arraycopy(data, index + 1, data, index, count - index);
        count--;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int length() {
        return count;
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();

        array.insert(5, 12);
        array.printAll();

        array.insert(1, 11);
        array.printAll();

        array.delete(4);
        array.printAll();

        array.delete(10);
    }
}
