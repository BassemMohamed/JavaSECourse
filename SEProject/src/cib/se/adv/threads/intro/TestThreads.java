package cib.se.adv.threads.intro;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestThreads {
    
    public static void main(String[] args) {
        
        //testSequential();
        testParrallel();        
    }
    
    public static void testSequential() {
        NumClass n = new NumClass();
        DateClass d = new DateClass();
        n.run();
        d.run();
    }
    
    public static void testParrallel() {
        
        // Thread created using class implemenets runnable
        Thread threadN = new Thread(new NumClass());
        Thread threadD = new Thread(new DateClass());
        
        // Thread created using Anonymous Class
        Thread threadA = new Thread(new Runnable(){
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("Hello World Anonymous");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        
        // Thread created with lambda
        Thread threadL = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("Hello World Lambda");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Starting the threads!
        threadN.start();
        threadD.start();
        threadA.start();
        threadL.start();

        // Join function waits for the threads to end
        try {
            threadN.join();
            threadD.join();
            threadA.join();
            threadL.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("End of Program!");
    }
}
