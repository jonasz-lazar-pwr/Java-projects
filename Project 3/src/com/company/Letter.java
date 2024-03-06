// Lista 3, Zad 2
// Autor: Jonasz Lazar
// Indeks: 263898

package com.company;

import java.util.LinkedList;

public class Letter implements Comparable<Letter>{

    private final char letterName;
    private final LinkedList<Name> namesOnTheLetter;

    public Letter(char letterName, LinkedList<Name> namesOnTheLetter) {
        this.letterName = letterName;
        this.namesOnTheLetter = namesOnTheLetter;
    }

    public char getLetterName() {
        return letterName;
    }

    public LinkedList<Name> getNamesOnTheLetter() {
        return namesOnTheLetter;
    }

    private String charToString(char letterName) {
        return Character.toString(letterName);
    }

    @Override
    public int compareTo(Letter letter) {
        return this.charToString(letterName).compareTo(String.valueOf(letter.letterName));
    }

    @Override
    public String toString() {
        return "Letter{" + "letterName=" + letterName + ", namesOnTheLetter=" + namesOnTheLetter + '}';
    }
}
