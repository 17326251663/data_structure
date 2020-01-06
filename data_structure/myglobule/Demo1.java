package com.czxy.java78.myglobule;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/12
 * @infos 计算小球迷宫回溯问题
 */
public class Demo1 {
    public static void main(String[] args) {
        //设置墙体
        int[][] arr = new int[8][7];
        //填充墙体
        setWall(arr);
        //打印墙体
        showWall(arr);

        setWay(arr,1,2);
        System.out.println("---------------------");
        showWall(arr);
        System.out.println("==================================");
        int a = 10;
        int b = 4;
        System.out.println(a-b);
        System.out.println(Math.abs(a-b));
    }

    private static void showWall(int[][] wall) {
        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[i].length; j++) {
                System.out.printf("%d\t", wall[i][j]);
            }
            System.out.println();
        }
    }

    public static void setWall(int[][] wall) {

        for (int i = 0; i < wall.length; i++) {
            for (int j = 0; j < wall[i].length; j++) {
                if (i == 0 || j == 0 || i == wall.length - 1 || j == wall[i].length - 1) {
                    wall[i][j] = 1;
                }
            }
        }
        wall[3][1] =1;
        wall[3][2] =1;
    }

    public static boolean setWay(int[][] way,int i ,int j){
        //找到这个出口
        if (way[5][1]==2){
            return true;
        }else {
            //如果当前点是没有走过的
            if(way[i][j]==0) {
                //假设当前点是可以走通的
                way[i][j] = 2;
                if (setWay(way, i + 1, j)) {
                    return true;
                } else if (setWay(way, i, j + 1)) {
                    return true;
                } else if (setWay(way, i - 1, j)) {
                    return true;
                } else if (setWay(way, i, j - 1)) {
                    return true;
                } else {
                    way[i][j] = 3;
                    return false;
                }
            }else {
                return false;
            }
        }
    }
}
