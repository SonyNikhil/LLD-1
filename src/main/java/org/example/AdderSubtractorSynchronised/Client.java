package org.example.AdderSubtractorSynchronised;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client
{

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Count count = new Count();
        Adder adder = new Adder(count);
        Subtractor subtractor = new Subtractor(count);

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Void> adderFuture = es.submit(adder);
        Future<Void> subtractorFuture = es.submit(subtractor);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println("Final count is -> "+ count.value);

        es.shutdown();

    }
}
