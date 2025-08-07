package org.example.MultiThreadedMergeSort;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.*;

public class SorterClass implements Callable<ArrayList<Integer>>
{

    private ArrayList<Integer> arrToSort;

    // sending thread pool from client class.

    ExecutorService es;

    public SorterClass(ArrayList<Integer> arr, ExecutorService es){
        this.arrToSort = arr;
        this.es = es;
    }
    @Override
    public ArrayList<Integer> call()throws Exception{

        if(arrToSort.size()<=1){
            return arrToSort;
        }

        int mid = arrToSort.size()/2;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i = 0; i<mid; i++){
            left.add(arrToSort.get(i));

        }

        for(int i = mid; i<arrToSort.size(); i++){
            right.add(arrToSort.get(i));
        }


        SorterClass leftSorter = new SorterClass(left, es);
        SorterClass rightSorter = new SorterClass(right, es);

        //Runnable -> es.execute;
        //when callable is used, call submit.
        //Create thread pool, submit callable to thread pool, wait for result

//        ExecutorService es = Executors.newCachedThreadPool();

        /**
         * What submit does:
         * 1. Create a new thread
         * 2. Run the callable
         * 3. Wait for the result
         * 4. Return the result, it returns something that is called future.
         * 5. We won't get output exact same time after passing it to the thread, we have to wait till the thread finishes and returns the result.
         * 6. Whatever it return that we need to store in future type variable. and then use get method to get the result from the future.
         * 7. If i'm assigning some task, assigning takes no time, but executing and completing the task takes time.
         * 8. if i'm assigning task to left sorter and then waiting for it to return then i will assign to right sorter then i'm not
         * 9. utilizing the power of multithreading, so what we can do is we can assign the task to both the threads at same time and then wait
         * for both the threads to complete their tasks and return the result.
         * Like we place the order for food, get a receipt and then wait for that number for our food to prepared and then call us to take our food.
         * Future is that receipt and Future must know what data type will be returned to it, so we must pass the data type to the future.
         */

        Future<ArrayList<Integer>> leftFuture = es.submit(leftSorter);
        Future<ArrayList<Integer>> rightFuture = es.submit(rightSorter);

        ArrayList<Integer> sortedLeftArray = leftFuture.get(); // here we need to wait for leftArray to get completed.
        ArrayList<Integer> sortedRightArray = rightFuture.get(); // while we were waiting for leftArray to complete, rightArray was already completed.

        // earlier while we were waiting for leftArray to complete, rightArray was not even started.

        // Merge the two sorted arrays.

        int i = 0, j = 0;

        ArrayList<Integer> mergedArray = new ArrayList<>();

        while(i<sortedLeftArray.size() && j<sortedRightArray.size())
        {
            if(sortedLeftArray.get(i)<=sortedRightArray.get(j)){
                mergedArray.add(sortedLeftArray.get(i));
                i++;
            }
            else{
                mergedArray.add(sortedRightArray.get(j));
                j++;
            }
        }

        while(i<sortedLeftArray.size()){
            mergedArray.add(sortedLeftArray.get(i));
            i++;
        }
        while(j<sortedRightArray.size()){
            mergedArray.add(sortedRightArray.get(j));
            j++;
        }




        return mergedArray;
    }
}
