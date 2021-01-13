package com.esea.publicisSapient;

import com.esea.publicisSapient.pojo.AddCardRequest;
import com.esea.publicisSapient.pojo.AddCardResponse;
import com.esea.publicisSapient.repository.model.Card;
import com.esea.publicisSapient.util.Constants;

public class TestUtil {
    /*
    * Utility class for creating entities to be used in tests
    * */
    public static AddCardRequest getAddCardRequest() {
        AddCardRequest request = new AddCardRequest();
        request.setName("elif");
        request.setLimit(1L);
        request.setNumber("79927398713");
        return request;
    }

    public static Card getCard() {
        Card card = new Card();
        card.setBalance(0L);
        card.setCardLimit(1L);
        card.setName("Elif Deniz");
        card.setNumber("79927398713");
        return card;
    }

    public static AddCardResponse getAddCardResponse() {
        AddCardResponse cardResponse = new AddCardResponse();
        cardResponse.setDescription(Constants.CARD_CREATE_SUCCESS);
        cardResponse.setCard(getCard());
        return cardResponse;
    }
}
