package com.czxy.java78.myrotate;

public class demo {
    public static void main(String[] args) {

        int[][] a = new int[10][7];
        long l = System.currentTimeMillis();
        int xx = 0;
            int yy = 0;
            int aa = 1;
            int num = 0;
        for (int i = 1; i <= a.length * a[0].length; i++) {

            a[yy][xx]=i;
            if (aa%4==0){
                yy--;
                if (yy == num){
                    num++;
                    aa=1;
                    xx =num;
                    yy = num;
                }
            }else if (aa%3==0){
                xx--;
                if (xx == num){
                    aa++;
                }
            }else if (aa%2==0){
                yy++;
                if (yy == a.length-num-1){
                    aa++;
                }
            }else if (aa%1==0){
                xx++;
                if (xx ==a[0].length-num-1){
                    aa++;
                }
                if (xx >a[0].length-num-1){
                    aa++;
                    xx--;
                    yy++;
                }
            }
        }
        System.out.println(System.currentTimeMillis()-l);

    }

    public static void show(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t",arr[i][j]);
            }
            System.out.println();
        }
    }
}
