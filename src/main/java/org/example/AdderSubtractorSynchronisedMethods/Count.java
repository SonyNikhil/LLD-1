package org.example.AdderSubtractorSynchronisedMethods;

public class Count
{
    int value;

    synchronized void increment(int i)
    {
        value+= i;
    }

    synchronized  void decrement(int i)
    {
        value-= i;
    }
}
