/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stockvaluestest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.SortedMap;
import java.util.TreeMap;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author FPH
 */
public class Stock {
    private String name;
    private Double price = 0.0;
    private Double value;
    private int amount = 0;
    private SortedMap<LocalDate, Double> valueMap = new TreeMap<>();
    private SortedMap<LocalDate, Double> priceMap = new TreeMap<>();
    private SortedMap<LocalDate, Integer> amountMap = new TreeMap<>();
    
    
    public Stock(String name){
        this.name = name;
    }
    
    public void setName(String name){
        this.name = name;
        
    }
    
    public void setPrice(Double price){
        this.price = price;
    }  
    
    public void setPriceMap(SortedMap<LocalDate, Double> priceMap){
        this.priceMap = priceMap;
    }
    
    public SortedMap<LocalDate, Double> getPriceMap(){
        return priceMap;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
    
    public void setAmountMap (SortedMap<LocalDate, Integer> amountMap){
        this.amountMap = amountMap;
    }
    
    public SortedMap<LocalDate, Integer> getAmountMap(){
        return amountMap;
    }
    
    public void setValue(){
        value = amount * price;
    }
    
    public void addAmount(int amount){
        this.amount += amount;
    }
    public void setValueMap(SortedMap<LocalDate, Double> valueMap){
        this.valueMap = valueMap;
    }
    
    public void addValueByDate(LocalDate date){
        setValue();
        valueMap.put(date, value);
    }
    
    public Double getValueByDate(LocalDate date){
        return valueMap.get(date);
    }
    
    public String getName(){
        return name;
    }
    
    public Double getPrice(){
        return price;
    }
    
    public int getamount(){
        return amount;
    }
    
}
