package com.esea.publicisSapient.service;

import com.esea.publicisSapient.pojo.AddCardRequest;
import com.esea.publicisSapient.pojo.AddCardResponse;
import com.esea.publicisSapient.pojo.GetCardsResponse;

public interface CardService {
    /*
    * Service for running business logic for card related operations
    * */
    AddCardResponse addCard(AddCardRequest card) throws Exception;

    GetCardsResponse getAllCards();
}
