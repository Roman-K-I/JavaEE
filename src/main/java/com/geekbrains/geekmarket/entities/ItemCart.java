package com.geekbrains.geekmarket.entities;

public class ItemCart {

    private Product product;
    private int num;

    public ItemCart (Product product) {
        this.product = product;
        this.num = 1;
    }

    public Product getProduct () {
        return product;
    }

    public void setProduct (Product product) {
        this.product = product;
    }

    public int getNum () {
        return num;
    }

    public void setNum (int num) {
        this.num = num;
    }
}
