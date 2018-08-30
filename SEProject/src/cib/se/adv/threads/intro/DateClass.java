package cib.se.adv.threads.intro;

import java.text.SimpleDateFormat;

import java.util.Date;

public class DateClass implements Runnable {
    
    public void run() {
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        for (int i = 0; i < 100; i++) {
            Date d = new Date();
            System.out.println(sdf.format(d));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    
    }
}
