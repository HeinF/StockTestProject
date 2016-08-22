/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockvaluestest;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author Filip
 */
public class StockValuesTest {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SortedMap<Integer, TransRow> transMap = new TreeMap<>();
        SortedMap<LocalDate, Double> priceMapVws = new TreeMap<>();
        SortedMap<LocalDate, Double> priceMapDsv = new TreeMap<>();
        SortedMap<LocalDate, Double> priceMapTdc = new TreeMap<>();
        List<String> stocks = new ArrayList<>();
        SortedMap<String, Integer> amountMapSingle = new TreeMap<>();
        SortedMap<LocalDate, SortedMap> amountMap = new TreeMap<>();
        
        
        
        
        transMap.put(1, new TransRow(970, "vws", 150, LocalDate.of(2015, 04, 01)));
        transMap.put(2, new TransRow(970, "vws", 75, LocalDate.of(2015, 04, 15)));
        transMap.put(3, new TransRow(970, "vws", 200, LocalDate.of(2015, 04, 25)));
        transMap.put(4, new TransRow(970, "vws", -33, LocalDate.of(2015, 05, 01)));
        transMap.put(5, new TransRow(970, "dsv", 30, LocalDate.of(2015, 06, 01)));
        transMap.put(7, new TransRow(970, "tdc", 65, LocalDate.of(2016, 07, 01)));
        
        stocks.add("vws");
        stocks.add("dsv");
        stocks.add("tdc");
        
        priceMapVws.put(LocalDate.of(2015, 04, 01), 250.0 );
        priceMapVws.put(LocalDate.of(2015, 04, 15), 265.0 );
        priceMapVws.put(LocalDate.of(2015, 04, 25), 275.0 );
        priceMapVws.put(LocalDate.of(2015, 05, 01), 300.0 );
        
        priceMapDsv.put(LocalDate.of(2015, 06, 01), 300.0 );
        
        priceMapTdc.put(LocalDate.of(2016, 07, 01), 300.0 );
        
        stockPopulator mapper = new stockPopulator();
        Portfolio folio = mapper.populate(970);
        
       /* for(LocalDate date = LocalDate.of(2015, 04, 01); date.isBefore(LocalDate.of(2016, 07, 02)); date.plusDays(1))
        {
          for(Iterator<String> it = stocks.iterator(); it.hasNext();)
                {
                String stock = it.next();
                }  
        }*/
        
        
        
        
        /*for(Map.Entry<Integer, TransRow> entry: transMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue().getUserID()+" "+entry.getValue().getStock()+" "+entry.getValue().getAmount()+" "+entry.getValue().getDate());
        }*/
    }
    
   
        
    
}
