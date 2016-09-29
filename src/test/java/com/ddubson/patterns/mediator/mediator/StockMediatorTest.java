package com.ddubson.patterns.mediator.mediator;

import com.ddubson.patterns.mediator.colleague.GormanSlacks;
import com.ddubson.patterns.mediator.colleague.JTPoorman;
import org.junit.Test;

/**
 * Author: ddubson
 */
public class StockMediatorTest {
    @Test
    public void mediator_should() throws Exception {
        StockMediator nyse = new StockMediator();
        GormanSlacks broker = new GormanSlacks(nyse);
        JTPoorman broker2 = new JTPoorman(nyse);

        broker.sellOffer("MSFT", 100);
        broker.sellOffer("GOOG", 50);

        broker2.buyOffer("MSFT", 100);
        broker2.sellOffer("NRG", 10);

        broker.buyOffer("NRG", 10);

        nyse.getstockOfferings();
    }
}