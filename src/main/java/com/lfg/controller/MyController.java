package com.lfg.controller;

import com.lfg.annotations.NcCat;
import com.lfg.beans.DataSourceProperties;
import com.lfg.beans.Person;
import com.lfg.service.TestForCacheable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/b/{name}")
    @ResponseBody
    public String getHello(@PathVariable String name,@RequestParam("val")String val){
        return "hello-"+name+"-"+val;
    }

    @RequestMapping(value = "/aa",method = RequestMethod.GET)
    @NcCat
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

    @RequestMapping("/tree")
    public String showTree(Model model) {
        String data = "{  \n" +
                "  \"name\":\"中国\",  \n" +
                "  \"children\":  \n" +
                "  [  \n" +
                "    {  \n" +
                "      \"name\":\"浙江\" ,  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {\"name\":\"杭州\" },  \n" +
                "        {\"name\":\"宁波\" },  \n" +
                "        {\"name\":\"温州\" },  \n" +
                "        {\"name\":\"绍兴\" }  \n" +
                "      ]  \n" +
                "    },  \n" +
                "  \n" +
                "    {  \n" +
                "      \"name\":\"广西\" ,  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {  \n" +
                "          \"name\":\"桂林\",  \n" +
                "          \"children\":  \n" +
                "          [  \n" +
                "            {\"name\":\"秀峰区\"},  \n" +
                "            {\"name\":\"叠彩区\"},  \n" +
                "            {\"name\":\"象山区\"},  \n" +
                "            {\"name\":\"七星区\"}  \n" +
                "          ]  \n" +
                "        },  \n" +
                "        {\"name\":\"南宁\"},  \n" +
                "        {\"name\":\"柳州\"},  \n" +
                "        {\"name\":\"防城港\"}  \n" +
                "      ]  \n" +
                "    },  \n" +
                "  \n" +
                "    {  \n" +
                "      \"name\":\"黑龙江\",  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {\"name\":\"哈尔滨\"},  \n" +
                "        {\"name\":\"齐齐哈尔\"},  \n" +
                "        {\"name\":\"牡丹江\"},  \n" +
                "        {\"name\":\"大庆\"}  \n" +
                "      ]  \n" +
                "    },  \n" +
                "  \n" +
                "    {  \n" +
                "      \"name\":\"新疆\" ,  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {\"name\":\"乌鲁木齐\"},  \n" +
                "        {\"name\":\"克拉玛依\"},  \n" +
                "        {\"name\":\"吐鲁番\"},  \n" +
                "        {\"name\":\"哈密\"}  \n" +
                "      ]  \n" +
                "    }  \n" +
                "  ]  \n" +
                "}  ";
        model.addAttribute("data", data);
        return "tree";

    }

    @RequestMapping("/getData")
    @ResponseBody
    public String getData() {
        String data = "{  \n" +
                "  \"name\":\"50192418\",  \n" +
                "  \"children\":  \n" +
                "  [  \n" +
                "    {  \n" +
                "      \"name\":\"默认标签\" ,  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {\"name\":\"额度评估\" },  \n" +
                "        {\"name\":\"信息授权\" },  \n" +
                "        {\"name\":\"借款状态\" },  \n" +
                "        {\"name\":\"绑卡\" }  \n" +
                "      ]  \n" +
                "    },  \n" +
                "  \n" +
                "    {  \n" +
                "      \"name\":\"分期商城\" ,  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {  \n" +
                "          \"name\":\"信息授权\",  \n" +
                "          \"children\":  \n" +
                "          [  \n" +
                "            {\"name\":\"手机认证\"},  \n" +
                "            {\"name\":\"淘宝认证（二维码在前）\"},  \n" +
                "            {\"name\":\"淘宝认证（只有账号）\"},  \n" +
                "            {\"name\":\"淘宝认证（只有二维码）\"}  \n" +
                "          ]  \n" +
                "        },  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"}  \n" +
                "      ]  \n" +
                "    },  \n" +
                "  \n" +
                "    {  \n" +
                "      \"name\":\"卡牛\",  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"}  \n" +
                "      ]  \n" +
                "    },  \n" +
                "  \n" +
                "    {  \n" +
                "      \"name\":\"车轮查违章\" ,  \n" +
                "      \"children\":  \n" +
                "      [  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"},  \n" +
                "        {\"name\":\"...\"}  \n" +
                "      ]  \n" +
                "    }  \n" +
                "  ]  \n" +
                "}  ";

        //data = "{\"name\":\"zhongguo\"}";

        return data;
    }


}
