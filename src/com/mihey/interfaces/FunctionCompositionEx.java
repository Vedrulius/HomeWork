package com.mihey.interfaces;

import java.util.function.IntUnaryOperator;

public class FunctionCompositionEx {
    public static void main(String[] args) {
        IntUnaryOperator mult2 = num -> num * 2;
        IntUnaryOperator add3 = num -> num + 3;

        IntUnaryOperator combinedOperator = add3.compose(mult2.andThen(add3)).andThen(mult2);
        int result = combinedOperator.applyAsInt(5);
        System.out.println(result);
    }
}
