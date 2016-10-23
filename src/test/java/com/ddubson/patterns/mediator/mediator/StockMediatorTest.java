package com.ddubson.patterns.mediator.mediator;

import com.ddubson.patterns.mediator.StockOffer;
import com.ddubson.patterns.mediator.colleague.Colleague;
import com.ddubson.patterns.mediator.colleague.GormanSlacks;
import com.ddubson.patterns.mediator.colleague.JTPoorman;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Author: ddubson
 */
public class StockMediatorTest {
    @Test
    public void mediator_should() throws Exception {
        StockMediator nyse = new StockMediator();
        GormanSlacks gormanSlacks = new GormanSlacks(nyse);
        JTPoorman jtPoorman = new JTPoorman(nyse);

        gormanSlacks.sellOffer("MSFT", 100);
        gormanSlacks.sellOffer("GOOG", 50);

        jtPoorman.buyOffer("MSFT", 100);
        jtPoorman.sellOffer("NRG", 10);

        gormanSlacks.buyOffer("NRG", 10);

        nyse.getstockOfferings();
    }

    @Test
    public void stockOffer_shouldReturnStockShares() throws Exception {
        StockOffer stockOffer = new StockOffer(100, "MST", 1);
        assertEquals(100, stockOffer.getStockShares());
        assertEquals("MST", stockOffer.getStockSymbol());
        assertEquals(1, stockOffer.getColleagueCode());
    }

    @Test
    public void mediator_shouldAddColleagues() throws Exception {
        Mediator mediator = new StockMediator();
        Colleague colleague = new GormanSlacks(mediator);
        assertEquals(1, mediator.getColleagues().size());
        assertEquals(colleague, mediator.getColleagues().get(0));
    }
}