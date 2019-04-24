package com.lfg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fg.Li
 * 2019/3/13:17:17
 * <p>
 **/
@Controller
@RequestMapping("/requestMappingTest")
public class RequestMappingController {

    @RequestMapping("/get")
    @ResponseBody
    public String getRequestMappingTest() {
        return "requestMappingTest";
    }

}
