package cib.se.adv.threads.bus_reservation;

public class BusReservationDemo {
  public static void main(String[] args) {
        
       MyBus br = new MyBus();
       
       PassengerThread samThread = new PassengerThread(br, "Ahmed",2);
       PassengerThread jackThread = new PassengerThread( br, "Mostafa",2);
       
       jackThread.start();
       samThread.start();
   }
}