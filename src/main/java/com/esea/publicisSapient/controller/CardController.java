package com.esea.publicisSapient.controller;

import com.esea.publicisSapient.pojo.AddCardRequest;
import com.esea.publicisSapient.pojo.AddCardResponse;
import com.esea.publicisSapient.pojo.GetCardsResponse;
import com.esea.publicisSapient.service.CardService;
import com.esea.publicisSapient.util.InvalidCardNumberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.esea.publicisSapient.util.Constants.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CardController {
    @Autowired
    CardService cardService;

    @GetMapping("/getAllCards")
    public ResponseEntity<GetCardsResponse> getAllCards() {
        try {
            GetCardsResponse cards = cardService.getAllCards();

            if (cards.getCards().isEmpty()) {
                //if there are no cards in db
                return new ResponseEntity<>(new GetCardsResponse(GET_CARDS_EMPTY), HttpStatus.NO_CONTENT);
            }
            //for success message
            return new ResponseEntity<>(cards, HttpStatus.OK);
        } catch (Exception e) {
            //exception message for all other possibilities
            return new ResponseEntity<>(new GetCardsResponse(GET_CARDS_FAIL + e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/addCard")
    public ResponseEntity<AddCardResponse> addCard(@RequestBody AddCardRequest request) {
        try {
            AddCardResponse cardResponse = cardService.addCard(request);
            //success message if created
            return new ResponseEntity<>(cardResponse, HttpStatus.CREATED);
        } catch (InvalidCardNumberException ex) {
            //fail response if there is a problem with card number validations
            return new ResponseEntity<>(new AddCardResponse(ex.getMessage()), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            //exception message for all other possibilities
            return new ResponseEntity<>(new AddCardResponse(CARD_CREATE_FAIL + e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
