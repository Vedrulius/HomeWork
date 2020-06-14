package com.mihey.hello;

public class Hello {
    private String name;
    private int age;

    public Hello SetValues() {
        this.name = "Mike";
        this.age = 25;
        return this;
    }

    public void display() {
        System.out.println("name: " + name);
        System.out.println("age: " + age);
    }

    public static void main(String args[]) {
        System.out.println((char)('a'+1));
//        Hello obj = new Hello();
////        obj = obj.SetValues();
//        obj.display();
    }
}



