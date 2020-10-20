package com.mihey.hello;


import java.time.LocalTime;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        LocalTime lt = LocalTime.of(20,0);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, LocalTime> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(sc.next(),LocalTime.parse(sc.next()));
            sc.nextLine();
        }
        for (String s : map.keySet()) {
            if(map.get(s).isAfter(lt)) {
                System.out.println(s);
            }
        }
    }
}
class ComplexNumber {

    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        return Double.compare(that.re, re) == 0 &&
                Double.compare(that.im, im) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(re, im);
    }
}





