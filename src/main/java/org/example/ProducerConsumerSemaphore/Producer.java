package org.example.ProducerConsumerSemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable{

    private Store store;
    private Semaphore prodSema;
    private Semaphore consSema;

    public Producer(Store store, Semaphore prodSema, Semaphore consSema){
        this.store = store;
        this.prodSema = prodSema;
        this.consSema = consSema;
    }

    @Override
    public void run(){

        while(true)
        {
                try{
                    prodSema.acquire(); //producer--
                }
                catch(Exception e){
                    System.out.println("Exception in producer");
                }

                store.addItem();;
                consSema.release();  //consumer++
        }
    }
}
