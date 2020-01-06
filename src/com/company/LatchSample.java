package com.company;

import java.util.ServiceConfigurationError;
import java.util.concurrent.CountDownLatch;

public class LatchSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new FirstBatchWorker(countDownLatch));
            t.start();
        }
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new SecondBatchWorker(countDownLatch));
            t.start();
        }

        while (countDownLatch.getCount() != 1) {
            Thread.sleep(1000L);
        }
        System.out.println("wait for first batch finish");
        countDownLatch.countDown();
    }
}

class FirstBatchWorker implements Runnable {
    private CountDownLatch countDownLatch;

    public FirstBatchWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("first batch executed !");
        countDownLatch.countDown();
    }
}

class SecondBatchWorker implements Runnable {
    private CountDownLatch countDownLatch;

    public SecondBatchWorker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try{
            countDownLatch.await();
            System.out.println("second bach executed !");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
