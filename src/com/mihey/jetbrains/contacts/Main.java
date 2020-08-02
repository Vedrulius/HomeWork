package com.mihey.jetbrains.contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        List<Contact> account = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String action = getAction();
        while (!action.equals("exit")) {
            switch (action) {
                case "add":
                    account.add(addingContact());
                    action = getAction();
                    break;
                case "remove":
                    if (account.size() != 0) {
                        listingContact(account);
                        removingContact(account);
                        action = getAction();
                    } else {
                        System.out.println("No records to remove!");
                        action = getAction();
                    }
                    break;
                case "edit":
                    if (account.size() == 0) {
                        System.out.println("No records to edit!");
                        action = getAction();
                        break;
                    }
                    listingContact(account);
                    editingContact(account);
                    action = getAction();
                    break;
                case "count":
                    System.out.println("The Phone Book has " + account.size() + " records.");
                    action = getAction();
                    break;
                case "list":
                    listingContact(account);
                    action = getAction();
                    break;
            }
        }
    }


    static void listingContact(List<Contact> list) {
        int count = 1;
        for (Contact contact : list) {
            System.out.printf("%d. %s %s, %s\n", count, contact.getName(), contact.getLastName(), contact.getPhoneNumber());
            count++;
        }
    }

    static List<Contact> removingContact(List<Contact> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a record: ");
        int rec = sc.nextInt() - 1;
        list.remove(rec);
        System.out.println("The record removed!");
        return list;
    }

    static boolean isValid(String number)
    {
        String str1 = "[\\s]*[+]?[(][\\w]{1,}[)]([- ][\\w]{2,})*";
        String str2 = "[\\s]*[+]?[\\w]{1,}[\\s-][(][\\w]{2,}[)]([- ]?[\\w]{2,})*";
        String str3 = "[\\s]*[+]?[\\w]{1,}([- ][\\w]{2,})*";
        Pattern pattern = Pattern.compile(str1);
        Matcher matcher = pattern.matcher(number);
        Pattern pattern1 = Pattern.compile(str2);
        Matcher matcher1 = pattern1.matcher(number);
        Pattern pattern2 = Pattern.compile(str3);
        Matcher matcher2 = pattern2.matcher(number);
        if(matcher.matches() || matcher1.matches() || matcher2.matches())
            return true;
        else
            return false;
    }

    static List<Contact> editingContact(List<Contact> list) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a record: ");
        int rec = sc.nextInt() - 1;
        sc.nextLine();
        System.out.println("Select a field (name, surname, number): ");
        String field = sc.nextLine();
        System.out.printf("Enter %s: \n", field);
        switch (field) {
            case "name":
                Contact name = list.get(rec);
                name.setName(sc.nextLine());
                list.set(rec, name);
                break;
            case "surname":
                Contact lastName = list.get(rec);
                lastName.setLastName(sc.nextLine());
                list.set(rec, lastName);
                break;
            case "number":
                Contact number = list.get(rec);
                String phoneNum = sc.nextLine();
                if (!isValid(phoneNum)) {
                    System.out.println("Wrong number format!");
                    phoneNum = "[no number]";
                }
                number.setPhoneNumber(phoneNum);
                list.set(rec, number);

                break;
        }
        System.out.println("The record updated!");
        return list;
    }

    static Contact addingContact() {
        Scanner sc = new Scanner(System.in);
        String name;
        String surName;
        String phoneNumber;

        System.out.println("Enter the name: ");
        name = sc.nextLine();
        System.out.println("Enter the surname: ");
        surName = sc.nextLine();
        System.out.println("Enter the number: ");
        phoneNumber = sc.nextLine();
        if (!isValid(phoneNumber)) {
            System.out.println("Wrong number format!");
            phoneNumber = "[no number]";
        }
        System.out.println("The record added.");
        return new Contact(name, surName, phoneNumber);
    }

    static String getAction() {
        System.out.println("Enter action (add, remove, edit, count, list, exit): ");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        while (!action.matches("(add|remove|edit|count|list|exit)")) {
            System.out.println("Enter action (add, remove, edit, count, list, exit): ");
            action = scanner.nextLine();
        }
        return action;
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
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

class PhoneBook {

    private final Contact contact;

    public PhoneBook(Contact contact) {
        this.contact = contact;
    }
}
