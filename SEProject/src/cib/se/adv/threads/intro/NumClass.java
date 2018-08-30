package cib.se.adv.threads.intro;

public class NumClass implements Runnable {
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }    
    }
}
