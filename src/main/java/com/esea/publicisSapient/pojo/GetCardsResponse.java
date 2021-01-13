package com.esea.publicisSapient.pojo;

import com.esea.publicisSapient.repository.model.Card;

import java.util.List;

public class GetCardsResponse {
    /*
    Response object for get all cards request
    * */
    private List<Card> cards;
    private String description;

    public GetCardsResponse(List<Card> cards, String description) {
        this.cards = cards;
        this.description = description;
    }

    public GetCardsResponse(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
