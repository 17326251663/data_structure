package com.czxy.java78.ArrayStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/8
 * @infos
 */
public class ArrayStack2<T> {

    private int maxSize;
    private T[] arr;
    private int top;

    public ArrayStack2(int maxSize) {

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

    public boolean isOperator(char operator){
        return operator=='+'||operator=='-'||operator=='*'||operator=='/';
    }

    public int result(int num1,int num2,char operator){

        int result = 0;

        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num2 - num1;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }

        return result;
    }

    public int getOrder(char i){
        switch (i){
            case '+':
                return 0;
            case '-':
                return 0;
            case '*':
                return 1;
            case '/':
                return 1;
            default:
                return -1;
        }
    }

    public T getTop(){
        return arr[top];
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean show() {

        for (T t : arr) {
            System.out.print(t+" ");
        }
        System.out.println();

        return false;
    }

    /**
     * 只对单位整数最基本运算有效
     *
     * @param x
     * @return
     */
    public static int operational(String x) {
        //创建两个模拟栈
        //1.
        ArrayStack2<Integer> numList = new ArrayStack2<>(10);
        //2.
        ArrayStack2<Character> cList = new ArrayStack2<>(10);

        for (char c : x.toCharArray()) {
            //如果是符号
            if (numList.isOperator(c)) {
                //判断符号栈是否为空
                if (cList.size() == 0) {
                    //直接添加
                    cList.push(c);
                } else {
                    //判断当前符号栈是否大于top
                    if (cList.getOrder(c) <= cList.getOrder(cList.getTop())) {
                        //取出两个数字栈的符号
                        Integer pop1 = numList.pop();
                        Integer pop2 = numList.pop();

                        //取出一个符号栈的符号
                        Character operational = cList.pop();

                        //运算并压栈
                        int result = numList.result(pop1, pop2, operational);
                        numList.push(result);
                        //符号压栈
                        cList.push(c);
                    }
                }
            } else {
                numList.push(Integer.parseInt(c + ""));
            }

        }

        int count = 0;

        //依此取出栈中结果
        while (true) {

            int num1 = numList.pop();
            int num2 = numList.pop();

            count += numList.result(num1, num2, cList.pop());

            if (cList.size() == 0) {
                return count;
            }

        }

    }


    public static int formatSuffixExpression(String str) {

        //创建栈1
        ArrayStack2<String> s1 = new ArrayStack2<>(20);
        //创建栈2
        ArrayStack2<String> s2 = new ArrayStack2<>(20);

        //对中缀表达式进行拆分
        //抽取字符串中的所有数字串
        String[] split1 = str.replaceAll("\\+|\\(|\\)|-|\\*", "&").split("&");
        //抽取字符串中的计算符号
        String[] split2 = str.replaceAll("\\d", "").split("");

        //设置计数器
        int count = 0;

        for (int i = 0; i < split1.length; i++) {
            String indexValue = split1[i];

            //判断是否为最后一位是否为数字
            if (i == split1.length - 1 && !indexValue.equals("")) {
                s2.push(indexValue);
                break;
            }

            String fh = split2[count];

            //判断当前数组索引值是否为符号占位符
            if (!indexValue.equals("")) {
                //不为占位符就添加到s2栈中
                s2.push(indexValue);
            }

            //如果符号栈为空或(,直接压栈
            if (fh.equals("(") || s1.isEmpty() || s1.getTop().equals("(")) {
                s1.push(fh);
            }
            //判断是否遇到‘）’
            else if (fh.equals(")")) {
                //循环
                while (true) {
                    String pop = s1.pop();
                    //遇到左大括号就跳出
                    if (pop.equals("(")) {
                        break;
                    }
                    //否则就加入到s2栈中
                    s2.push(pop);
                }
            } else {
                //判断当前符号是否大于栈顶符号
                while (!(s1.getOrder(fh.charAt(0)) > s1.getOrder(s1.getTop().charAt(0)))) {
                    //取出栈顶一位数值
                    //取出符号栈一位符号
                    String s2fh = s1.pop();
                    //压入s2栈
                    s2.push(s2fh);
                    if (s1.isEmpty() || s1.getOrder(fh.charAt(0)) > s1.getOrder(s1.getTop().charAt(0))) {
                        //直接压入
                        s1.push(split2[count]);
                        break;
                    }

                }
            }
            count++;
        }

        //最后依次弹出栈1中所有数据压入栈2
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return parseSuffixExpression(s2);
    }

    public static int parseSuffixExpression(ArrayStack2<String> s) {

        List<String> list = new ArrayList<>();

        while (!s.isEmpty()) {
            list.add(s.pop());
        }

        Collections.reverse(list);

        //创建新栈,存方最终结果
        ArrayStack2<String> s1 = new ArrayStack2<>(20);
        //遍历集合进行计算
        for (String s2 : list) {

            if (s1.isEmpty()) {
                s1.push(s2);
            } else {
                //判断符号
                if (s2.equals("+") || s2.equals("-") || s2.equals("*") || s2.equals("/")) {
                    //取出栈顶两位数字
                    int num1 = Integer.parseInt(s1.pop());
                    int num2 = Integer.parseInt(s1.pop());
                    //运算
                    int result = s1.result(num1, num2, s2.charAt(0));
                    //重新压入栈
                    s1.push(result + "");

                    //直接压栈
                } else {
                    s1.push(s2);
                }
            }

        }
        return Integer.parseInt(list.get(0));
    }
}
