package com.esea.publicisSapient.service;

import com.esea.publicisSapient.pojo.AddCardRequest;
import com.esea.publicisSapient.pojo.AddCardResponse;
import com.esea.publicisSapient.pojo.GetCardsResponse;
import com.esea.publicisSapient.repository.CardRepository;
import com.esea.publicisSapient.repository.model.Card;
import com.esea.publicisSapient.util.CardNumberValidator;
import com.esea.publicisSapient.util.InvalidCardNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.esea.publicisSapient.util.Constants.*;

@Service
public class DefaultCardService implements CardService {
    /*
     * Service for running business logic for card related operations
     * */
    @Autowired
    CardRepository cardRepository;

    public DefaultCardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public AddCardResponse addCard(AddCardRequest cardRequest) throws Exception {
        Card card = new Card();
        card.setBalance(0L);
        card.setName(cardRequest.getName());
        card.setCardLimit(cardRequest.getLimit());
        if (!CardNumberValidator.checkLength(cardRequest.getNumber())) {
            throw new InvalidCardNumberException(CARD_NUMBER_INVALID_LENGTH);
        } else if (!CardNumberValidator.checkDigits(cardRequest.getNumber())) {
            throw new InvalidCardNumberException(CARD_NUMBER_INVALID_DIGITS);
        } else if (!CardNumberValidator.checkLuhn(cardRequest.getNumber())) {
            throw new InvalidCardNumberException(CARD_NUMBER_INVALID_LUHN);
        }
        cardRepository.save(card);

        return new AddCardResponse(card, CARD_CREATE_SUCCESS);
    }

    @Override
    public GetCardsResponse getAllCards() {
        List<Card> cards = new ArrayList<>(cardRepository.findAll());
        return new GetCardsResponse(cards, GET_CARDS_SUCCESS);
    }
}
