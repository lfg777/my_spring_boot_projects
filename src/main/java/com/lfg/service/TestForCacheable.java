package com.lfg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by lifengguang on 2017/5/27.
 */
@Service
public class TestForCacheable {


    @Autowired
    private TestCacheable testCacheable;

   /* @Cacheable(cacheManager = "cacheManager", cacheNames = "commonCache", unless = "#result=='1'")
    public String test(int index){
        int next = index+1;
        System.out.println("===为从缓存中获取");
        return String.valueOf(next);
    }*/

    public String test(int index) {
        return this.testCacheable.test(index);
    }

}
