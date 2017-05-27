package com.lfg.beans;

import java.util.*;
import java.util.stream.Collectors;

/**
 * jdk8新特性
 * Created by lifengguang on 2017/4/19.
 */
public class LambdaComparator {

    public static void main(String[] args) {
        LambdaComparator lc = new LambdaComparator();
        lc.sortReversed();
        lc.filters();
        lc.delOneFromList();
        lc.getMaxItem();
        lc.filter();
        lc.tet();
    }




    /**
     * 解释:从字符串序列中过滤出以字符a开头的字符串并迭代打印输出
     */
    public void filters(){
        List<Person> peoples = buildList();
        peoples.stream().filter((s)->s.getName().startsWith("d")).forEach(System.out::println);
        System.out.println("===");


    }

    /**
     * 降序排列
     */
    public void sortReversed(){
        List<Person> peoples = buildList();
        List<Person> sortedList = peoples.stream().sorted(Comparator.nullsLast(Comparator.comparing(Person::getAge)).reversed()).collect(Collectors.toList());
        System.out.println(sortedList);
        System.out.println("===");
        //并行方式
        //peoples.parallelStream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());

    }

    public  static List<Person> buildList(){

        Person p1 = new Person("a",3);
        Person p2 = new Person("b",4);
        Person p3 = new Person("c",1);
        Person p4 = new Person("d",5);
        Person p5 = new Person("deeww",6);
        Person p7 = new Person("deeww",6);
        Person p6 = new Person("d343",9);
        Person p8 = new Person("d343",9);
        List<Person> list = Arrays.asList(p1, p2, p3, p4,p5,p6,p7,p8);
        return list;
    }

    public static List<Person> buildArrayList(){
        Person p1 = new Person("a",3);
        Person p2 = new Person("b",4);
        Person p3 = new Person("c",1);
        Person p4 = new Person("d",5);
        Person p8 = new Person("d",5);
        Person p5 = new Person("deeww",6);
        Person p6 = new Person("d343",9);
        Person p7 = new Person("wddlakd",6);
        List<Person> peoples = new ArrayList<>();
        peoples.add(p1);
        peoples.add(p2);
        peoples.add(p3);
        peoples.add(p4);
        peoples.add(p5);
        peoples.add(p6);
        peoples.add(p7);
        peoples.add(p8);
        return peoples;
    }

    public void delOneFromList(){
        //不能用Arrays.asList(); iterator.remove()在list中默认抛出异常
        List<Person> peoples = buildArrayList();
        peoples.removeIf(p -> p.getAge() == 6);
        System.out.println(peoples);
        System.out.println("===");

    }

    public void getMaxItem(){
        List<Person> peoples = buildList();
        Person person = peoples.stream().max(Comparator.comparing(Person::getAge)).get();
        System.out.println(person);
        System.out.println("===");
    }

    public void filter(){
        List<Person> people = buildList();
        Set<String> set = new HashSet<>();
        List<Person> ret = new ArrayList<>();
        //筛选过滤
        //people.stream().forEach(o-> set.add(o.getName()));
        people.stream().filter((o)->!set.contains(o.getName())).forEach(o->{
            set.add(o.getName());
            ret.add(o);
        });

        System.out.println(ret);
        System.out.println("===");
    }

    public void tet(){
        List<Person> people = buildArrayList();
        System.out.println(people);
        List<Person> people1 = people.subList(0, 4);
        List<Person> people2 = people1;
        System.out.println(people1);
        System.out.println(people2);

        people.removeAll(people1);
        System.out.println(people);
        System.out.println(people2);



    }



}
