package com.company;

public class Product {

    private final String productCode;
    private final String productName;
    private final float productPrice;

    public Product(String productCode, String productName, float productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }
}
