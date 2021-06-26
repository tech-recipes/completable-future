package org.techrecipe.aync;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplyAsync {

    public static void delay(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Supplier<String> supplier = () -> {
            delay(1);
            System.out.println("I am in supplier - "+ Thread.currentThread().getName());
            return "Hello from Supplier";
        };

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        System.out.println("I am in main");

        String value = completableFuture.join();
        System.out.println("Value - " + value);
    }
}
