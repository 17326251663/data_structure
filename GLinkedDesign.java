package com.czxy.java78.gkp;

import java.io.*;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/6
 * @infos
 */
public class GLinkedDesign<T> implements Serializable,Cloneable{

    private T t;
    private GLinkedDesign<T> next;

    protected GLinkedDesign(T t) {
        this.t = t;
    }

    protected GLinkedDesign() {
    }

    protected T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    protected GLinkedDesign<T> getNext() {
        return next;
    }

    protected void setNext(GLinkedDesign<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "GLinkedDesign{" +
                "t=" + t +
                ", next=" + next +
                '}';
    }
}
