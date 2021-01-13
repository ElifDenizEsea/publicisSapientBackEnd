package com.esea.publicisSapient.util;

public class CardNumberValidator {
    /**
     * A utility class
     * for validations on card number
     */

    public static boolean checkDigits(String cardNo) {
        String regex = "[0-9]*";
        return cardNo.matches(regex);
    }

    public static boolean checkLength(String cardNo) {
        return cardNo.length() > 0 && cardNo.length() <= 19;
    }

    public static boolean checkLuhn(String cardNo) {
        int nDigits = cardNo.length();

        int nSum = 0;
        boolean isSecond = false;
        for (int i = nDigits - 1; i >= 0; i--) {

            int d = cardNo.charAt(i) - '0';

            if (isSecond)
                d = d * 2;

            nSum += d / 10;
            nSum += d % 10;

            isSecond = !isSecond;
        }
        return (nSum % 10 == 0);
    }


}
