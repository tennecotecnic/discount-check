package ru.clevertec.check.service;

import ru.clevertec.check.model.Card;
import ru.clevertec.check.io.CardReader;

public class CardService {

    private Card card;
    private CardReader cardReader = new CardReader();

    public Card findCard(int cardNumber){
        card = cardReader.findByNumber(cardNumber);
        return card;
    }

    public Card getCard() {
        return card;
    }
}
