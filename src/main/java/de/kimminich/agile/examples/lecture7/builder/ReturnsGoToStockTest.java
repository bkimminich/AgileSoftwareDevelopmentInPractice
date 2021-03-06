package de.kimminich.agile.examples.lecture7.builder;


import de.kimminich.agile.examples.lecture7.bdd.Order;
import de.kimminich.agile.examples.lecture7.bdd.Store;
import org.junit.Test;

import static de.kimminich.agile.examples.lecture7.builder.StoreBuilder.aStore;
import static org.junit.Assert.assertEquals;

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
