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

        //升序
        List<Person> collect = peoples.stream().sorted(byAge).collect(Collectors.toList());
        System.out.println(collect);

        //降序
        List<Person> collect1 = peoples.stream().sorted(byAge.reversed()).collect(Collectors.toList());
        System.out.println(collect1);

    }

    public  static List<Person> buildList(){

        Person p1 = new Person("a",3);
        Person p2 = new Person("b",4);
        Person p3 = new Person("c",1);
        Person p4 = new Person("d",5);
        List<Person> list = Arrays.asList(p1, p2, p3, p4);
        return list;
    }
}
