/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockvaluestest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Filip
 */
public class stockPopulator {
    private List<Stock> stockList = new ArrayList<>();
     
    public Portfolio populate(Integer userId){
        Portfolio portfolio = new Portfolio(userId);
        Connection con = DBConnection.getConnection();
        if(con == null)
        {
            return null;
        }
        else
        {
            try
            {
                getStockList(portfolio, con);  
                for (ListIterator<Stock> it = portfolio.getStockList().listIterator(); it.hasNext(); )
                {
                    Stock stock = it.next();
                    setAmount(stock, userId, con);
                    setPrice(stock, con);
                    setValue(stock);
                }
                con.close();
                
            } catch(SQLException ex)
            {
                System.out.println("Error in stockPopulator");
            }
            
            return portfolio;
        }
    }
    
    private void getStockList(Portfolio portfolio, Connection con){
        String query = "SELECT DISTINCT stock FROM transactions WHERE userid = '"+portfolio.getUserId()+"'";
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                Stock stock = new Stock(rs.getString("stock"));
                portfolio.addStock(stock);
            }
        } catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Error in getStockList");
        }
    }
    
    private void setAmount(Stock stock, Integer userId, Connection con){
        SortedMap<LocalDate, Integer> amountMap = new TreeMap<>();
        String query = "SELECT amount, date FROM transactions WHERE userid = '"+userId+"' AND stock = '"+stock.getName()+"'";
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                amountMap.put(rs.getDate("date").toLocalDate(), rs.getInt("amount"));        
            }
            int addAmount = 0;
            LocalDate date = amountMap.firstKey();
            while(date.isBefore(LocalDate.now()))
            {
                if(amountMap.containsKey(date)==false)
                {
                    amountMap.put(date, addAmount);
                }
                else
                {
                    int currentAmount = amountMap.get(date);
                    addAmount += currentAmount;
                    amountMap.put(date, addAmount);
                }
                date = date.plusDays(1);
            }
            stock.setAmountMap(amountMap);
                
                /*amountMap.entrySet().stream().forEach((entry) -> {
                    System.out.println(entry.getKey()+" "+entry.getValue());
                });*/

        } catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Error in setAmount");
        }
    }
    
    
    private void setPrice(Stock stock, Connection con){
        SortedMap<LocalDate, Double> priceMap = new TreeMap<>();
        String query = "SELECT close, date FROM "+stock.getName()+"";
        try
        {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                priceMap.put(rs.getDate("date").toLocalDate(), rs.getDouble("close"));
            }
            stock.setPriceMap(priceMap);
        } catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Error in setPrice"); 
        }
        
    }
    
    private void setValue(Stock stock){
        SortedMap<LocalDate, Double> priceMap = new TreeMap<>();
        Double value = 0.0;
        Double amount;
        Double price;
        for(Map.Entry<LocalDate, Integer> entry: stock.getAmountMap().entrySet())
        {
            amount = (double) entry.getValue();
            price = stock.getPriceMap().get(entry.getKey());
            if(price != null)
            {
              value = amount + price;  
            }
            System.out.println(value);
        }
        /*stock.getAmountMap().entrySet().stream().forEach((entry) -> {
            Double value;
            value = entry.getValue()*stock.getPriceMap().get(entry.getKey());
        });*/
    }
    
    
    
    private void printMap(SortedMap<LocalDate, Integer> map){
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey()+" "+entry.getValue());
        });
    }
}
