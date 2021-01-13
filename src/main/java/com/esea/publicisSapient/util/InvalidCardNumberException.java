package com.esea.publicisSapient.util;

public class InvalidCardNumberException extends Exception {
    /*
    * Customized exception for card number validations
    * */
    public InvalidCardNumberException(String message) {
        super(message);
    }
}
