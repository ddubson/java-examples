package com.ddubson.patterns.mediator.colleague;

import com.ddubson.patterns.mediator.mediator.Mediator;

/**
 * Created by ddubson on 12/24/14.
 */
public class JTPoorman extends Colleague {
    public JTPoorman(Mediator mediator) {
        super(mediator);

        System.out.println("Gorman Slacks signed up with the exchange.");
    }
}
