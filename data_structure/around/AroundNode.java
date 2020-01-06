package com.czxy.java78.around;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/7
 * @infos
 */
public class AroundNode<T> {

    private T t;
    private AroundNode<T> next;

    public AroundNode(T t) {
        this.t = t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public AroundNode<T> getNext() {
        return next;
    }

    public T getT() {
        return t;
    }

    public void setNext(AroundNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "AroundNode{" +
                "t=" + t +
                ", next=" + next +
                '}';
    }
}
