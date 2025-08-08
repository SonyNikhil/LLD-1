package org.example.AdderSubtractorSynchronised;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void>
{

    Count count;

    public Subtractor(Count count){
        this.count = count;
    }

    @Override
    public Void call() throws Exception
    {

        for(int i = 0; i<100000; i++){
            synchronized (count) { // Implicit lock on count object
                count.value = count.value - 1;
            } // unlocking the object so other threads can access it
        }
        System.out.println("Subtractor is done -> "+ count.value);
        return null;
    }
}

