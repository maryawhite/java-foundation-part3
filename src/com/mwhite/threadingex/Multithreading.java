package com.mwhite.threadingex;

import java.util.concurrent.CompletableFuture;

public class Multithreading {

    private static String myName = "Mary";

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> {
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myName = "Maria";
        });
        System.out.println("Main Thread ");
        System.out.println("my Name 1: " + myName);
        Thread.sleep(2000);
        System.out.println("my Name 2: " + myName);

    }
}
