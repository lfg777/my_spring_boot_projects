package com.lfg.datastructure;

/**
 * 单向链表节点
 * @author fg.Li
 * 2019/5/14:20:06
 * <p>
 **/
public class Node<T> {

    private T value;

    private Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
