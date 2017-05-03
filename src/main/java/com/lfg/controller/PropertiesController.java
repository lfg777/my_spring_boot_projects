package com.lfg.controller;

import com.lfg.beans.DataSourceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by lifengguang on 2017/5/3.
 */
@Controller
public class PropertiesController {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    public void test(){
        dataSourceProperties.getUrl();
    }
}
