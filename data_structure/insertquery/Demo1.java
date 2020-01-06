package com.czxy.java78.insertquery;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/12/2
 * @infos
 */
public class Demo1 {
    public static void main(String[] args) {
        int[] arr = {1,12,45,67,456,1000};
        System.out.println(insertQuery(arr, 0, arr.length - 1, 67));
    }


    public static int insertQuery(int[] arr ,int left  , int right ,  int findValue){

        if (right<left){
            return -1;
        }
            //    0+(5-0)*(67-1)/(1000-1)
        int mid = left+(right-left)*(findValue - arr[left])/(arr[right] - arr[left]);
        System.out.println(mid);

        if (arr[mid]==findValue){
            return mid;
        }

        if (arr[mid] > findValue){
            //向左递归
           return insertQuery(arr,left,mid,findValue);
        }else {
            //向右递归
          return   insertQuery(arr,mid+1,right,findValue);
        }
    }
}
