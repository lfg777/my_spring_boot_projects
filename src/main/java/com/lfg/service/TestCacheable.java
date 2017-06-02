package com.lfg.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by lifengguang on 2017/5/31.
 */
@Service
public class TestCacheable {

    @Cacheable(cacheManager = "cacheManager", cacheNames = "commonCache", unless = "#result=='1'")
    public String test1(int index){
        int next = index+1;
        System.out.println("===为从缓存中获取");
        return String.valueOf(next);
    }

    @Cacheable(cacheManager = "cacheManager", cacheNames = "commonCache", unless = "#result=='1'")
    public String test(int index) {
        return test1(index);
    }
}
