package com.company;

import edu.colorado.io.EasyReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            if (args[0].matches("[0-9]*")) {

                int n = Integer.parseInt(args[0]);
                ListOfCarsGenerator cars = new ListOfCarsGenerator();
                cars.generateCars(n);

                if (args[1].matches("^R$")) {

                    List<Car> foundCars = findCars(cars);

                    System.out.println();
                    System.out.println("Lista znalezionych samochodów:");

                    for (Car car : foundCars) {
                        System.out.println("Marka: " + car.brand + ", cena: " + car.price + "zł, rocznik: " + car.year);
                    }
                }

                if (args[1].matches("^W$")) {

                    StringBuilder parameters = new StringBuilder("\nLista znalezionych samochodów:");
                    for (Car car : findCars(cars)) {
                        parameters.append("\nMarka: ").append(car.brand).append(", cena: ").append(car.price).append("zł, rocznik: ").append(car.year);
                    }
                    System.out.println();
                    throw new Wyjatek(parameters.toString());
                }
            }
            else {
                throw new IllegalArgumentException("Błędny argument z linii wywołania programu!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static List<Car> findCars(ListOfCarsGenerator cars) {

        System.out.println();
        System.out.println("Kryteria szukania samochodów:");
        System.out.println("[1] najstarszy");
        System.out.println("[2] nie starszy niż ROK");
        System.out.println("[3] najmłodszy");
        System.out.println("[4] nie młodszy niż ROK");
        System.out.println();

        edu.colorado.io.EasyReader inputLine = new EasyReader(System.in);
        String criterionNumber = null;

        do {
            System.out.print("Podaj numer kryterium (1-4): ");
            criterionNumber = inputLine.stringInputLine();

            if (criterionNumber.matches("[^1234]")) {
                System.out.println("Nieprawidłowe kryterium. Spróbuj ponownie!");
                System.out.println();
            }
        } while (criterionNumber.matches("[^1234]"));

        Integer ROK = null;

        if (criterionNumber.matches("^2$|^4$")) {
            do {
                System.out.print("Podaj ROK (1960-1990): ");
                ROK = Integer.parseInt(inputLine.stringInputLine());

                if (!((ROK >= 1960) && (ROK <= 1990))) {
                    System.out.println("Nieprawidłowy ROK. Spróbuj ponownie!");
                    System.out.println();
                }
            } while (!((ROK >= 1960) && (ROK <= 1990)));
        }

        // List<Car> foundCars = FindingCars.findCars(criterionNumber, cars.getListOfCars(), ROK);

        return FindingCars.findCars(criterionNumber, cars.getListOfCars(), ROK);

    }
}