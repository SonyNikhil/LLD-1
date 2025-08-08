package org.example.AdderSubtractorSynchronisedMethods;

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

        for(int i = 0; i<100; i++){
            count.decrement(i);
        }
        System.out.println("Subtractor is done -> "+ count.value);
        return null;
    }
}

