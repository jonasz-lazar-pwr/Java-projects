package com.company;

import java.util.ArrayList;
import java.util.List;

public class FindingCars {

    public static List<Car> findCars(String criterionNumber, List<Car> listOfCars, Integer ROK) {

        List<Car> carsMeetingTheCriteria = new ArrayList<>();

        Integer theYoungest = listOfCars.get(0).getYear();
        Integer theOldest = listOfCars.get(0).getYear();

        for (Car e : listOfCars) {
            if (e.getYear() < theYoungest) {
                theYoungest = e.getYear();
            }
            if (e.getYear() > theOldest) {
                theOldest = e.getYear();
            }
        }

        switch (criterionNumber) {
            case "1" -> {
                //System.out.println("Wybrano kryterium nr 1 + rocznik: " + theOldest);
                for (Car e : listOfCars) {
                    if (e.getYear().equals(theOldest)) {
                        carsMeetingTheCriteria.add(e);
                    }
                }
            }
            case "2" -> {
                //System.out.println("Wybrano kryterium nr 2 + rocznik: " + ROK);
                for (Car e : listOfCars) {
                    if (e.getYear() <= ROK) {
                        carsMeetingTheCriteria.add(e);
                    }
                }
            }
            case "3" -> {
                //System.out.println("Wybrano kryterium nr 3 + rocznik: " + theYoungest);
                for (Car e : listOfCars) {
                    if (e.getYear().equals(theYoungest)) {
                        carsMeetingTheCriteria.add(e);
                    }
                }
            }
            case "4" -> {
                //System.out.println("Wybrano kryterium nr 4 + rocznik: " + ROK);
                for (Car e : listOfCars) {
                    if (e.getYear() >= ROK) {
                        carsMeetingTheCriteria.add(e);
                    }
                }
            }
        }

        return carsMeetingTheCriteria;
    }
}
