package com.czxy.java78.gkp;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/6
 * @infos
 */
public class GLinkedList<T> implements Iterable<T> {
    //为链表添加一个头信息
    private GLinkedDesign<T> head;
    private int size = 0;
    private GLinkedDesign<T> last = head;

    public GLinkedList() {
        this.head = new GLinkedDesign<>();
    }

    //为链表添加一个对象
    public void add(T t) {
        //获取链表中最后一个节点的信息
        GLinkedDesign<T> lastNode = getLastNode();

        if (lastNode == null) lastNode = head;

        //添加节点信息到最后一个节点的next中
        GLinkedDesign<T> gt = new GLinkedDesign<>(t);

        lastNode.setNext(gt);
        last = gt;

        size++;
    }

    /**
     * 为指定索引添加节点
     *
     * @param t     节点原型对象
     * @param index 指定索引
     */
    public void add(T t, int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        //定义计数器
        int count = -1;
        //定义两个辅助来完成遍历和添加
        GLinkedDesign<T> temp = head;
        GLinkedDesign<T> beforeTemp = null;


        while (true) {
            //如果查询到指定索引
            if (count == index) {

                //封装要添加对象
                GLinkedDesign<T> now = new GLinkedDesign<>(t);
                //添加后边到当前节点信息
                now.setNext(temp);
                //替换原有节点信息
                beforeTemp.setNext(now);

                if (index == size - 1) {
                    last = now;
                }

                size++;

                return;
            }
            beforeTemp = temp;
            temp = temp.getNext();
            count++;
        }
    }

    /**
     * 单链表的反转
     */
    public void reverse() {

        if (isEmpty() || size == 1) return;

        //需要两个辅助来进行遍历反转
        GLinkedDesign<T> temp = head;
        GLinkedDesign<T> news = new GLinkedDesign<>();


        while (true) {

            if (temp.getNext() == null) {
                head = news;
                break;
            }

            //拿到下一个节点
            //拿到需要取出一个节点
            GLinkedDesign<T> uNode = temp.getNext();

            temp.setNext(uNode.getNext());

            if (news.getNext() == null) {
                uNode.setNext(null);
                news.setNext(uNode);
            } else {
                uNode.setNext(news.getNext());
                news.setNext(uNode);
            }


        }
    }

    /**
     * 反转展示
     */
    public void reverseShow() {
        show(head.getNext());
        System.out.println("]");
    }

    private void show(GLinkedDesign<T> e) {
        if (e.getNext() != null) {
            show(e.getNext());
            System.out.print(" ," + e.getT());
        } else {
            System.out.print("[" + e.getT());
        }

    }

    /**
     * 反转展示2
     */
    public void reverseShowWithStack() {

        if (isEmpty()) return;

        GLinkedDesign<T> stemp = head.getNext();

        Stack<T> ts = new Stack<>();

        while (stemp != null) {
            ts.push(stemp.getT());
            stemp = stemp.getNext();
        }
        while (ts.size() > 0) {
            System.out.print(ts.pop() + " ,");
        }
        System.out.println();


    }

    public void addAll(GLinkedList<T> list) {

        if (list.isEmpty()) return;

        last.setNext(list.head.getNext());

        last = list.last;

        size += list.size;
    }

    //遍历展示链表中的所有节点信息
    public void list() {
        //创建一个辅助来进行遍历
        GLinkedDesign<T> temp = head;
        while (true) {
            //如果寻找到最后一个节点,跳出
            if (temp.getNext() == null) {
                break;
            }
            temp = temp.getNext();
            System.out.println(temp.getT());
        }

    }

    //获取最后一个节点中的原型对象并返回
    public T getLast() {
        //获取链表中最后一个节点的信息
        //提取原型并返回
        return getLastNode().getT();
    }

    //获取链表第一个节点的原型对象
    public T getFirst() {

        if (isEmpty()) return null;

        return head.getNext().getT();
    }

    //获取指定索引的节点对象
    public T getIndex(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        //设置计数器
        int count = -1;
        //提供一个辅助来进行遍历
        GLinkedDesign<T> temp = head;

        while (true) {
            //判断是否为指定索引的节点
            if (count == index) {
                return temp.getT();
            }
            temp = temp.getNext();
            count++;
        }
    }

    //删除链表中最后一个节点并返回节点信息
    public T removeLast() {
        //判断链表是否空
        if (isEmpty())
            return null;

        //创建一个辅助来进行遍历
        GLinkedDesign<T> temp = head;
        GLinkedDesign<T> beforeTemp = null;

        while (true) {
            //如果寻找到最后一个节点,跳出
            if (temp.getNext() == null) {
                break;
            }
            //拿到倒数第二个节点
            beforeTemp = temp;
            temp = temp.getNext();
        }

        T t = temp.getT();
        //删除倒数第二个节点中的next节点信息，指向为空
        beforeTemp.setNext(null);

        last = beforeTemp;

        size--;

        return t;
    }

    /**
     * 清空链表
     */
    public void remove() {
        size = 0;
        head.setNext(null);
    }

    /**
     * 删除指定索引的节点信息
     *
     * @param index 索引
     * @return 删除节点的元素信息
     */
    public T remove(int index) {

        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        //初始化计数器
        int count = -1;

        //提供两个辅助来完成遍历和删除
        GLinkedDesign<T> temp = head;
        GLinkedDesign<T> before = null;

        while (true) {

            if (count == index) {
                before.setNext(temp.getNext());
                size--;

                if (index == size - 1) {
                    last = before;
                }
                return temp.getT();
            }

            before = temp;
            temp = temp.getNext();
            count++;
        }


    }

    //查找链表中最后一个节点的信息并返回
    private GLinkedDesign<T> getLastNode() {

        //判断链表是否空
        if (isEmpty())
            return null;

//        //创建一个辅助来进行遍历
//        GLinkedDesign<T> temp = head;
//        while (true) {
//            //如果寻找到最后一个节点,跳出
//            if (temp.getNext() == null) {
//                break;
//            }
//            temp = temp.getNext();
//        }
        return last;
    }

    public boolean isEmpty() {

        if (head.getNext() == null)
            return true;
        else
            return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            //定义计数器
            int count = 0;
            GLinkedDesign<T> temp = head;

            @Override
            public boolean hasNext() {
                return count != size;
            }

            @Override
            public T next() {

                count++;

                GLinkedDesign<T> result = temp;

                temp = temp.getNext();

                return result.getNext().getT();
            }
        };
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();

        str.append("[");

        for (T t : this) {
            str.append(t.toString() + " ,");
        }
        str.append("]");

        return str.toString().replaceAll(" ,]", "]");
    }
}
