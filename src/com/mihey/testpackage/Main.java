package com.mihey.testpackage;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the person:");
        String name = sc.nextLine();
        System.out.println("Enter the surname of the person:");
        String surname = sc.nextLine();

        System.out.println("EEnter the number:");
        String number = sc.nextLine();

        System.out.println("A record created!\nA Phone Book with a single record created!");
    }
}

class Contact {

    private String name;
    private String lastName;
    private String phoneNumber;


    public Contact(String name, String lastName, String phoneNumber) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        System.out.println("A record created!");
    }

}

class PhoneBook {
    private Contact contact;

    public PhoneBook(Contact contact) {
        this.contact = contact;
        System.out.println("A Phone Book with a single record created!");
    }
}