package com.esea.publicisSapient.service;

import com.esea.publicisSapient.TestUtil;
import com.esea.publicisSapient.pojo.AddCardRequest;
import com.esea.publicisSapient.pojo.AddCardResponse;
import com.esea.publicisSapient.pojo.GetCardsResponse;
import com.esea.publicisSapient.repository.CardRepository;
import com.esea.publicisSapient.repository.model.Card;
import com.esea.publicisSapient.util.Constants;
import com.esea.publicisSapient.util.InvalidCardNumberException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CardServiceTest {

    CardRepository repository = Mockito.mock(CardRepository.class);

    private CardService service;

    @Before
    public void setup() {
        service = new DefaultCardService(repository);
    }

    @Test
    public void addCardSuccess() throws Exception {

        AddCardRequest request = TestUtil.getAddCardRequest();
        when(repository.save(any())).thenReturn(TestUtil.getCard());
        AddCardResponse result = service.addCard(request);
        Assert.assertEquals(result.getDescription(), Constants.CARD_CREATE_SUCCESS);
    }

    @Test
    public void addCardLengthValidationFail() {
        AddCardRequest request = TestUtil.getAddCardRequest();
        request.setNumber("");
        when(repository.save(any())).thenReturn(TestUtil.getCard());
        Throwable result = assertThrows(InvalidCardNumberException.class, () -> service.addCard(request));
        Assert.assertEquals(result.getMessage(), Constants.CARD_NUMBER_INVALID_LENGTH);
    }

    @Test
    public void addCardDigitValidationFail() {
        AddCardRequest request = TestUtil.getAddCardRequest();
        request.setNumber("a");
        when(repository.save(any())).thenReturn(TestUtil.getCard());

        Throwable result = assertThrows(InvalidCardNumberException.class, () -> service.addCard(request));
        Assert.assertEquals(result.getMessage(), Constants.CARD_NUMBER_INVALID_DIGITS);
    }

    @Test
    public void addCardLuhnValidationFail() {
        AddCardRequest request = TestUtil.getAddCardRequest();
        request.setNumber("12");
        when(repository.save(any())).thenReturn(TestUtil.getCard());
        Throwable result = assertThrows(InvalidCardNumberException.class, () -> service.addCard(request));
        Assert.assertEquals(result.getMessage(), Constants.CARD_NUMBER_INVALID_LUHN);
    }

    @Test
    public void getCardSuccess(){

        Card card1=TestUtil.getCard();
        Card card2=TestUtil.getCard();
        card2.setNumber("1");
        List<Card> cards=new ArrayList<>();
        cards.add(card1);
        cards.add(card2);
        when(repository.findAll()).thenReturn(cards);
        GetCardsResponse result = service.getAllCards();
        Assert.assertEquals(result.getDescription(), Constants.GET_CARDS_SUCCESS);
        Assert.assertEquals(result.getCards().size(),2);
    }
}
