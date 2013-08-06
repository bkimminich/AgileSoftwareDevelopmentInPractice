package de.kimminich.agile.lecture7.builder;


import static de.kimminich.agile.lecture7.builder.StoreBuilder.aStore;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.kimminich.agile.lecture7.bdd.Order;
import de.kimminich.agile.lecture7.bdd.Store;

public class ReturnsGoToStockTest {
    
    @Test
    public void shouldReturnRefundedItemToStock() {
        // given
        Order order = new Order("Black Sweater");
        Store store = aStore().withItems("Black Sweater", "Black Sweater", "Black Sweater").build();
        // when
        store.receiveReturnFrom(order);
        // then
        assertEquals(4, store.getStockCountFor("Black Sweater"));
    }
    
}
