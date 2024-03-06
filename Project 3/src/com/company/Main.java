/*
 * Jako argument linii wywołania należy wpisać: FirstListOfNames.txt SecondListOfNames.txt ThirdListOfNames.txt
 * */

package com.company;

public class Main {

    public static void main(String[] args) throws MyException {

        if (args[0].matches(".*\\.txt") && args[1].matches(".*\\.txt") && args[2].matches(".*\\.txt")) {

            NamesCounter namesCounter = new NamesCounter();
            namesCounter.countNames(args);

        } else {
            throw new IllegalArgumentException("Błędny argument z linii wywołania programu!");
        }
    }
}
