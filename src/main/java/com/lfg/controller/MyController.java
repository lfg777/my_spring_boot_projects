package com.lfg.controller;

import com.lfg.beans.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

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

        return "hello";
    }


}
