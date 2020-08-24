package com.mihey.homework.generics;

public class Multiplicator {


    public static <T extends Copy<T>> Folder<T>[] multiply(Folder<T> folder, int arraySize) {
        Folder<T>[] f = new Folder[arraySize];
        for (int i = 0; i < arraySize; i++) {
            Folder<T> f1 = new Folder();
            f1.put(folder.get().copy());
            f[i] = f1;
        }
        return f;
    }

    public static void main(String[] args) {
        System.out.println("Well done!");
    }

}

// Don't change the code below
interface Copy<T> {
    T copy();
}

class Folder<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }
}

