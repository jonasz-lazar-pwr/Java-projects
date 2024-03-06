// Lista 3, Zad 1
// Autor: Jonasz Lazar
// Indeks: 263898

package com.company;

import java.util.*;

public class Shop {

    private final List<Product> productsInShop = new ArrayList<>();

    public void getProductsFromFile() throws MyException {
        AvailableProducts.getProductsFromFile(productsInShop);
    }

    public String addProductFromBasketToShop(String productName, List<Product> productsInBasket) {
        for (Product product : productsInBasket) {
            if (product.getProductName().matches(productName)) {
                productsInShop.add(product);
                return product.getProductCode();
            }
        }
        return null;
    }

    public void removeProductFromShop(String productCode) {
        for (Product product : productsInShop) {
            if (Objects.equals(product.getProductCode(), productCode)) {
                productsInShop.remove(product);
                break;
            }
        }
    }

    public List<Product> getProductsInShop() {
        return productsInShop;
    }

    public void printShop() {
        for (Product product : productsInShop) {
            System.out.printf("Kod: %s, nazwa: %s, cena: %.2f zł\n", product.getProductCode(), product.getProductName(), product.getProductPrice());
        }
    }
}
