package com.myorg.service;

import java.math.BigDecimal;
import java.util.Map;

import com.myorg.exception.NotEnoughProductsInStockException;
import com.myorg.model.Product;

public interface ShoppingCartService {

    void addProduct(Product product);

    void removeProduct(Product product);

    Map<Product, Integer> getProductsInCart();

    void checkout() throws NotEnoughProductsInStockException;

    BigDecimal getTotal();
}
