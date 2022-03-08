/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2;

import java.util.Date;

/**
 *
 * @author student
 */
public class OrderHistory {

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    private  boolean available;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date date) {
        this.pickupDate = date;
    }
    String productName;
    String productBrand;
    Date pickupDate;

    /*
    To be completed
     */
    public OrderHistory(String productName, String productBrand, Date pickupDate, boolean available) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.pickupDate = pickupDate;
        this.available=available;
    }

    
}
