package cib.se.adv.threads.bus_reservation;

public class MyBus implements Runnable {
    
    private int totalSeatsAvailable = 2;

    public void run() {
                  
        PassengerThread pt = (PassengerThread) Thread.currentThread();  
        boolean ticketsBooked = this.bookTickets(pt.getSeatsNeeded(), pt.getName());
    
        if(ticketsBooked==true){
            System.out.println("CONGRATS "+Thread.currentThread().getName()+" .. The number of seats requested("+pt.getSeatsNeeded()+")  are BOOKED");
        }else{
            System.out.println("Sorry Mr. "+Thread.currentThread().getName()+" .. The number of seats requested("+pt.getSeatsNeeded()+")  are not available");       
        }
    }
    
    public synchronized boolean bookTickets(int seats, String name){

        System.out.println("Welcome to HappyBus "+ Thread.currentThread().getName()+ 
                           " Number of Tickets Available are:"+this.getTotalSeatsAvailable());
        
        if (seats>this.getTotalSeatsAvailable()) {
            return false;
        } else {
            totalSeatsAvailable = totalSeatsAvailable-seats;
            return true;
        }
    }

    public int getTotalSeatsAvailable() {
        return totalSeatsAvailable;
    }
}
