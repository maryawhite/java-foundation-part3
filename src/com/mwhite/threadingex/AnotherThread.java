package com.mwhite.threadingex;

public class AnotherThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello from another thread!!! My name is: " + Thread.currentThread().getName());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("another thread woke me up!");
        }
        System.out.println("Two seconds have passed, and I'm awake now: " + currentThread().getName());
    }
}
