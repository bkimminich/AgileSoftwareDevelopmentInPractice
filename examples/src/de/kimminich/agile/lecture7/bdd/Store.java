package de.kimminich.agile.lecture7.bdd;

import java.util.HashMap;
import java.util.Map;

public class Store {
    
    Map<String, Integer> stock = new HashMap<>();

    public int getStockCountFor(String item) {
        return stock.get(item);
    }

    public void receiveReturnFrom(Order order) {
        for (String item : order.getItems()) {
            if (!stock.containsKey(item)) {
                stock.put(item, 1);
            } else {
                stock.put(item, getStockCountFor(item)+1);
            }
        }
    }
    
    public void setStock(Map<String, Integer> stock) {
        this.stock = stock;
    }

    
}