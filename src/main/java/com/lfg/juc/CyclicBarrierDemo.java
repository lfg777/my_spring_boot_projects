package com.lfg.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author fg.Li
 * 2019/3/27:13:15
 * <p>
 **/
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务...");
            }
        });

        Thread0 thread0 = new Thread0(barrier);
        Thread0 thread1 = new Thread0(barrier);
        Thread0 thread2 = new Thread0(barrier);
        Thread0 thread3 = new Thread0(barrier);
        Thread0 thread4 = new Thread0(barrier);
        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
//        thread4.start();
        System.out.println("老板离场...");

    }



    static class Thread0 extends Thread{

        public Thread0(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        private CyclicBarrier barrier;

        @Override
        public void run() {
            for (int i = 1; i <= 3; i++) {
                try {
                    barrier.await();
                    System.out.println("线程：" + Thread.currentThread().getName() + "执行第" + i + "个任务");
                    Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1000L));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
