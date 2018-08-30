package cib.se.adv.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPoolRunnable {
    public static void main(String[] args){
    
        // Cached thread pool function fires up a new thread everytime a task is submitted
        // Fixed thread pool function waits for one of the fixed theards to finish in order to do a new task
        
       long startTime = System.currentTimeMillis();
       ExecutorService executor = Executors.newFixedThreadPool(20);
       //ExecutorService executor = Executors.newCachedThreadPool();
            
       for(int i = 0; i < 20; i++){  /// Create 20 tasks for Threads in Thread pool
           Thread task = new Thread(new TaskThreadRunnable("Task "+i));
           executor.submit(task);
       }
       
         Thread task1 = new Thread(new TaskThreadRunnable("Task 1 new "));
         Thread task2 = new Thread(new TaskThreadRunnable("Task 2 new "));
         Thread task3 = new Thread(new TaskThreadRunnable("Task 3 new "));
         executor.submit(task1);
         executor.submit(task2);
         executor.submit(task3);
         
         executor.shutdown();     
          while(!executor.isTerminated()){
              
          }
         long endTime = System.currentTimeMillis();  
         System.out.println("All Tasks are done");
         System.out.println("In time : "+(endTime - startTime));        
       
   
   }
}

