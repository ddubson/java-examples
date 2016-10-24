package com.ddubson.patterns.mediator.mediator;


import com.ddubson.patterns.mediator.colleague.Colleague;

import java.util.List;

public interface Mediator {
    void sellOffer(String stock, int shares, int collCode);

    void buyOffer(String stock, int shares, int collCode);

    void addColleague(Colleague colleague);

    List<Colleague> getColleagues();
}
