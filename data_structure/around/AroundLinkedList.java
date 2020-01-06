package com.czxy.java78.around;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/7
 * @infos
 */
public class AroundLinkedList<T> {

    private AroundNode<T> link;
    private AroundNode<T> first;
    private AroundNode<T> last;

    private int size = 0;

    public AroundLinkedList() {
    }


    public void add(T t){

        //单元素自循环
        if (isEmpty()){
            link = new AroundNode<>(t);
            link.setNext(link);

            first = link;
            last = link;

            size++;return;
        }

        //多元素,撑开末尾节点和头节点添加新节点
        AroundNode<T> now = new AroundNode<>(t);

        last.setNext(now);

        now.setNext(first);

        last = now;

        size++;
    }

    public void show(){

        AroundNode<T> temp = first;

        while (true){

            System.out.println(temp.getT());

            if (temp==last){
                break;
            }

            temp = temp.getNext();

        }

    }

    public void up(int start ,int countNum){

        if (start<0||start>size||first==null){
            System.out.println("输入参数有误,请重新输入");
            return;
        }

        //找到指定位置的头
        for (int i = 0; i < start-1; i++) {
            first = first.getNext();
            last = last.getNext();
        }

        //做一个循环操作,直到链表中仅剩一个节点
        while (true){

            if (first==last){
                break;
            }
            //做一个循环,找出第个位置的节点,弹出
            for (int i = 0; i < countNum-1; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            System.out.println("弹出节点:"+first.getT());
            //取出当前尾结点,拼接到头结点的下一个节点
            first = first.getNext();
            last.setNext(first);
            size--;
        }

        System.out.println("最后剩余的节点:"+first.getT());

    }

    public AroundNode<T> getLink() {
        return link;
    }

    public void setLink(AroundNode<T> link) {
        this.link = link;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public T getFirst() {
        return first.getT();
    }

    public T getLast() {
        return last.getT();
    }
}
