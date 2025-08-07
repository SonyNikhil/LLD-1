package org.example.MultiThreadedMergeSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> arrToSort = new ArrayList<>(Arrays.asList(1,5,7,9,3,0,12,13,16,18,20));

        //1. Define Task -> java class sorter which implements Callable

        ExecutorService es = Executors.newCachedThreadPool();

        SorterClass sorter = new SorterClass(arrToSort);

        Future<ArrayList<Integer>> sortedArrayFuture = es.submit(sorter);

        ArrayList<Integer> sortedArray = sortedArrayFuture.get();

        System.out.println(sortedArray);

        /** Till now we are creating new ExecutorService for every task.
         *  We can use a single thread pool to run all the tasks.
         *  We are creating it in Sorter class so it will create a new pool everytime it's getting called.
         *  Not a good idea.
         *  We can create once thread pool in main and pass the same one through constructor
         *  to use same thread pool throughout the merging journey.*/


    }
}
