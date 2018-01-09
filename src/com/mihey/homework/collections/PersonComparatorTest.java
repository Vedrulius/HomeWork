package com.mihey.homework.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonComparatorTest {

    private final Person EXPECTED = new Person("Mikhail", "Dolgov");
    PersonComparator person;


    @BeforeEach
    void setUp() {
        person = new PersonComparator();
    }

    @Test
    void testBothNamesEquals() {
        assertTrue(person.compare(EXPECTED, new Person("Mikhail", "Dolgov")) == 0);
    }

    @Test
    void testNameIsDifferent() {
        assertTrue(person.compare(EXPECTED, new Person("Alex", "Dolgov")) > 0);
        assertTrue(person.compare(EXPECTED, new Person("Natalya", "Dolgov")) < 0);
    }

    @Test
    void testLastNameIsDifferent() {
        assertTrue(person.compare(EXPECTED, new Person("Mikhail", "Ivanov")) < 0);
        assertTrue(person.compare(EXPECTED, new Person("Mikhail", "Dolgoff")) > 0);
    }

}
