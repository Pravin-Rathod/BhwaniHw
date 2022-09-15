package com.example.bhawanihw.Model;

public class Item {

    private int id;
    private String itemId;
    private String itemName;
    private String itemPrice;
    private String itemImageUrl;
    private double itemTotalPrice;
    private int itemQty;


    public Item(int id, String itemId, String itemName, String itemPrice,String itemImageUrl) {
        this.id = id;
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemImageUrl=itemImageUrl;
    }

    public Item(String itemName, int itemQty, Double itemTotalPrice,String itemImageUrl) {
        this.itemName = itemName;
        this.itemTotalPrice = itemTotalPrice;
        this.itemQty = itemQty;
        this.itemImageUrl=itemImageUrl;
    }

    public int getId() {
        return id;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public double getItemTotalPrice() {
        return itemTotalPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public String getItemImageUrl() {
        return itemImageUrl;
    }
}
