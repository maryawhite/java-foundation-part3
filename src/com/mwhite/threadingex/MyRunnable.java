package com.mwhite.threadingex;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("This is MyRunnable's implementation of run. My name is: " + Thread.currentThread().getName());
    }
}
