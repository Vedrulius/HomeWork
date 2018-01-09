package com.mihey.homework.collections;

public class Person implements Comparable<Person> {

    private String name;

    private String lastName;

    Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    String getName() {
        return name;
    }

    String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        int result = name.compareToIgnoreCase(person.getName());
        if (result == 0) {
            return lastName.compareToIgnoreCase(person.getLastName());
        }
        return result;
    }
}
