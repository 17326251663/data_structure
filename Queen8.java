package com.czxy.java78.eightqueen;

import java.util.Arrays;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/13
 * @infos
 */
public class Queen8 {
    //表示一共有8个皇后
    int max = 8;
    //根据皇后数量生成一维数组
    int[] arr = new int[max];
    //记录全部放置成功次数
     static int count = 0;

     //打印八皇后的当前位置
     public void show(){
         System.out.println(Arrays.toString(arr));
         count++;
     }

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.println(count);
    }

     //循环遍历八皇后
    public void check(int n){
         //如果全部放置成功,就打印位置
         if (n==max){
             show();
            return;
         }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
             if (isOk(n)){
                check(n+1);
            }
        }
    }

     //判断是否能放置成功
     public boolean isOk(int now){
         for (int i = 0; i < now; i++) {
             if (Math.abs(now-i)==Math.abs(arr[now]-arr[i])||arr[i]==arr[now]){
                 return false;
             }
         }
         return true;
     }
}
