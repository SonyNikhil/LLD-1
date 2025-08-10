package org.example.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{

    private Store store;

    private Semaphore prodSema;
    private Semaphore consSema;

    public Consumer(Store store, Semaphore prodSema, Semaphore consSema)
    {
        this.store = store;
        this.prodSema = prodSema;
        this.consSema = consSema;
    }

    @Override
    public void run(){
        while(true)
        {
            try{
                consSema.acquire(); //consumer--
            }
            catch(Exception e){
                System.out.println("Exception in consumer");
            }

            store.removeItem();

            prodSema.release(); //producer++
        }
    }
}
