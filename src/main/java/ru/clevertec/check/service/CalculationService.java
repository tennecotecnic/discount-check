package ru.clevertec.check.service;

import ru.clevertec.check.dto.BasketOutputDto;
import ru.clevertec.check.dto.InputDto;
import ru.clevertec.check.dto.ProductItemDto;
import ru.clevertec.check.exception.ExceptionCode;
import ru.clevertec.check.exception.MyException;
import ru.clevertec.check.model.Card;
import ru.clevertec.check.model.Product;
import java.util.Map;

public class CalculationService {


    private ProductService productService = new ProductService();
    private CardService cardService = new CardService();


    public BasketOutputDto process(InputDto inputDto) {
        checkData(inputDto);
        Map<Integer, Product> basketProducts = productService.createBasket(inputDto.getIdToQuantity());
        Card card = cardService.findCard(inputDto.getDiscountCard());
        BasketOutputDto basketOutputDto = new BasketOutputDto();
        for(Product product: basketProducts.values()) {
            basketOutputDto.addProductItem(
                    calculateProductItem(product, card, inputDto)
            );
        }
        return basketOutputDto;
    }


    private ProductItemDto calculateProductItem(Product product, Card card, InputDto inputDto) {
        ProductItemDto productItemDto = new ProductItemDto();
        productItemDto.setQuantity(inputDto.getIdToQuantity().get(product.getIdProduct()));
        productItemDto.setDescription(product.getDescription());
        productItemDto.setPrice(productItemDto.getPrice());
        productItemDto.setDiscount(card.getDiscountAmount()*productItemDto.getPrice()/100);
        productItemDto.setTotal(card.getDiscountAmount()*productItemDto.getPrice()/100); //ljltkfnm
        return productItemDto;
    }

    private void checkData(InputDto inputDto) {
        if (inputDto.getBalanceDebitCard() < 0) {
            throw new MyException(ExceptionCode.NOT_ENOUGH_MONEY.getTitle());
        }
        if (inputDto.getDiscountCard() == null) {
            throw new MyException(ExceptionCode.BAD_REQUEST.getTitle());
        }
    }
}