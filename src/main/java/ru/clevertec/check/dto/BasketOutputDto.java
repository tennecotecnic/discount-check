package ru.clevertec.check.dto;

import java.util.ArrayList;
import java.util.List;

public class BasketOutputDto {

    private List<ProductItemDto> productItems = new ArrayList<>();
    private Double totalPrice;
    private Double totalDiscount;
    private Double totalWithDiscount;


    public List<ProductItemDto> getProductItems() {
        return productItems;
    }

    public void addProductItem(ProductItemDto productItemDto) {
        productItems.add(productItemDto);
        totalPrice += productItemDto.getTotal();
        totalDiscount +=productItemDto.getDiscount();
        totalWithDiscount = totalPrice - totalDiscount;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Double getTotalWithDiscount() {
        return totalWithDiscount;
    }

    public void setTotalWithDiscount(Double totalWithDiscount) {
        this.totalWithDiscount = totalWithDiscount;
    }
}
