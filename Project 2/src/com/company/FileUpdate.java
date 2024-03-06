package com.company;

import java.io.*;
import java.util.List;

public class FileUpdate {

    public static void updateFile(List<Product> listOfProducts) throws MyException {

        try {
            File file = new File("ListOfAvailableProducts.txt");
            FileOutputStream fo = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(fo);

            for (Product product : listOfProducts){
                pw.println(product.getProductCode() + ", " + product.getProductName() + ", " + product.getProductPrice());
            }
            pw.flush();
            pw.close();
            fo.close();
        } catch (IOException e) {
            throw new MyException("Wystąpił błąd podczas aktualizowania pliku!");
        }

        System.out.println("\nPlik z dostępnymi produktami w magazynie został zaktualizowany!");
    }
}
