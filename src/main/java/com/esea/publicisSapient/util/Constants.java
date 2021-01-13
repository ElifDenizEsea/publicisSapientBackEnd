package com.esea.publicisSapient.util;

public class Constants {
    /*
    * Constants to be used all over the service
    * */
    public static final String CARD_CREATE_SUCCESS="New Card created successfully";
    public static final String CARD_CREATE_FAIL="New Card can not be created :";
    public static final String CARD_NUMBER_INVALID_LUHN="Card number is not compatible with Luhn 10";
    public static final String CARD_NUMBER_INVALID_DIGITS="Card number should only have digits";
    public static final String CARD_NUMBER_INVALID_LENGTH="Card number length must be between 1-19";
    public static final String CARD_NUMBER_EXIST="Card number already exists";

    public static final String GET_CARDS_EMPTY="No Cards found";
    public static final String GET_CARDS_SUCCESS="All cards retrieved successfully";
    public static final String GET_CARDS_FAIL="There is a problem with retrieving: ";
}
