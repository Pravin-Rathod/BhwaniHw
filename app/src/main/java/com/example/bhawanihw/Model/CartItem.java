package com.example.bhawanihw.Model;

import android.widget.ImageView;

public class CartItem {

    //private static double cartTotalPrice=0;
    private String itemName;
    private double itemPrice;
    private double itemTotalPrice;
    private int itemQty;
    private String itemUrl;

    public CartItem(String itemName,double itemPrice,double itemTotalPrice, int itemQty,String itemUrl) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemTotalPrice = itemTotalPrice;
        this.itemQty = itemQty;
        this.itemUrl = itemUrl;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(double itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    public String getItemUrl() {
        return itemUrl;
    }

    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }
}
