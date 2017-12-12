package com.mihey.homework.rometoarabic;

import static com.mihey.homework.rometoarabic.RomeToArabicConverter.RomeNumbers.getNumber;

class RomeToArabicConverter {
    static int convertRomeToArabic(String romeNumber) {
        int result = 0;
        for (int i = romeNumber.length() - 1; i >= 0; i--) {
            int curr = getNumber(romeNumber.charAt(i));
            if (i == 0) {
                result += curr;
                return result;
            }
            int prev = getNumber(romeNumber.charAt(i - 1));
            if (curr > prev) {
                result -= prev;
                i--;
            }
            result += curr;
        }
        return result;
    }

    enum RomeNumbers {
        I(1), V(5), X(10), L(50), C(100), D(500), M(1000);

        private int value;

        RomeNumbers(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static int getNumber(char num) {
            return RomeNumbers.valueOf(num + "").getValue();
        }
    }
}