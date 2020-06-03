package com.mihey.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hello {
    private String name;
    private int age;
    public Hello SetValues(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the student: ");
        String name = sc.nextLine();
        System.out.println("Enter the age of the student: ");
        int age = sc.nextInt();
        this.name = name;
        this.age = age;
        return this;
    }
    public void display() {
        System.out.println("name: "+name);
        System.out.println("age: "+age);
    }
    public static void main(String args[]) {
//        Hello obj = new Hello();
//        obj = obj.SetValues();
//        obj.display();
        System.out.println("1".matches("."));
    }
}



