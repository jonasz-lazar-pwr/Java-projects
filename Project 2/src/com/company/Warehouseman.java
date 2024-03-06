package com.company;

import edu.colorado.io.EasyReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Warehouseman {

    private final List<Product> productsInWarehouse = new ArrayList<>();

    public void workInWarehouse() throws MyException {

        AvailableProducts.getProductsFromFile(productsInWarehouse);

        System.out.println("\nDostępne opcje:");
        System.out.println("[1] Dodaj artykuł");
        System.out.println("[2] Pobierz artykuł");

        edu.colorado.io.EasyReader input = new EasyReader(System.in);
        String optionNumber;

        System.out.print("Twój wybór: ");
        optionNumber = input.stringInput();

        switch (optionNumber) {
            case "1" -> {
                addProductToWarehouse();
            }
            case "2" -> {
                takeProductFromWarehouse();
            }
            default -> throw new MyException("Błędny wybór opcji!");
        }
    }

    public void addProductToWarehouse() throws MyException {

        EasyReader input = new EasyReader(System.in);
        String productCode;
        String productName;
        float productPrice;
        String toContinue;

        do {
            System.out.print("\nPodaj dwucyfrowy kod produktu: ");
            productCode = takeCode();
            System.out.print("Podaj nazwę produktu: ");
            productName = takeName();
            System.out.print("Podaj cenę produktu (część dziesiętną rozdziel kropką): ");
            productPrice = takePrice();

            productsInWarehouse.add(new Product(productCode, productName, productPrice));

            System.out.println("\nCzy chcesz dodać kolejne produkty?");
            System.out.println("[0] NIE");
            System.out.println("[1] TAK");

            System.out.print("Twój wybór: ");
            toContinue = input.stringInput();

        } while (!Objects.equals(toContinue, "0"));

        FileUpdate.updateFile(productsInWarehouse);
    }

    public void takeProductFromWarehouse() throws MyException {

        EasyReader input = new EasyReader(System.in);
        String toContinue;

        System.out.println("\nLista produktów w magazynie:");
        for (Product product : productsInWarehouse) {
            System.out.printf("Kod: %s, nazwa: %s, cena: %.2f zł\n", product.getProductCode(), product.getProductName(), product.getProductPrice());
        }

        do {
            System.out.print("\nPodaj dwucyfrowy kod produktu do pobrania: ");
            String finalProductCode = takeCode();

            productsInWarehouse.removeIf(product -> Objects.equals(product.getProductCode(), finalProductCode));

            System.out.println("\nCzy chcesz pobrać kolejne produkty?");
            System.out.println("[0] NIE");
            System.out.println("[1] TAK");

            System.out.print("Twój wybór: ");
            toContinue = input.stringInput();

        } while (!Objects.equals(toContinue, "0"));

        FileUpdate.updateFile(productsInWarehouse);
    }

    public String takeCode() throws MyException {

        EasyReader input = new EasyReader(System.in);
        String productCode;
        char[] charList;

        productCode = input.stringInput();
        charList = productCode.toCharArray();

        for (char c : charList) {
            if (!Character.isDigit(c)) {
                throw new MyException("Podany kod jest nieprawidłowy!");
            }
        }

        if (productCode.length() > 2) {
            throw new MyException("Podany kod jest nieprawidłowy!");
        }

        return productCode;
    }

    public String takeName() throws MyException {

        EasyReader input = new EasyReader(System.in);
        String productName;
        char[] charList;

        productName = input.stringInput();
        charList = productName.toCharArray();

        for (char c : charList) {
            if (!Character.isLetter(c)) {
                throw new MyException("Podany kod jest nieprawidłowy!");
            }
        }

        return productName;
    }

    public float takePrice() throws MyException {

        EasyReader input = new EasyReader(System.in);
        float productPrice;

        productPrice = (float)input.doubleInput();

        if (Float.isNaN(productPrice)) {
            throw new MyException("Podana cena jest nieprawidłowa!");
        }

        return productPrice;
    }
}
