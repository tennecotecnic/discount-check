package ru.clevertec.check.converter;

import ru.clevertec.check.dto.InputDto;

import java.util.Map;

public class Converter {




    public InputDto convertToDto(String[] args) {
        InputDto inputDto = new InputDto();
        for (String element : args) {
            if (element.contains("discountCard")) {
                String[] cardArgument = element.split("=");
                inputDto.setDiscountCard(Integer.valueOf(cardArgument[1]));
            } else if (element.contains("balanceDebitCard")) {
                String[] balanceOfDebit = element.split("=");
                inputDto.setBalanceDebitCard(Double.valueOf(balanceOfDebit[1]));
            } else {
                String[] productAndQuantity = element.split("-");
                int idProduct = Integer.parseInt(productAndQuantity[0]);
                int quantityProduct = Integer.parseInt(productAndQuantity[1]);
                Map<Integer, Integer> idToQuantity = inputDto.getIdToQuantity();
                if (idToQuantity.containsKey(idProduct)) {
                    if (idToQuantity.containsKey(idProduct)) {
                        idToQuantity.replace(idProduct, idToQuantity.get(idProduct) + quantityProduct);
                    } else {
                        idToQuantity.put(idProduct, quantityProduct);
                    }
                }
            }
        }
        return inputDto;
    }


}
