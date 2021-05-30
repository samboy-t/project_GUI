package com.example.proj_gui;

public class Item {
    private int id;
    private String itemName;
    private int itemCost;
    private int itemStock;
    private String itemLab;

    public Item(){

    }

    public Item(int id, String itemName, int itemCost, int itemStock, String itemLab){
        this.id = id;
        this.itemName = itemName;
        this.itemCost = itemCost;
        this.itemStock = itemStock;
        this.itemLab = itemLab;
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

    public void setItemLab(String itemLab) {this.itemLab = itemLab;}

    public String getItemLab() {return this.itemLab;}

}
