/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab2;

import java.util.ArrayList;

/**
 *
 * @author student
 */
class UserInfo {
    /*to be completed
    For now, we just add book info to make the example work. This class must be completed in future
    */
    private ArrayList <OrderHistory> orderhistory = new ArrayList<>();
    public void addOrder(OrderHistory book){
        orderhistory.add(book);
    }
    public ArrayList<OrderHistory> getOrderHistory(){
        return orderhistory;
    }
    
}
