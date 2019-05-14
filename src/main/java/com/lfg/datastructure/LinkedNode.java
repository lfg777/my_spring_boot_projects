package com.lfg.datastructure;

/**
 * @author fg.Li
 * 2019/5/14:16:52
 * <p>
 **/
public class LinkedNode {

    private int value;

    private LinkedNode pre;

    private LinkedNode next;

    public LinkedNode(int value, LinkedNode pre, LinkedNode next) {
        this.value = value;
        this.pre = pre;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LinkedNode getPre() {
        return pre;
    }

    public void setPre(LinkedNode pre) {
        this.pre = pre;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
