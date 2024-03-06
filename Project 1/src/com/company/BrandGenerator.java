package com.company;

import java.util.Random;

public class BrandGenerator {

    public Brand getRandomBrand() {
        Brand[] values = Brand.values();
        int length = values.length;
        int randIndex = new Random().nextInt(length);
        return values[randIndex];
    }
}
