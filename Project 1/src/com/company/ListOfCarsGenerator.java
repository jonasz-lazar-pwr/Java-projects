package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListOfCarsGenerator {

    private final List<Car> listOfCars = new ArrayList<>();
    private final BrandGenerator randomBrand = new BrandGenerator();
    private final RandomNumberGenerator randomNumber = new RandomNumberGenerator();

    public void generateCars(Integer n) {
        for(int i = 0; i < n; i++) {
            listOfCars.add(new Car(i+1, randomBrand.getRandomBrand(), randomNumber.getRandomNumber(10000,100000), randomNumber.getRandomNumber(1960,1990)));
        }
    }

    public List<Car> getListOfCars() {
        return listOfCars;
    }
}
