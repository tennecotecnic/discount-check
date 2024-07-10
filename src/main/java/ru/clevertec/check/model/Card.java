package ru.clevertec.check.model;

public class Card {
    private int numberOfCard;
    private int discountAmount;


    public Card(int numberOfCard, int discountAmount){
        this.numberOfCard = numberOfCard;
        this.discountAmount = discountAmount;
    }


    @Override
    public String toString() {
        return "DISCOUNT CARD;DISCOUNT PERCENTAGE\r\n" + numberOfCard +
                ";" + discountAmount + "%";
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }
}
