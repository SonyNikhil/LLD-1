package org.example.ProducerConsumerSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Store {

    private int maxSize;
    private ConcurrentLinkedQueue<Object> items;  // Thread safe data structure

    Store(int maxSize)
    {
        this.maxSize = maxSize;
        this.items = new ConcurrentLinkedQueue<>();
    }

    public int getMaxSize(){
        return this.maxSize;
    }

    public ConcurrentLinkedQueue<Object> getItems(){
        return items;
    }

    public void addItem()
    {
        System.out.println("Producer is adding item" + this.items.size());
        this.items.add(new Object());
    }

    public void removeItem()
    {
        System.out.println("Consumer is removing item" + this.items.size());
        this.items.remove();

//        this.items.remove(this.items.size()-1);
        // All the threads will read -> 5-1 = 4th index item and try to remove that.
        // 1st thread will remove 4th index successfully, but rest threads won't have anything to remove.
        // ProducerSemaphore will increase by 3, and now listSize will also increase by 3 in next run.
    }
}
