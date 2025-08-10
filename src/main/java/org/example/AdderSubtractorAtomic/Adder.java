package org.example.AdderSubtractorAtomic;

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
        for(int i = 0; i<100; i++){
//            count.value = count.value + 1;

            count.value.addAndGet(i);
        }


        System.out.println("Adder is done -> "+ count.value);
        return null;
    }
}
