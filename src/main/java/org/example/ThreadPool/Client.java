package org.example.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client
{
    public static void main(String[] args) {

//        for(int i = 0; i<100; i++){
//            NumberPrinter numberPrinter = new NumberPrinter(i);
//            if(i == 90){
//                System.out.println("I am here");
//            }
//            Thread thread = new Thread(numberPrinter);
//            thread.start();
//        }


        // ThreadPool, Queue, mechanism, Allocation

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorService es = Executors.newCachedThreadPool();
        for(int i = 1; i<=100000; i++){
            NumberPrinter numberPrinter = new NumberPrinter(i);
            if(i ==50){
                System.out.println("I am here");
            }
            es.execute(numberPrinter);
        }

        executorService.shutdown();
    }
}
