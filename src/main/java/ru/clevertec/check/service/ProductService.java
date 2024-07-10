package ru.clevertec.check.service;

import ru.clevertec.check.exception.ExceptionCode;
import ru.clevertec.check.exception.MyException;
import ru.clevertec.check.io.ProductReader;
import ru.clevertec.check.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductService {

    private ProductReader productReader  = new ProductReader();


    public Map<Integer, Product> createBasket(Map<Integer, Integer> productIdOnQuantity) {
        HashMap<Integer, Product> basket = new HashMap<>();
        for(int id: productIdOnQuantity.keySet()){
            Product product = productReader.findById(id);
            checkProductQuantity(productIdOnQuantity.get(id), product);
                    basket.put(id, product);
        }
        return basket;
    }


    private void checkProductQuantity(Integer quantity, Product product){
        if (quantity>product.getQuantityInStock()){
            throw new MyException(ExceptionCode.BAD_REQUEST.name());
        }
    }
}
