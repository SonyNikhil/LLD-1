# Synchronization  

---

1. Create Adder and Subtractor Locks Package and provided same code as Adder Subtractor, which was giving error.
2. Create Lock in Client class, as we need to pass the same lock object to both Adder and Subtractor.
3. And all the threads need to use same lock object.
4. If one thread has taken lock then other thread will wait for the lock to be released.
5. Pass the same lock object with Thread pool to the Adder and Subtractor.
6. Where to use the lock? Either outside of for loop or inside of for loop.
7. Think where and why?


## Producer Consumer Semaphores Problem 

---

1. Create 2 Semaphores in client, prodSema and ConsSema -> prodSema size is 5 and consSema size is 0.
2. Send both the Semaphores to the Producer and Consumer.
3. Why are we sending both the Sema to producer and consumer?
4. Because Producer need to do prod-- and cons++ after producing one product.
5. and consumer need to do cons-- and prod++ after consuming one product.
6. We don't need this condition check in the producer - 
```java
 while(true)
        {
                if (store.getItems().size() < store.getMaxSize()) {
                    store.addItem();
                }
        }
```

7. Because we are already passing limit to the semaphore and it will always check if prodSema + consSema <= limit passed.

## We will still get error

---

1. Because the critical section in removeItem() is not handled properly.
2. We need to use some concurrent and thread safe data structure.
3. We need to use ConcurrentLinkedQueue.
4. Now only removeItem part is synchronized.
5. And in rest other part multiple threads are working at the same time.
6. But in remove part only one thread is working at a time.
