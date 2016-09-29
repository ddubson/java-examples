package com.ddubson.patterns.mediator.colleague;


import com.ddubson.patterns.mediator.mediator.Mediator;

public abstract class Colleague {
    private Mediator mediator;
    private int colleagueCode;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
        mediator.addColleague(this);
    }

    public void sellOffer(String stock, int shares) {
        mediator.sellOffer(stock, shares, this.colleagueCode);
    }

    public void buyOffer(String stock, int shares) {
        mediator.buyOffer(stock, shares, this.colleagueCode);
    }

    public void setColleagueCode(int colleagueCode) {
        this.colleagueCode = colleagueCode;
    }
}
