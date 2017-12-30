package com.mihey.homework.collections;

public class Person implements Comparable<Person> {

    private String name;

    public Person(String personName) {
        name = personName;
    }

    private String getName() {
        return name;
    }

    @Override
    public int compareTo(Person person) {

        return name.compareToIgnoreCase(person.getName());
    }
}
