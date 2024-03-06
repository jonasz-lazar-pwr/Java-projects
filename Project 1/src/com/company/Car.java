package com.company;

public class Car {

    Integer index;
    Brand brand;
    Integer price;
    Integer year;

    public Car(Integer index, Brand brand, Integer price, Integer year) {
        this.index = index;
        this.brand = brand;
        this.price = price;
        this.year = year;
    }

    public Integer getIndex() {
        return index;
    }

    public Brand getBrand() {
        return brand;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getYear() {
        return year;
    }
}
