package ru.clevertec.check.dto;

import java.util.HashMap;
import java.util.Map;

public class InputDto {
    private Map<Integer, Integer> idToQuantity = new HashMap<>();
    private Integer discountCard;
    private Double balanceDebitCard;







    public Map<Integer, Integer> getIdToQuantity() {
        return idToQuantity;
    }

    public void setIdToQuantity(Map<Integer, Integer> idToQuantity) {
        this.idToQuantity = idToQuantity;
    }

    public Integer getDiscountCard() {
        return discountCard;
    }

    public void setDiscountCard(Integer discountCard) {
        this.discountCard = discountCard;
    }

    public Double getBalanceDebitCard() {
        return balanceDebitCard;
    }

    public void setBalanceDebitCard(Double balanceDebitCard) {
        this.balanceDebitCard = balanceDebitCard;
    }
}
