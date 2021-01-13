package com.esea.publicisSapient.controller;

import com.esea.publicisSapient.TestUtil;
import com.esea.publicisSapient.pojo.GetCardsResponse;
import com.esea.publicisSapient.repository.model.Card;
import com.esea.publicisSapient.service.CardService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
public class CardControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CardService service;

    @Test
    public void shouldReturnAllCards() throws Exception {
        Card card = new Card();
        card.setNumber("1");
        Card card2 = new Card();
        card.setNumber("2");
        List<Card> cards = new ArrayList<>();
        cards.add(card);
        cards.add(card2);
        GetCardsResponse getCardsResponse = new GetCardsResponse(cards, "");
        when(service.getAllCards()).thenReturn(getCardsResponse);
        this.mockMvc.perform(get("/api/getAllCards"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("cards", hasSize(2)));
    }

    @Test
    public void shouldReturnAllCardsEmpty() throws Exception {
        List<Card> cards = new ArrayList<>();
        GetCardsResponse getCardsResponse = new GetCardsResponse(cards, "");
        when(service.getAllCards()).thenReturn(getCardsResponse);
        this.mockMvc.perform(get("/api/getAllCards"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturnOkAddCard() {
        Gson gson = new Gson();
        try {
            when(service.addCard(any())).thenReturn(TestUtil.getAddCardResponse());
            ResultActions result = this.mockMvc.perform(post("/api/addCard")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(gson.toJson(TestUtil.getAddCardRequest())));
            result.andDo(print())
                    .andExpect(status().isCreated());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
