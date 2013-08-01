package de.kimminich.agile.lecture7.bdd;


import static org.junit.Assert.assertEquals;
import static de.kimminich.agile.lecture7.bdd.StoreBuilder.aStore;
import org.junit.Test;

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
