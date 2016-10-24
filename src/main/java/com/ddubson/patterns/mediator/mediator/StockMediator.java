package com.ddubson.patterns.mediator.mediator;

import com.ddubson.patterns.mediator.StockOffer;
import com.ddubson.patterns.mediator.colleague.Colleague;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StockMediator implements Mediator {
    private List<Colleague> colleagues;
    private List<StockOffer> stockBuyOffers;
    private List<StockOffer> stockSaleOffers;
    private int colleagueCodes = 0;

    public StockMediator() {
        colleagues = new ArrayList<>();
        stockBuyOffers = new ArrayList<>();
        stockSaleOffers = new ArrayList<>();
    }

    public void addColleague(Colleague newColleague) {
        colleagues.add(newColleague);
        colleagueCodes++;
        newColleague.setColleagueCode(colleagueCodes);
    }

    @Override
    public List<Colleague> getColleagues() {
        return this.colleagues;
    }


    public void sellOffer(String stock, int shares, int collCode) {
        Optional<StockOffer> offer = stockBuyOffers.stream().filter(stockOffer -> (stockOffer.getStockSymbol().equals(stock))
                && (stockOffer.getStockShares() == shares)).findFirst();

        if (offer.isPresent()) {
            System.out
                    .println(shares + " shares of " + stock
                            + " sold to colleague code "
                            + offer.get().getColleagueCode());

            stockBuyOffers.remove(offer.get());
        } else {
            System.out.println(shares + " shares of " + stock
                    + " added to inventory");

            StockOffer newOffering = new StockOffer(shares, stock, collCode);
            stockSaleOffers.add(newOffering);
        }
    }

    public void buyOffer(String stock, int shares, int collCode) {
        Optional<StockOffer> offer = stockSaleOffers.stream().filter(stockOffer -> (stockOffer.getStockSymbol().equals(stock))
                && (stockOffer.getStockShares() == shares)).findFirst();

        if (offer.isPresent()) {
            System.out.println(shares + " shares of " + stock
                    + " bought by colleague code "
                    + offer.get().getColleagueCode());
            stockSaleOffers.remove(offer.get());
        } else {
            System.out.println(shares + " shares of " + stock
                    + " added to inventory");

            StockOffer newOffering = new StockOffer(shares, stock, collCode);
            stockBuyOffers.add(newOffering);
        }
    }

    public void getstockOfferings() {
        System.out.println("\nStocks for Sale");

        stockSaleOffers.forEach(offer -> System.out.println(offer.getStockShares() + " of "
                + offer.getStockSymbol()));

        System.out.println("\nStock Buy Offers");

        stockBuyOffers.forEach(offer -> System.out.println(offer.getStockShares() + " of "
                + offer.getStockSymbol()));
    }

}
