package cib.se.oop.interfaces;

public interface Travel {
    
    static final double DAY_COST = 50;
    
    public abstract double getTicketCost();
    public abstract double getPerdimCost(double noDays);
    public abstract double getAccomodationCost();
    
}
