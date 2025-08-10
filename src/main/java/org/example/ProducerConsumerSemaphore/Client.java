package org.example.ProducerConsumerSemaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        int maxStoreSize = 5;
        Semaphore prodSema = new Semaphore(maxStoreSize);
        Semaphore consSema = new Semaphore(0);

        Store store = new Store(maxStoreSize);  // 5 shelves added in store

        for(int i = 1; i<=8; i++){
            es.execute(new Producer(store, prodSema, consSema)); // sending same store object to all threads
        }

        for(int i = 1; i<=8; i++){
            es.execute(new Consumer(store, prodSema, consSema)); // 10 producers and 10 consumers are created
        }
    }
}
