// Lista 3, Zad 1
// Autor: Jonasz Lazar
// Indeks: 263898

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Basket {

    private final List<Product> productsInBasket = new ArrayList<>();

    public String addProductFromShopToBasket(String productName, List<Product> productsInShop) {
        for (Product product : productsInShop) {
            if (product.getProductName().matches(productName)) {
                productsInBasket.add(product);
                return product.getProductCode();
            }
        }
        return null;
    }

    public void removeProductFromBasket(String productCode) {
        for (Product product : productsInBasket) {
            if (Objects.equals(product.getProductCode(), productCode)) {
                productsInBasket.remove(product);
                break;
            }
        }
    }

    public float basketValue() {

        float price = 0;
        for (Product product : productsInBasket) {
            price += product.getProductPrice();
        }
        return price;
    }

    public List<Product> getProductsInBasket() {
        return productsInBasket;
    }

    public void printBasket() {
        for (Product product : productsInBasket) {
            System.out.printf("Kod: %s, nazwa: %s, cena: %.2f zł\n", product.getProductCode(), product.getProductName(), product.getProductPrice());
        }
    }
}
