package org.example.ProducerConsumerSynchronised;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private int maxSize;
    private List<Object> items;

    Store(int maxSize)
    {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public int getMaxSize(){
        return this.maxSize;
    }

    public List<Object> getItems(){
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
        this.items.remove(this.items.size()-1);
    }
}
