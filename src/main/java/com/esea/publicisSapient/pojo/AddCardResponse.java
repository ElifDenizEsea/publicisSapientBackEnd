package com.esea.publicisSapient.pojo;

import com.esea.publicisSapient.repository.model.Card;

public class AddCardResponse {
    /*
     * Object for responding add card request in json format
     * */
    private Card card;
    private String description;
    public AddCardResponse(Card card, String description){
        this.card=card;
        this.description=description;
    }
    public AddCardResponse(String description){
        this.description=description;
    }
    public AddCardResponse(){
    }
    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
