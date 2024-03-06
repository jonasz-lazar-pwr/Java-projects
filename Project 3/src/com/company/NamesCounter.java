// Lista 3, Zad 2
// Autor: Jonasz Lazar
// Indeks: 263898

package com.company;

import edu.colorado.io.EasyReader;

import java.io.IOException;
import java.util.*;
import java.util.LinkedList;

public class NamesCounter {

    public void countNames(String[] namesOfFiles) throws MyException {

        //Tworzenie listy liter
        ArrayList<Letter> letters = new ArrayList<>(26);

        // Tworzenie pomocniczych zmiennych
        int whichFile = 0; // W którym pliku jesteśmy (iteracja po przeczytaniu wszystkich imion w pliku i przejściu do kolejnego pliku)
        String readName; // Do tej zmiennej zapisujemy odczytane słowo przez klasę EasyReader
        char firstLetterOfReadName; // Pierwsza litera odczytanego słowa, używana np. to stworzenia nowego obiektu Letter
        boolean isLetterOnList; // = true (dana litera była już wcześniej dodana do listy letters, false (nie napotkano na taką literę w ArrayList))

        EasyReader readFile;

        try {
            // Wykonujemy operacje odczytywania słów na każdym pliku
            for (String nameOfFile : namesOfFiles) {

                readFile = new EasyReader(nameOfFile);
                System.out.println(nameOfFile + " file is processing...");

                while (!readFile.isEOF()) {

                    boolean isNameOnList = false;
                    // true (imie jest już zapisane na liście imion),
                    // false (jest to nowe imie, które należy dodać do listy imion)

                    // Odczytujemy imię i sprawdzamy jego pierwszą literę
                    readName = readFile.stringInput();
                    firstLetterOfReadName = readName.charAt(0);

                    /*
                     * Sprawdzamy, czy wyszukane imię znajduje się w enumeracji imiona
                     * Np. imie "Linda" nie zostanie dodane do listy LinkedList, ponieważ nie jest zdefiniowane w enumeracji Names
                     * */
                    if (enumContainsName(readName)) {

                        // Sprawdzamy, czy pierwsza litera odczytanego słowa jest już na liście ArrayList
                        isLetterOnList = false;
                        for (Letter letter : letters) {
                            if (firstLetterOfReadName == letter.getLetterName()) {
                                isLetterOnList = true;
                                break;
                            }
                        }

                        /*
                         * Jeżeli pierwsza litera imienia pojawiła się pierwszy raz, to:
                         * -Tworzymy jej obiekt i dodajemy go do listy liter
                         * -Tworzymy obiekt odczytanego imienia i dodajemy go do listy imion, które zaczynają się na tę literę
                         * -Aktualizujemy wystąpienie tego elementu w danym pliku
                         * */
                        if (!isLetterOnList && letters.size() < 26) {

                            letters.add(new Letter(firstLetterOfReadName, new LinkedList<>()));
                            letters.get(letters.size()-1).getNamesOnTheLetter().add(new Name(readName, new int[]{0, 0, 0}));

                            for (Letter letter : letters) {
                                for (Name name : letter.getNamesOnTheLetter()) {
                                    if (Objects.equals(name.getName(), readName)) {
                                        name.getNameOccurrences()[whichFile] ++;
                                    }
                                }
                            }
                        }

                        /*
                         * Jeżeli pierwsza litera imienia pojawiła się już któryś raz, to:
                         * -W pętli sprawdzamy, czy imie już występuje na liście imion dowiązanych to danej litery:
                         *   -Jeżeli występuje, to aktualizujemy jego wystąpienie w konkretnym pliku
                         *   -Jeżeli nie występuje, to:
                         *       -Tworzymy jego obiekt i dodajemy go do listy imion, które zaczynają się na tę literę
                         *       -Aktualizujemy wystąpienie tego elementu w danym pliku
                         * */
                        if (isLetterOnList) {
                            for (Letter letter : letters) {
                                for (Name name : letter.getNamesOnTheLetter()) {
                                    if (Objects.equals(name.getName(), readName)) {
                                        isNameOnList = true;
                                        name.getNameOccurrences()[whichFile] ++;
                                    }
                                }
                                if (!isNameOnList && (letter.getLetterName() == firstLetterOfReadName)) {

                                    letter.getNamesOnTheLetter().add(new Name(readName, new int[]{0, 0, 0}));

                                    for (Name name : letter.getNamesOnTheLetter()) {
                                        if (Objects.equals(name.getName(), readName)) {
                                            name.getNameOccurrences()[whichFile] ++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                readFile.close();
                whichFile++;
            }
        } catch (IOException e) {
            throw new MyException("Błąd w czasie procesowania pliku!");
        }

        /*
        * Sortujemy alfabetycznie listę liter (tego nie było w poleceniu, zrobione dodatkowo)
        * oraz listę imion, używając zdefiniowanego komparatora.
        * Np. dla litery J kolejność będzie taka: Jack, John.
        * Jeżeli dodamy Jima do któregoś z plików (uwzględniając to w enumeracji), to kolejność będzie taka: Jack, Jim, John
        * */
        letters.sort(Comparator.naturalOrder());
        for (Letter letter : letters) {
            letter.getNamesOnTheLetter().sort(Comparator.naturalOrder());
        }

        // Wyświetlenie, ile razy dane imię występuje w danym pliku
        for (Letter letter : letters) {
            for (Name name : letter.getNamesOnTheLetter()) {
                int index = 0;
                System.out.println("\nImie " + name.getName() + " występuje w pliku: ");
                for (String nameOfFile : namesOfFiles) {
                    System.out.println(nameOfFile + ": " + name.getNameOccurrences()[index] + " razy");
                    index++;
                }
            }
        }

        // Alternatywny sposób wyświetlania imion
//        int index = 0;
//        for (String nameOfFile : namesOfFiles) {
//            System.out.println("\nWystąpienie imion w pliku " + nameOfFile);
//            for (Letter letter : letters) {
//                for (Name name : letter.getNamesOnTheLetter()) {
//                    System.out.println(name.getName() + ": " + name.getNameOccurrences()[index]);
//                }
//            }
//            index++;
//        }

        // Podgląd tego, co znajduje się w liście liter za pomocą "toString'ów"
        System.out.println();
        for (Letter letter : letters) {
            System.out.println(letter);
        }
    }

    private boolean enumContainsName(String name) {

        for (Names names : Names.values()) {
            if (names.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}