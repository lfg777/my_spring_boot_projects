package com.lfg.datastructure;

/**
 * @author fg.Li
 * 2019/5/14:20:07
 * <p>
 **/
public class SinglyLinkedList<T> {

    protected transient Node head;

    protected int size;

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

    /**
     *获取倒数第K个节点，如果链表维护了长度size,则倒数第k个即为正数第（n-k+1）个
     * 如果没有size字段，则反转，再取第K个
     */
    public <T> T getReverseIndexNode(int index) {
        if (index > size || index <= 0) {
            return null;
        }
        Node node = head;
        int curIndex = 1;
        while (node.getNext() != null) {
            if (curIndex == size - index + 1) {
                break;
            }
            node = node.getNext();
            curIndex++;
        }
        return (T) node.getValue();
    }

    /**
     * 获取倒数第K个数，无size，不遍历情况。
     * 这里需要声明两个指针：即两个结点型的变量first和second，首先让first和second都指向第一个结点，然后让second结点往后挪k-1个位置，此时first和second就间隔了k-1个位置，
     * 然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
     * @param index
     * @param <T>
     * @return
     */
    public <T> T getReverseIndexNodeQk(int index) {
        Node first = head;
        Node secode = head;

        for (int i=0; i<index-1;i++ ) {
            secode = secode.getNext();
        }

        for (; secode.getNext() != null; ) {
            first = first.getNext();
            secode = secode.getNext();
        }
        return (T)first.getValue();


    }

    /**
     * 获取中间节点
     * @param <T>
     * @return
     */
    public <T> T getMidNode() {
        Node first = head;
        Node secode = head;

        while (secode != null && secode.getNext() != null) {
            first = first.getNext();
            secode = secode.getNext().getNext();
        }
        return (T)first.getValue();
    }

    /**
     * 判断链表是否是回文链表
     *能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     * 快慢指针，先找到中间节点，反转后半部分，再比较
     */
    public boolean isPalindrome() {
        Node slow = head;
        Node fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        Node node = reverseHalf(slow.getNext());
        slow = head;
        while (node != null) {
            if (slow.getValue() != node.getValue()) {
                return false;
            }
            slow = slow.getNext();
            node = node.getNext();
        }
        return true;
    }

    public static void isPalindrome(SinglyLinkedList<Integer> list) {
        list.addLast(6);
        list.addLast(5);
        list.addLast(4);
        list.addLast(3);
        list.addLast(2);
        list.addLast(1);
        System.out.println("====是否是回文====");
        System.out.println(list.isPalindrome());

    }

    private Node reverseHalf(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node next = reverseHalf(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return next;
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
        System.out.println("======倒数第4个值:3======");
        System.out.println(""+list.getReverseIndexNode(4));
        System.out.println("======倒数第4个值:3======");
        System.out.println(""+list.getReverseIndexNodeQk(4));
        System.out.println("======倒数第4个值:4======");
        list.getMidNode();
        SinglyLinkedList.isPalindrome(list);

    }
}
