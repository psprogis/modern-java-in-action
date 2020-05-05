package chapter15;

import static chapter15.Functions.f;
import static chapter15.Functions.g;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        int x = 2;
        Result result = new Result();

        Thread t1 = new Thread(() -> result.left = f(x));
        Thread t2 = new Thread(() -> result.right = g(x));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(result.left + result.right);
    }

    private static class Result {
        private int left;
        private int right;
    }
}
