package com.czxy.java78.eightqueen;

import java.util.Arrays;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/13
 * @infos
 */
public class Queen8_2 {
    int max = 8;
    int[] arr = new int[max];;

    int count;

    public Queen8_2() {
    }

    //负责展示当前数组
    public void show() {
        System.out.println(Arrays.toString(arr));
        count++;
    }

    public void setWay(int n){
        if (n==max){
            show();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (isOk(n)){
                setWay(n+1);
            }
        }

    }

    //判断是否可以放置
    public boolean isOk(int n){

        //循环遍历
        for (int i = 0; i < n; i++) {
            //如果同列或者交叉相连
            if (arr[i]==arr[n]||Math.abs(i-n)==Math.abs(arr[i]-arr[n])){
                return false;
            }
        }
            return true;
    }

    public static void main(String[] args) {
        new Queen8_2().setWay(0);
    }

}
