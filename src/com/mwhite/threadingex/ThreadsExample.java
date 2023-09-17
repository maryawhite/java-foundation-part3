package com.mwhite.threadingex;

public class ThreadsExample {

    public static void main(String[] args) {

        System.out.println("Hello from the main thread. My name is: " + Thread.currentThread().getName());

        Thread anotherThread = new AnotherThread();

        anotherThread.start();
        new Thread() {
            public void run() {
                System.out.println("This is an anonymous class Thread. My name is: " + currentThread().getName());
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();

        System.out.println("Hello again from the main thread. My name is: " + Thread.currentThread().getName());
        System.out.println("thread count " + Thread.activeCount());
        System.out.println("current thread: " + Thread.currentThread());
        System.out.println("myRunnable is alive? " + myRunnableThread.isAlive());
        System.out.println("Another Thread is alive? " + anotherThread.isAlive());

    }
}
