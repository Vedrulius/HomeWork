package com.mihey.testpackage;

import java.util.*;
import java.util.function.LongUnaryOperator;


class Test  {

    public static LongUnaryOperator unaryOperator = x ->
            (x & 1) == 0 ? x + 2 : x + 1;
}