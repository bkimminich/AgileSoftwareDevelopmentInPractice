package de.kimminich.agile.lecture7.bdd;

import java.util.HashMap;
import java.util.Map;

public class StoreBuilder {

    private Map<String, Integer> stock = new HashMap<>();

    private StoreBuilder() {
        // prevent instantiation via new StoreBuilder()
    }

    public static StoreBuilder aStore() {
        return new StoreBuilder();
    }

    public Store build() {
        Store store = new Store();
        store.setStock(stock);
        return store;
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

    private void addToStock(String item) {
        if (!stock.containsKey(item)) {
            stock.put(item, 1);
        } else {
            stock.put(item, stock.get(item) + 1);
        }
    }
}