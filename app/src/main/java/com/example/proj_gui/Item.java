package com.example.proj_gui;

public class Item {
    private int id;
    private String itemName;
    private int itemCost;
    private int itemStock;

    public Item(){

    }

    public Item(int id, String itemName, int itemCost, int itemStock){
        this.id = id;
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemStock = itemStock;
    }

    public void setID(int id){
        this.id = id;
    }

    public int getID() {
        return this.id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return this.itemName;
    }

    public void setItemCost(int itemCost) {
        this.itemCost = itemCost;
    }

    public int getItemCost() {
        return this.itemCost;
    }

    public void setItemStock(int itemStock) {
        this.itemStock = itemStock;
    }

    public int getItemStock() {
        return this.itemStock;
    }

}
