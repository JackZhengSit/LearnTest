package com.company;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        System.out.println("开始！！！");
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SemaphoreWorker(semaphore));
            t.start();
        }
    }
}

class SemaphoreWorker implements Runnable {
    private Semaphore semaphore;
    private String name;

    public SemaphoreWorker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    private void log(String msg) {
        if (name == null) {
            name = Thread.currentThread().getName();
        }
        System.out.println(name + ":" + msg);
    }

    @Override
    public void run() {
        try {
            log("正在等待一个permit！");
            semaphore.acquire();
            log("得到一个permit！");
            log("已执行！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            log("释放一个permit！");
            semaphore.release();
        }
    }
}