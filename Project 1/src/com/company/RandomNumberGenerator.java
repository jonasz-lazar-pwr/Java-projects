package com.company;

public class RandomNumberGenerator {

    public Integer getRandomNumber(Integer min, Integer max) {
        return (Integer) (int)Math.floor(Math.random()*(max-min+1)+min);
    }

}
