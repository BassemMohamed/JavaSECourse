package cib.se.adv.threads.race;

import java.util.ArrayList;

public class RaceDemo {
    
    public static void main(String[] args) {
   
        Race race = new Race();
        
        Thread t1 = new Thread(race, "Bassem");
        Thread t2 = new Thread(race, "Shennawy");
        Thread t3 = new Thread(race, "Raef");
        Thread t4 = new Thread(race, "Maged");
        
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        
        t1.setPriority(Thread.NORM_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.NORM_PRIORITY);
        
        try {
           t1.join();
           t2.join();
           t3.join();
           t4.join();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
        
       System.out.println("******************");
       System.out.println("Runners in positions");
       ArrayList<String> runnersList = Race.getRunnersList();
       int i = 0;
       
       for (String runnerName : runnersList) {
           i++;
           System.out.println(i + " " + runnerName);
       }
   }
}