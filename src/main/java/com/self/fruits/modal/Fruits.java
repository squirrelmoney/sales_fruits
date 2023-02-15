package com.self.fruits.modal;

/**
 * @program: fruits
 * @description:
 * @author: twl
 * @create: 2023-02-14 18:09
 **/
public class Fruits {
    private String code;
    private String name;
    private Double price;
    private Double discount;



    public Fruits(String code, String name, Double price, Double discount) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

}
