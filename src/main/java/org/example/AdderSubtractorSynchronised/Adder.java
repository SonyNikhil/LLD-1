package org.example.AdderSubtractorSynchronised;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void>
{

    Count count;

    public Adder(Count count){
        this.count = count;
    }
    @Override
    public Void call() throws Exception
    {
        for(int i = 0; i<100000; i++){
            synchronized (count) { //Implicit lock on count object
                count.value = count.value + 1;
            }  // Implicit unlock on count object
        }

        System.out.println("Adder is done -> "+ count.value);
        return null;
    }
}
