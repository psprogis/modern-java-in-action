package chapter15;

import static chapter15.Functions.fo;
import static chapter15.Functions.go;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int x = 2;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> y = executorService.submit(() -> fo(x));
        Future<Integer> z = executorService.submit(() -> go(x));

        System.out.println(y.get() + z.get());

        executorService.shutdown();
    }

}
