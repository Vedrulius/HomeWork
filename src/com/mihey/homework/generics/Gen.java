package com.mihey.homework.generics;

public class Gen<T> {


    private T ob;

    public Gen(T ob) {
        this.ob = ob;
    }

    T getob() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}
    class GenDemo {
        public static void main(String[] args) {
            Gen<Integer> iob;
            iob = new Gen<>(88);
            iob.showType();
            int v = iob.getob();
            System.out.println("value: " + v);
            Gen<String> strob = new Gen<>("Demo string");
            strob.showType();
            String str=strob.getob();
            System.out.println("value: "  + str);
        }
    }

