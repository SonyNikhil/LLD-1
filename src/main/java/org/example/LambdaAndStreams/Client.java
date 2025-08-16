package org.example.LambdaAndStreams;

import java.util.Comparator;

public class Client
{
    public static void main(String[] args) {

        //*Anonymous class* is a class that does not have a name. And it can be used to implement interfaces, directly in the code.

        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from Runnable");
            }
        };

        Thread t1 = new Thread(r);

        Comparator<Integer> cmp = new Comparator<Integer>(){
            @Override
            public int compare(Integer num1, Integer num2){
                return 0;
            }
        };

        //Any interface can be used direclty in code, without implementing it in a solid class. Directly via anonymous class.
        SampleInterface sample = new SampleInterface() {
            @Override
            public void fun1(){
                System.out.println("fun1");
            }

            @Override
            public void fun2(){
                System.out.println("fun2");
            }
        };

        // Anonymous class done, now we can also do the same thing with lambda expression.
        // We will check lambda expression in below code snippets.

        //---------------------------------------------------------------------------------------------------//

        //Lambda Expression - It is valid only in functional interfaces.

        Runnable r1 = () -> {
            System.out.println("Hey from Lambda Expression");
        };

        Thread t2 = new Thread(r1);
        t2.start();

        Comparator<Integer> cmp1 = (element1, element2) -> {
            if(element1 > element2){
                return 1;
            }
            else if(element1 < element2){
                return -1;
            }
            else{
                return 0;
            }

            // Another way to write this code
            //return element1-element2;
        };

        //Passing lambda expression to thread by directly creating where argument is expected.
        Thread t3 = new Thread(() -> {
            System.out.println("Hey from Lambda Expression, creating a runnable directly. It's mapping to runnable abstract method.");
        });

        Thread t4 = new Thread( ()  -> System.out.println("Another way of creating runnable"));








    }
}
