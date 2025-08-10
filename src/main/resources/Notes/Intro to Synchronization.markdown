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
8. 