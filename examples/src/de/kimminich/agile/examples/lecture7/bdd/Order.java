package de.kimminich.agile.examples.lecture7.bdd;

import java.util.Arrays;
import java.util.List;

public class Order {
    
    private List<String> items;

    public Order(String... items) {
        this.items = Arrays.asList(items);
    }

    public List<String> getItems() {
        return items;
    }
    
}