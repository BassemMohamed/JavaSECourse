package cib.se.adv.enums;

public class TestEnums {
    
    public static void main(String[] args) {
        
        for (WeekDays w : WeekDays.values()) {
            System.out.println(w + " " + w.getVal());
       }
   }
}
