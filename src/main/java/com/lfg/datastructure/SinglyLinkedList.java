package com.lfg.datastructure;

/**
 * @author fg.Li
 * 2019/5/14:20:07
 * <p>
 **/
public class SinglyLinkedList<T> {

    private transient Node head;

    private int size;

    /**
     *单向链表追加
     * @param t
     */
    public void addLast(T t) {
        if (null == head) {
            head = new Node(t,null);
        } else {
            Node cur = head;
            while (null != cur.getNext()) {
                cur = cur.getNext();
            }
            cur.setNext(new Node(t,null));

        }
        size++;
    }

    /**
     *遍历
     */
    public void values() {
        Node cur = head;
        while (null != cur.getNext()) {
            System.out.println(cur.getValue());
            cur = cur.getNext();
        }
        System.out.println(cur.getValue());
    }

    /**
     *反转 迭代
     */
    public void reverse() {
        Node cur = head;
        Node pre = null;
        while (null != cur.getNext()) {
            Node next = cur.getNext();
            cur.setNext(pre);
            pre= cur;
            cur = next;
        }
        cur.setNext(pre);
        head = cur;

    }

    /**
     * 递归反转
     */
    public void reverse(Node node) {
        if (node.getNext() == null || node == null) {
            head = node;
            return;
        }
        reverse(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
    }


    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        System.out.println("======遍历======");
        list.values();
        System.out.println("======size:"+list.size+"======");
        System.out.println("======反转======");
        list.reverse();
        list.values();
        System.out.println("======递归反转======");
        list.reverse(list.head);
        list.values();
    }
}
