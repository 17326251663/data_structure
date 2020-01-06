package com.czxy.java78.basketwithball;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/19
 * @infos
 */
public class FillBaskets2 {

    //球的数量
    static int balls = 5;
    //篮子数量
    static int basket = 5;
    //篮子最大长度
    static int basketMaxSize = 5;
    //结果
    static int count = 0;
    //存放结果
    static int[] result = new int[basket];
    //存放结果集的集合
    static List<int[]> list = new ArrayList<>();

    public static void main(String[] args) {
        //请输入,篮子数量,球的数量

        //球数量
        int ball = balls;

        int result = show(basket, ball, basketMaxSize);
    }

    public static int show(int basket, int ball, int basketMaxSize) {

        //设置计数器
        int count = 0;
        long l = System.nanoTime();
        //创建二维数组
        int[][] arr = new int[basket][(basketMaxSize > ball ? ball : basketMaxSize) + 1];
        //填充棋盘
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = j;
            }
        }

        js(arr, 0, 0);
        System.out.println(System.nanoTime()-l);
        System.out.println();
        System.out.println("-------------");
        sout(arr);
        System.out.printf("长度为【%d】",FillBaskets2.count);


        return 0;
    }

    public static void js(int[][] arr, int init, int length) {

        //筛选所有结果
        //每次遍历都会下移一个篮筐
        for (int i = init; i < arr.length; i++) {
            //同时换蓝中球数
            for (int j = 0; j < arr[i].length; j++) {

                    //篮中球数依次相加
                    length += arr[i][j];

                //如果刚好装满,次数加一

                if (length == balls) {
                    //把方案过程添加到数组中指定位置
                    result[i] = arr[i][j];

                    //方案加一
                    count++;

                    //刷新数组
                    if (i != result.length - 1) {
                        for (int i1 = i + 1; i1 < result.length; i1++) {
                            result[i1] = 0;
                        }
                    }

                    //打印数组
                //    System.out.println(Arrays.toString(result));

                    //并把结果添加到结果集合中
                    //list.add(Arrays.copyOf(result, result.length));
                    //跳出
                    return;
                    //如果方案正在执行
                } else if (length < balls) {

                    //把方案过程添加到数组中指定位置
                    result[i] = arr[i][j];
                    //
                    if (init != arr.length - 1) {
                        js(arr, init + 1, length);
                        length -= arr[i][j];
                    } else {
                        length -= arr[i][j];
                    }

                } else {
                    break;
                }
            }
        }

    }

    public static void sout(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }
}
