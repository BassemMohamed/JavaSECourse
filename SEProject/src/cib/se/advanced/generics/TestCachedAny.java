package cib.se.advanced.generics;

import java.util.ArrayList;

public class TestCachedAny {
    
    public static void main(String[] args) {
        
        // CacheAny Contains a generic variable you can set it with any object type!
        CacheAny<String> x = new CacheAny<>("Ahmed");
        CacheAny<Integer> y = new CacheAny<>(85);
        
        // Here we are doing an arraylist of type object to be able to give it any object type!
        ArrayList<Object> array = new ArrayList<>();
        array.add(85);
        array.add("hamada");
        
        // Here we are doing an arraylist of with no type to be able to give it any object type!
        ArrayList array2 = new ArrayList();
        array2.add(85);
        array2.add("hamada");
        
    }
}
