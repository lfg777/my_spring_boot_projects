package com.lfg.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author fg.Li
 * 2019/4/26:16:04
 * <p>
 **/
public class ThreadPoolShutDownTest {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);


    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"我在干活...");
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.shutdown();
        //executorService.shutdownNow();

    }
}
