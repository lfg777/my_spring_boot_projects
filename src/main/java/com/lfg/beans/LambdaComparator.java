package com.lfg.beans;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by lifengguang on 2017/4/19.
 */
public class LambdaComparator {

    public static void main(String[] args) {
        List<Person> peoples = buildList();
        System.out.println(peoples);
        Function<Person, Integer> getAge = Person::getAge;
        Comparator<Person> byAge = Comparator.comparing(getAge);
        Comparator<Person> tComparator = Comparator.nullsFirst(byAge);

        //升序-age实现了Comparable接口
        List<Person> collect = peoples.stream().sorted(byAge).collect(Collectors.toList());
        System.out.println(collect);

        //降序-age实现了Comparable接口
        List<Person> collect1 = peoples.stream().sorted(tComparator.reversed()).collect(Collectors.toList());
        System.out.println(collect1);

        //升序-name没有实现Comparable接口
        /*Comparator<Address> cmpAddr = Comparator.comparing(Address::getAddress);
        Comparator<Person> byAddress = Comparator.comparing(Person::getAddress, cmpAddr);
        List<Student> sortedAddressList = students.stream().sorted(byAddress).collect(Collectors.toList());
        System.out.println(sortedAddressList);*/
        System.out.println("============");
        // 解释:从字符串序列中过滤出以字符a开头的字符串并迭代打印输出
        peoples.stream().filter((s)->s.getName().startsWith("d")).forEach(System.out::println);

    }

    public  static List<Person> buildList(){

        Person p1 = new Person("a",3);
        Person p2 = new Person("b",4);
        Person p3 = new Person("c",1);
        Person p4 = new Person("d",5);
        Person p5 = new Person("deeww",6);
        Person p6 = new Person("d343",9);
        List<Person> list = Arrays.asList(p1, p2, p3, p4,p5,p6);
        return list;
    }
}
