package com.company;

import edu.colorado.io.EasyReader;

import java.util.List;
import java.util.Objects;

public class Customer {

    public void goShopping() throws MyException {

        Shop shop = new Shop();
        shop.getProductsFromFile();

        Basket basket = new Basket();

        System.out.println("\nLista produktów dostępnych w sklepie przed zakupami:");
        shop.printShop();

        edu.colorado.io.EasyReader inputLine = new EasyReader(System.in);
        String optionNumber;

        do {
            System.out.println("\nDostępne opcje:");
            System.out.println("[1] Sprawdź, czy wybrany produkt jest dostępny");
            System.out.println("[2] Włóż do koszyka wybrany produkt");
            System.out.println("[3] Wyciągnij z koszyka wybrany produkt");
            System.out.println("[4] Pokaż koszyk");
            System.out.println("[5] Wyceń koszyk");
            System.out.println("[6] Zrealizuj zamówienie");

            System.out.print("\nTwój wybór: ");
            optionNumber = inputLine.stringInput();

            switch (optionNumber) {
                case "1" -> {
                    System.out.print("Podaj nazwę tego produktu: ");
                    countProductInShop(takeProductName(), shop.getProductsInShop());
                }
                case "2" -> {
                    System.out.print("Podaj nazwę tego produktu: ");
                    shop.removeProductFromShop(basket.addProductFromShopToBasket(takeProductName(), shop.getProductsInShop()));
                }
                case "3" -> {
                    System.out.print("Podaj nazwę tego produktu: ");
                    basket.removeProductFromBasket(shop.addProductFromBasketToShop(takeProductName(), basket.getProductsInBasket()));
                }
                case "4" -> {
                    System.out.println("Zawartość twojego koszyka:");
                    basket.printBasket();
                }
                case "5" -> System.out.printf("Wartość produktów w koszyku: %.2f zł\n", basket.basketValue());
                case "6" -> {
                    System.out.println("\nLista produktów dostępnych w sklepie po dokonaniu zakupów:");
                    shop.printShop();
                    FileUpdate.updateFile(shop.getProductsInShop());
                }
                default -> throw new MyException("Błędny wybór opcji!");
            }
        } while (!Objects.equals(optionNumber, "6"));
    }

    public String takeProductName() {

        EasyReader inputLine = new EasyReader(System.in);
        String productName = inputLine.stringInputLine();

        if (productName.contains("?") || productName.contains("*")) {
            return changeToRegex(productName);
        }
        else return productName;
    }

    public String changeToRegex(String productName) {

        return productName.replace("?", ".").replace("*", ".*");
    }

    public void countProductInShop(String productName, List<Product> productsInShop) throws MyException {

        int productQuantity = 0;
        String productToCount = productName;

        for (Product product : productsInShop) {
            if (product.getProductName().matches(productName)) {
                productToCount = product.getProductName();
                break;
            }
        }

        for (Product product : productsInShop) {
            if (Objects.equals(product.getProductName(), productToCount)) {
                productQuantity ++;
            }
        }

        if (productQuantity > 0) {
            System.out.println("Produkt " + productToCount + " jest dostępny w ilości: " + productQuantity);
        } else {
            throw new MyException("Nie znaleziono takiego produktu!");
        }
    }
}
