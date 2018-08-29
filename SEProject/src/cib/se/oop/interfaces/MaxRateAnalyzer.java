package cib.se.oop.interfaces;

import cib.se.oop.inherit.Person;

// Functional Interface bec it has only one abstract method
@FunctionalInterface
public interface MaxRateAnalyzer {
    
    static final double MAX_RATE = 70_000.0;
    
    public abstract boolean checkrate(Double amount);
}
