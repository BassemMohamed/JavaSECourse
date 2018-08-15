package cib.javase.myclasses;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestDate {
    
    public static Date calcBusinessDays(Date first, int noOfDays) {
        
        int dayOfWeek;
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(first);
        
        for (int i=0; i < noOfDays; i++) {
           
            gc.add(Calendar.DAY_OF_WEEK, 1);
            dayOfWeek = gc.get(Calendar.DAY_OF_WEEK);
            if(dayOfWeek == Calendar.FRIDAY) {
                gc.add(Calendar.DAY_OF_WEEK, 2);
            }
            if(dayOfWeek == Calendar.SATURDAY) {
                gc.add(Calendar.DAY_OF_WEEK, 1);
            }
            
       }        
        
        return gc.getTime();
    }
    
    public static void main(String[] args) {
        System.out.println( calcBusinessDays(new Date(),9) );        
    }
}
