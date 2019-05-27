package com.lfg.datastructure;

import java.util.Stack;

/**
 * 栈实现队列,两个栈即可实现队列
 * @author fg.Li
 * 2019/5/15:17:19
 * <p>
 **/
public class StackQueueStructure<E> {

    private transient Stack<E> stack1 = new Stack();

    private transient Stack<E> stack2 = new Stack();

    public void put(E e) {
        stack1.push(e);
    }

    public E pop() {
        if (stack2.isEmpty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();


    }


    public static void main(String[] args) {
        StackQueueStructure<String> ss = new StackQueueStructure<>();
        ss.put("a");
        ss.put("b");
        ss.put("c");
        ss.put("d");
        String pop = null;
        do {
            pop = ss.pop();
            System.out.println(pop);
        } while (!pop.equals("d"));

    }











}
