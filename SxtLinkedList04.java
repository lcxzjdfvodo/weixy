package com.mycollection;

/*
自定义一个链表
插入节点
 */
public class SxtLinkedList04 {
    private Node first;
    private Node last;
    private int size;


    public void add(int index,Object obj){
            Node newNode=new Node(obj);
            Node temp=getNode(index);

            if(temp!=null){
                Node up=temp.previous;

                up.next=newNode;
                newNode.previous=up;

                newNode.next=temp;
                temp.previous=newNode;
            }
    }

    public void remove(int index){
        Node temp = getNode(index);

        if(temp!=null) {
            Node up = temp.previous;
            Node down = temp.next;

            if (up != null) {
                up.next = down;
            }
            if (down != null) {
                down.previous = up;
            }
            if(index==0){
                first=down;
            }
            if(index==size-1){
                last=up;
            }
            size--;
        }

    }
    //["a","b","c","d","e","f"]
    public Object get(int index) {
        System.out.println(size);
        if (index < 0 || index > size - 1) {
            throw new RuntimeException("索引数字不合法：" + index);
        }
        Node temp=getNode(index);

        return temp!=null?temp.element:null;
    }

    public Node getNode(int index){
        Node temp = null;

        if(index<=(size>>1)) {  //size>>相当于除以2
            temp=first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }else{
            temp=last;
            for(int i=size-1;i>index;i--){
                temp=temp.previous;
            }
        }
        return temp;


    }

    public void add(Object obj) {
        Node node = new Node(obj);

        if (first == null) {
            //node.previous=null;
            //node.next=null;
            first = node;
            last = node;
        } else {

            node.previous = last;
            node.next = null;

            last.next = node;
            last = node;
        }
        size++;
    }
    public String toString(){
        //[a,b,c]  first=a,last=c
        StringBuilder sb=new StringBuilder("[");
        Node temp=first;
        while(temp!=null){
            sb.append(temp.element+",");
            temp=temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtLinkedList04 list = new SxtLinkedList04 ();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list);
        list.add(3,"啊");
        System.out.println(list);

    }

}


