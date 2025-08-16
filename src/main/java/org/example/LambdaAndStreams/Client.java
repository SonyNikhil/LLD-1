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

        //Lambda Expression




    }
}
