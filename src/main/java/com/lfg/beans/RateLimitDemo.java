package com.lfg.beans;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * 令牌桶算法
 * Created by lifengguang on 2017/7/28.
 */
public class RateLimitDemo {

    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(100,3, TimeUnit.MILLISECONDS);
        for (;;) {
            System.out.println(limiter.acquire());
        }


    }

}
