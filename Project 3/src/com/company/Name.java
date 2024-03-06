// Lista 3, Zad 2
// Autor: Jonasz Lazar
// Indeks: 263898

package com.company;

import java.util.Arrays;

public class Name implements Comparable<Name>{

    private final String name;
    private final int[] nameOccurrences;

    public Name(String name, int[] nameOccurrences) {
        this.name = name;
        this.nameOccurrences = nameOccurrences;
    }

    public String getName() {
        return name;
    }

    public int[] getNameOccurrences() {
        return nameOccurrences;
    }

    @Override
    public int compareTo(Name name) {
        return this.name.compareTo(name.name);
    }

    @Override
    public String toString() {
        return "Name{" + "name='" + name + '\'' + ", nameOccurrences=" + Arrays.toString(nameOccurrences) + '}';
    }
}