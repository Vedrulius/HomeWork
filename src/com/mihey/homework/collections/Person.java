package com.mihey.homework.collections;

public class Person implements Comparable<Person> {

    private String firstName;

    private String lastName;

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    String getFirstName() {
        return firstName;
    }

    String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        int result = firstName.compareToIgnoreCase(person.getFirstName());
        if (result == 0) {
            return lastName.compareToIgnoreCase(person.getLastName());
        }
        return result;
    }
}
