package org.example.ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();

        Store store = new Store(10);  // 10 shelves added in store

        for(int i = 1; i<=10; i++){
            es.execute(new Producer(store)); // sending same store object to all threads
        }

        for(int i = 1; i<=8; i++){
            es.execute(new Consumer(store)); // 10 producers and 10 consumers are created
        }
    }
}
