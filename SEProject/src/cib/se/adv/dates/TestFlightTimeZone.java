package cib.se.adv.dates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestFlightTimeZone {
    
    public static void main(String[] args) {
        
        test();
    }
    
    public static void test() {
        
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm, dd MMM yyyy");
        LocalDateTime ldt = LocalDateTime.now();//of(2016, Month.AUGUST, 22, 14, 30);
        System.out.println("LocalDateTime : " + format.format(ldt));
        
        //UTC+2
        ZoneId zonIdCairo = ZoneId.of("Africa/Cairo");
        ZonedDateTime CairoDT = ldt.atZone(zonIdCairo);
        System.out.println("Depart : " + format.format(CairoDT));
        
        //UTC+9 and flight duration = 10 hours
        ZonedDateTime japanDateTime = CairoDT.withZoneSameInstant(ZoneId.of("Asia/Tokyo")).plusHours(10);
        System.out.println("Arrive : " + format.format(japanDateTime));
        
        // Hard coded zoneoffset like this, UTC-5
        /*
             ZoneOffset nyOffSet = ZoneOffset.of("-05:00");
             ZonedDateTime japanDateTime = CairoDT.withZoneSameInstant(nyOffSet).plusHours(8).plusMinutes(10);
             System.out.println("Arrive : " + format.format(japanDateTime));
          */
        System.out.println("\n---Detail---");
        System.out.println("Depart : " + CairoDT);
        System.out.println("Arrive : " + japanDateTime);
    }
    
}
