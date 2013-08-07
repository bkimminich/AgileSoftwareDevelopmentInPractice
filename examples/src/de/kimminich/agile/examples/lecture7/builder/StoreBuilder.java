package de.kimminich.agile.examples.lecture7.builder;

import java.util.HashMap;
import java.util.Map;

import de.kimminich.agile.examples.lecture7.bdd.Store;

public class StoreBuilder {

    private String manager = "Manny";
    private Map<String, Integer> stock = new HashMap<>();

    private StoreBuilder() {
    }

    public static StoreBuilder aStore() {
        return new StoreBuilder();
    }

    public Store build() {
        Store store = new Store(manager, stock);
        return store;
    }

    private void addToStock(String item) {
        if (!stock.containsKey(item)) {
            stock.put(item, 1);
        } else {
            stock.put(item, stock.get(item) + 1);
        }
    }

    public StoreBuilder withManager(String manager) {
        this.manager = manager;
        return this;
    }

    public StoreBuilder withItem(String item) {
        addToStock(item);
        return this;
    }

    public StoreBuilder withItems(String... items) {
        for (String item : items) {
            addToStock(item);
        }
        return this;
    }

}