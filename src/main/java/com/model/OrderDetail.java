/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.model;

/**
 *
 * @author Administrator
 */
public class OrderDetail {
    private int oderDetailID;
    private int productID;
    private int quantity;
    private double price;

    public OrderDetail() {
    }

    public OrderDetail(int oderDetailID, int productID, int quantity, double price) {
        this.oderDetailID = oderDetailID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOderDetailID() {
        return oderDetailID;
    }

    public void setOderDetailID(int oderDetailID) {
        this.oderDetailID = oderDetailID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }  
}
