package com.company;

import java.util.concurrent.Semaphore;

public class SemaphoreSample1 {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new MyWorker(semaphore));
            t.start();
        }
        System.out.println("开始！！！");
        semaphore.release(5);
        System.out.println("等待permit用光");
        while (semaphore.availablePermits() != 0) {
            Thread.sleep(1000L);
        }
        System.out.println("再次释放5个permit");
        semaphore.release(5);
    }
}

class MyWorker implements Runnable {
    private Semaphore semaphore;

    public MyWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            semaphore.acquire(1);
            System.out.println("已执行！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }
}