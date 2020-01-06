package com.czxy.java78.ArrayStack;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/8
 * @infos
 */
public class ArrayStack<T> {

    private int maxSize;
    private T[] arr;
    private int top;

    public ArrayStack(int maxSize) {

        arr = (T[]) new Object[maxSize];

        this.maxSize = maxSize;
        this.top = -1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void push(T t){
        if (isFull())throw new StackOverflowError();
        arr[++top] = t;
    }

    public T pop(){
        if (top<0)throw new NullPointerException();
       return arr[top--];
    }

    private boolean isFull(){
        return top == arr.length-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }
}
