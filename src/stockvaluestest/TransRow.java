/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockvaluestest;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Filip
 */
public class TransRow {
    private int userID;
    private String stock;
    private int amount;
    private LocalDate date;
    
    public TransRow(int userID, String stock, int amount, LocalDate date){
        this.userID = userID;
        this.stock = stock;
        this.amount = amount;
        this.date = date;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public String getStock(){
        return stock;
    }
    
    public int getAmount(){
        return amount;
    }
    
    public LocalDate getDate(){
        return date;
    }
}
