package cib.se.oop.inherit;

import cib.se.oop.interfaces.Travel;

public class Consultant extends Person implements Travel {
    
    @Override
    public double getTicketCost() {
        // TODO Implement this method
        return 0.0;
    }

    @Override
    public double getPerdimCost(double noDays) {
        // TODO Implement this method
        return noDays * Travel.DAY_COST;
    }

    @Override
    public double getAccomodationCost() {
        // TODO Implement this method
        return 0.0;
    }
}
