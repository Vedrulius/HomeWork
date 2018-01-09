package com.mihey.homework.collections;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        int result = person1.getName().compareToIgnoreCase(person2.getName());
        if (result == 0) {
            return person1.getLastName().compareToIgnoreCase(person2.getLastName());
        }
        return result;
    }
}
