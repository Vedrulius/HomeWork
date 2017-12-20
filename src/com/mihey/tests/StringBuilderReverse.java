package com.mihey.tests;

public class StringBuilderReverse {


    public String reverseString(String str) {

        return new StringBuilder(str).reverse().toString();
    }
}

