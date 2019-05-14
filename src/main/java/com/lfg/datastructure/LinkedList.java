package com.lfg.datastructure;

/**
 * 双向链表
 * @author fg.Li
 * 2019/5/14:16:50
 * <p>
 **/
public class LinkedList {

    private transient LinkedNode head;

    private transient LinkedNode tail;

    private int size;
    /**
     * 反转元素
     */
    public void reverse() {

        LinkedNode current = head;
        LinkedNode temp = null;
        tail = head;
        while (current != null) {
            temp = current.getPre();
            current.setPre(current.getNext());
            current.setNext(temp);
            current = current.getPre();
        }
        if (temp != null) {
            head = temp.getPre();
        }

    }

    /**
     * 添加元素
     * @param target
     */
    public void pushNode(int target) {
        if (null == head) {
            this.head = new LinkedNode(target, null, null);
        } else if (null == tail) {
            this.tail = new LinkedNode(target, head, null);
            head.setNext(tail);
        } else {
            LinkedNode node = new LinkedNode(target,tail,null);
            this.tail.setNext(node);
            this.tail = node;
        }
        size++;
    }

    /**
     * 遍历元素
     */
    public void values() {
        LinkedNode node = head;
        while (null != node) {
            System.out.println(node.getValue());
            node = node.getNext();
        }
    }

    /**
     * 反序遍历元素
     */
    public void reverseValues() {
        LinkedNode node = tail;
        while (null != node) {
            System.out.println(node.getValue());
            node = node.getPre();
        }
    }


    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.pushNode(1);
        list.pushNode(2);
        list.pushNode(3);
        list.pushNode(4);
        list.pushNode(5);
        list.pushNode(6);
        System.out.println("========正序遍历========");
        list.values();
        System.out.println("========倒序遍历========");
        list.reverseValues();
        System.out.println("========反转========");
        list.reverse();
        list.values();
    }








}
