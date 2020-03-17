package com.soft1851.spring.ioc.entity;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Phone
 * @Description TODO
 * @date 2020-03-17 21:36
 **/
public class Phone {
    private String brand;
    private Double price;

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Phone() {
    }

    public Phone(String brand, Double price) {
        this.brand = brand;
        this.price = price;
    }
}
