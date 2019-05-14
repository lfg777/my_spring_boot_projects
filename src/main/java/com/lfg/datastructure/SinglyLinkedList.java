package com.lfg.datastructure;

/**
 * @author fg.Li
 * 2019/5/14:20:07
 * <p>
 **/
public class SinglyLinkedList<T> {

    private transient Node head;

    private int size;

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

    public void values() {
        Node cur = head;
        while (null != cur.getNext()) {
            System.out.println(cur.getValue());
            cur = cur.getNext();
        }
        System.out.println(cur.getValue());
    }

    public void reverse() {
        Node cur = head;

        while (null != cur.getNext()) {
            Node next = cur.getNext();
            Node nnext = next.getNext();



        }
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

    }
}
