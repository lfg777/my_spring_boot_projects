package com.lfg.schedule;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

/**
 * Created by lifengguang on 2017/1/19.
 */
@EnableScheduling
@Service
public class MyScheduleDemo {

    //@Scheduled(cron = "0/3 * * * * ?")
    public void execute(){
        System.out.println("================"+System.currentTimeMillis());
    }

}
