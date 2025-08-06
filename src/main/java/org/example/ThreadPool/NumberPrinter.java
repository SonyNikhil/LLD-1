package org.example.ThreadPool;

public class NumberPrinter implements Runnable
{

    private int number;

    public NumberPrinter(int num){
        number = num;
    }

    @Override
    public void run(){
        System.out.println("Thread is = "+ Thread.currentThread().getName()+ " Number is = "+number);
    }
}
