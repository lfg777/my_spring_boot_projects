package com.lfg.datastructure;

/**
 * @author fg.Li
 * 2019/5/15:16:05
 * <p>
 **/
public class CyclicSinglyLinkedList extends SinglyLinkedList {

    private transient Node head;

    private int size;

    public void createCyclicNode() {
        this.head = super.head;
        this.size = super.size;
        Node cur = head;
        Node cycBegin = null;
        int i = 1;
        for (; cur.getNext() != null; ) {
            cur = cur.getNext();
            if (i == 2) {
                cycBegin = cur;
            }
            i++;
        }
        cur.setNext(cycBegin);
    }

    /**
     * 判断是否是循环链表
     * @return
     */
    public boolean isCyclicList() {
        Node first = head;
        Node seond = head;

        while (seond != null && seond.getNext() != null) {
            first = first.getNext();
            seond = seond.getNext().getNext();
            if (first == seond) {
                return true;
            }
        }
        return false;
    }

    /**
     * 循环链表长度
     * @return
     */
    public int cyclicListLength() {
        Node first = head;
        Node seond = head;
        while (seond != null && seond.getNext() != null) {
            first = first.getNext();
            seond = seond.getNext().getNext();
            if (first == seond) {
                break;
            }
        }

        Node next = first.getNext();
        int length=1;
        while (first != next) {
            length++;
            next = next.getNext();
        }
        return length;
    }

    /**
     * 获取循环链表最后节点
     * @param <T>
     * @return
     */
    public <T> T getLastCyclicNode() {
        int length = cyclicListLength();
        Node first = head;
        Node second = head;
        for (int i = 0; i < length; i++) {
            second = second.getNext();
        }

        while (second.getNext() != first.getNext()) {
            first = first.getNext();
            second = second.getNext();
        }
        return (T)second.getValue();

    }







    public static void main(String[] args) {
        CyclicSinglyLinkedList list = new CyclicSinglyLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);
        list.addLast(6);
        list.addLast(7);
        list.addLast(8);
        list.addLast(9);
        System.out.println("==创建循环链表==");
        list.createCyclicNode();
        System.out.println("==检查循环链表==");
        System.out.println(list.isCyclicList());
        System.out.println("==循环链表长度==");
        System.out.println(list.cyclicListLength());
        System.out.println("==循环链表尾节点==");
        System.out.println(""+list.getLastCyclicNode());
    }






}
