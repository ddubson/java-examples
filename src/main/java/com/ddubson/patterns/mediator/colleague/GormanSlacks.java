package com.ddubson.patterns.mediator.colleague;


import com.ddubson.patterns.mediator.mediator.Mediator;

/**
 * Created by ddubson on 12/24/14.
 */
public class GormanSlacks extends Colleague {
    public GormanSlacks(Mediator mediator) {
        super(mediator);
        System.out.println("JT Poorman signed up with the exchange.");
    }
}
