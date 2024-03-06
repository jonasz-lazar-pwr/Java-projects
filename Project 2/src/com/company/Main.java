/*
 * Interpretacja polecenia i działanie programu:
 * Słowo "sklep" oznacza produkty pobrane z pliku z dostępnymi produktami, do której ma dostęp tylko klient.
 * Jeżeli jakiś produkt jest w koszyku, to nie ma go na półce w sklepie i na odwrót.
 * Po sfinalizowaniu zakupów plik z dostępnymi artykułami zostaje zaktualizowany z pomniejszeniem o zakupione produkty.
 * Słowa "produkt" i "artykuł" mają to samo znaczenie.
 * Metoda countProductInShop zlicza ilość wystąpienia produktu w "sklepie" o tej samej nazwie.
 * Metoda changeProductName zmienia znaki "?" oraz "*" na zgodne z konwencją wyrażenia regularnego
 * Wyświetlenie produktów na stanie sklepu za pomocą metody printShop, oraz w koszyku za pomocą printBasket.
 * Jeżeli użyjemy "?" i wpiszemy nazwę: "ap??e" to do koszyka zostanie dodany produkt: "apple" zgodnie z treścią zadania.
 * Jeżeli użyjemy znaku "*" i wpiszemy: "*" to zostanie wybrany pierwszy dostępny produkt z listy.
 * Jeżeli wpiszemy "p*" to zostanie wybrany pierwszy produkt rozpoczynający się na literę "p" (w naszym przypadku będzie to pudding)
 * Słowo "magazyn" oznacza produkty pobrane z pliku z dostępnymi produktami, do których modyfikacji ma dostęp tylko magazynier
 * Może on dodać produkt (jego kod, nazwę i cenę) do magazynu, a następnie zaktualizować plik z dostępnymi artykułami
 * Może również pobrać produkt (podając jego kod), a następnie zaktualizować plik pomniejszony o pobrane produkty
 * */

package com.company;

import edu.colorado.io.EasyReader;

public class Main {

    public static void main(String[] args) throws MyException {

        System.out.println("\nZ jakiego poziomu ma pracować program (wybierz numer):");
        System.out.println("[1] Klienta");
        System.out.println("[2] Magazyniera");

        EasyReader inputLine = new EasyReader(System.in);
        String str;

        System.out.print("Twój wybór: ");
        str = inputLine.stringInput();

        switch (str) {
            case "1" -> {
                Customer customer = new Customer();
                customer.goShopping();
            }
            case "2" -> {
                Warehouseman warehouseman = new Warehouseman();
                warehouseman.workInWarehouse();
            }
            default -> throw new MyException("Błędny wybór opcji!");
        }
    }
}
