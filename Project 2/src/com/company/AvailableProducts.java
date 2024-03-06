// Lista 3, Zad 1
// Autor: Jonasz Lazar
// Indeks: 263898

package com.company;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AvailableProducts {

    static void getProductsFromFile(List<Product> listOfProducts) throws MyException {
        try {
            File file = new File("ListOfAvailableProducts.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(str, ", ");
                listOfProducts.add(new Product(tokenizer.nextToken(), tokenizer.nextToken(), Float.parseFloat(tokenizer.nextToken())));
            }
            sc.close();
        } catch (IOException e) {
            throw new MyException("Wystąpił błąd podczas wczytywania pliku!");
        }
    }
}
