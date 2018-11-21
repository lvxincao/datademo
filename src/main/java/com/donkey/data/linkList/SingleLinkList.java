package com.donkey.data.linkList;

import com.donkey.data.linkList.Node;

/**
 * Created with IntelliJ IDEA.
 * User: lxc
 * Date: 2018/11/21
 * Time: 15:41
 * Description: 单向链表
 */
public class SingleLinkList {

    public Node dummyHead;

    private int size;

    public SingleLinkList() {
        //初始时令head和current都是头指针，即下一节点为头结点，即数据为空
        dummyHead = new Node();
        size = 0;
    }

    //获取链表中的元素个数
    public void setSize(int size) {
        this.size = size;
    }

    //返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //在链表的index(0-based)位置添加新的元素value
    public void add(int index, String value){
        if(index <0 || index > size){
            throw new IllegalArgumentException("Add failed. Illfgal index");
        }
        Node prev = dummyHead;
        for(int i=0;i <index;i++){
            prev = prev.next;
        }
        prev.next = new Node(value,prev.next);
        size ++;
    }

    //添加到头部
    public void addFrist(String value){
        add(0,value);
    }

    //从尾部添加
    public void addLast(String value){
        add(size, value);
    }

    //获取链表的第index个位置的元素
    public String get(int index){
        if(index <0 || index >=size){
            throw new IllegalArgumentException("Get fail,Illegal index");
        }
        Node currentNode = dummyHead.next;
        for(int i =0; i<index;i++){
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    //获取链表的第一个元素
    public String getFirst(){
        return get(0);
    }

    //获取链表的最后一个元素
    public String getLast(){
        return get(size -1);
    }

    public void set(int index, String value){
        if(index <0 || index >=size){
            throw new IllegalArgumentException("Update failed.Innegal index.");
        }
        Node currentNode = dummyHead.next;
        for(int i=0;i< index;i++){
            currentNode = currentNode.next;
        }
        currentNode.val = value;
    }

    /**
     * 查看链表中是否包含某数据
     * @param value
     * @return
     */
    public boolean contains(String value){
        Node currentNode = dummyHead.next;
        while (currentNode != null){
            if(currentNode.val.equals(value)){
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    //从链表中删除index位置的元素，返回删除的元素
    public String remove(int index){
        if(index <0 || index >= size){
            throw new IllegalArgumentException("Remove faild.Index is illegal");
        }
        Node prev = dummyHead;
        for(int i=0;i< index;i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.val;
    }

    //从链表中删除第一个元素，返回删除的元素
    public String removeFirst(){
        return remove(0);
    }

    //从链表中删除最后一个元素，返回删除的元素
    public String removeLat(){
        return remove(size -1);
    }

    //从链表中删除元素
    public void removeElement(String value){
        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.val.equals(value)){
                break;
            }
            prev = prev.next;
        }
        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = dummyHead.next;
        while(cur != null){
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }

    //判断是否是回文
    public boolean isHuiwen(){
        if(dummyHead == null || dummyHead.next == null){
            return true;
        }
        Node prev = null;
        //定义慢指针
        Node slow = dummyHead.next;
        //定义快指针
        Node fast = dummyHead.next;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            Node next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        if(fast != null){
            slow = slow.next;
        }
        while (slow != null){
            if(!slow.val.equals(prev.val)){
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList();
        singleLinkList.addLast("1");
        singleLinkList.addLast("2");
        singleLinkList.addLast("3");
        singleLinkList.addLast("4");
        singleLinkList.addLast("4");
        singleLinkList.addLast("3");
        singleLinkList.addLast("2");
        singleLinkList.addLast("1");
        System.out.println(singleLinkList.isHuiwen());

    }

}