package com.mihey.testpackage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String number=sc.nextLine();

        String str1 = "[\\s]*[+]?[(][\\w]{1,}[)]([- ][\\w]{2,})*";
        String str2 = "[\\s]*[+]?[\\w]{1,}[\\s-][(][\\w]{2,}[)]([- ]?[\\w]{2,})*";
        String str3 = "[\\s]*[+]?[\\w]{1,}([- ][\\w]{2,})*";
        Pattern pattern = Pattern.compile(str1);
        Matcher matcher = pattern.matcher(number);
        Pattern pattern1 = Pattern.compile(str2);
        Matcher matcher1 = pattern1.matcher(number);
        Pattern pattern2 = Pattern.compile(str3);
        Matcher matcher2 = pattern2.matcher(number);
        System.out.println(matcher.matches() || matcher1.matches() || matcher2.matches());
    }

}