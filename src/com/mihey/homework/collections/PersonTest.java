package com.mihey.homework.collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;

    @BeforeEach
    void setUp() {
        person = new Person("Mikhail", "Dolgov");
    }

    @Test
    void testBothNamesEquals() {
        assertTrue(person.compareTo(new Person("Mikhail", "Dolgov")) == 0);
    }@Test
    void testNameIsDifferent() {
        assertTrue(person.compareTo(new Person("Alex", "Dolgov")) > 0);
        assertTrue(person.compareTo(new Person("Natalya", "Dolgov")) < 0);
    }@Test
    void testLastNameIsDifferent() {
        assertTrue(person.compareTo(new Person("Mikhail", "Ivanov")) < 0);
        assertTrue(person.compareTo(new Person("Mikhail", "Dolgoff")) > 0);
    }
}
