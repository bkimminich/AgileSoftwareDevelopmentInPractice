package de.kimminich.agile.examples.lecture7.bdd;

import java.util.HashMap;
import java.util.Map;


public class Store {

    private String manager;
    private Map<String, Integer> stock = new HashMap<>();
    
    public Store(String manager, Map<String, Integer> stock) {
        this.manager = manager;
        this.stock = stock;
    }

    public int getStockCountFor(String item) {
        return stock.get(item);
    }

    public void receiveReturnFrom(Order order) {
        if (!returnRequiresApproval(order) || isReturnApproved(order)) {
            for (String item : order.getItems()) {
                addToStock(item);
            }
        }
    }

    private boolean returnRequiresApproval(Order order) {
        return order.getItems().size() > 10;
    }

    private boolean isReturnApproved(Order order) {
        return new ApprovalService().hasExistingApproval(order, manager);
    }

    private void addToStock(String item) {
        if (!stock.containsKey(item)) {
            stock.put(item, 1);
        } else {
            stock.put(item, getStockCountFor(item) + 1);
        }
    }

    public String getManager() {
        return manager;
    }

}