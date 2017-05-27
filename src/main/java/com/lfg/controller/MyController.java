package com.lfg.controller;

import com.lfg.beans.DataSourceProperties;
import com.lfg.beans.Person;
import com.lfg.service.TestForCacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lifengguang on 2017/1/18.
 */
@Controller
public class MyController {

    @Value("${application.hello}")
    private String hello;

    @Value("${application.count}")
    private int count;

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Autowired
    private TestForCacheable testForCacheable;

    @RequestMapping("/{name}")
    public String getHello(@PathVariable String name){
        return "hello "+name;
    }

    @RequestMapping("/")
    public String index(Model model){
        Person single=new Person("aa",1);
        List<Person> people=new ArrayList<Person>();
        Person p1=new Person("bb",2);
        Person p2=new Person("cc",3);
        Person p3=new Person("dd",4);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        model.addAttribute("hello",hello);
        model.addAttribute("count",count);
        model.addAttribute("properties",dataSourceProperties.getUrl());

        return "hello";
    }

    @RequestMapping("/testForCacheable")
    @ResponseBody
    public String testForCacheable(@RequestParam("index") int index){

        return testForCacheable.test(index);
    }


}
