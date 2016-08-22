/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockvaluestest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filip
 */
public class Portfolio {
    private List<Stock> stockList = new ArrayList<>();
    private int userId;
    
    public Portfolio(Integer userId){
        this.userId = userId;
    }
    
    public void addStock(Stock stock){
        stockList.add(stock);
    }
    
    public List<Stock> getStockList(){
        return stockList;
    }
    
    public Integer getUserId(){
        return userId;
    }
    
}
