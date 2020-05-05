package com.mihey.hello;

public class Solution {
    public static void main(String[] args) {
        Solution c=new Solution();
        c.reverseString(new char[]{'1', '2', '3', 'A', 'B', 'C'});
    }
    public void reverseString(char[] s) {
        System.out.println(s);
        s = new StringBuilder(new String(s)).reverse().toString().toCharArray();
        System.out.println(s);
    }
}
