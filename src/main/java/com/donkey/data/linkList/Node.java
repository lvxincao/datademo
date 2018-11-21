package com.donkey.data.linkList;

/**
 * Created with IntelliJ IDEA.
 * User: lxc
 * Date: 2018/11/21
 * Time: 15:42
 * Description: 单向链表的节点
 */
public class Node {

    //数据域
    public String val;

    //指针域
    public Node next;

    public Node() {
        this(null, null);
    }

    public Node(String val) {
        this(val, null);
    }

    public Node(String val, Node next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return val;
    }

}