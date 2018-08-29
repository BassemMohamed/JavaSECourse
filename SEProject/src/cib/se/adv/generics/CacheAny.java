package cib.se.adv.generics;

import oracle.net.aso.s;

public class CacheAny<T> {

    private T t;
    
    public CacheAny(T t) {
        this.t = t;
    }

    // Getters & Setters
    public void setT(T t) {
        this.t = t;
    }
    public T getT() {
        return t;
    }
}
