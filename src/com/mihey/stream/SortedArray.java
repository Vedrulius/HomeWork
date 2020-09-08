package com.mihey.stream;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Write a code that returns the array of sorted integer absolute numbers of the given array.
 * The elements should be sorted in ascending order.
 *
 * Try not to use the for loop, but use Stream API.
 *
 *  Report a typo
 * Sample Input 1:
 *
 * 1 2 6 -3 -9
 * Sample Output 1:
 *
 * 1 2 3 6 9
 */

public class SortedArray {
    public static int[] sortedAbsNumbers(String[] numbers) {
        return Stream.of(numbers).map(Integer::parseInt)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer a) {
                        return Math.abs(a);
                    }
                })
                .sorted()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Arrays.stream(sortedAbsNumbers(scanner.nextLine().split("\\s+")))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "))
        );
    }
}
