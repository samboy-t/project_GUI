package com.example.lecture9_example;

public class Product {
    private int id;
    private String productName;
    private int productQuantity;

    public Product(){

    }

    public Product(int id, String productName, int productQuantity) {
        this.id = id;
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public Product(String productName, int productQuantity) {
        this.productName = productName;
        this.productQuantity = productQuantity;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductQuantity() {
        return this.productQuantity;
    }
}
