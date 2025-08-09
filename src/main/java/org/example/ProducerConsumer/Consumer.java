package org.example.ProducerConsumer;

public class Consumer implements Runnable{

    private Store store;

    public Consumer(Store store)
    {
        this.store = store;
    }

    @Override
    public void run(){
        while(true)
        {
            synchronized (store) {  // Implicit lock on store object

                //Only one thread can access the store at a time
                if (store.getItems().size() > 0) {
                    store.removeItem();
                }
            }
        }
    }
}
