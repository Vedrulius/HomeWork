package com.mihey.homework.generics;

public class WildcardPacker {
    public static void main(String[] args) {

    }
}


class Packer {

    public void repackage(Box<? super Bakery> to, Box<? extends Bakery> from) {
        to.put(from.get());
    }

}

// Don't change classes below
class Box<T> {

    private T item;

    public void put(T item) {
        this.item = item;
    }

    public T get() {
        return this.item;
    }

}

class Goods {}

class Food extends Goods {}

class Bakery extends Food {}

class Cake extends Bakery {}

class Pie extends Bakery {}

class Tart extends Bakery {}