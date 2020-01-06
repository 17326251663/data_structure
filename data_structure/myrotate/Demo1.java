package com.czxy.java78.myrotate;

/**
 * @author 207798583@qq.com
 * @version 1.0
 * @date 2019/11/15
 * @infos
 */
public class Demo1 {

    public static void main(String[] args) {
        //初始化二维数组，0标识为空
        int[][] arr = new int[6][6];
        //运行算法
        run1(arr);
        show(arr);
    }

    public static void run2(int[][] arr) {

        long before = System.currentTimeMillis();

        //计算格数
        int arrlenght = arr.length * arr[0].length;

        //初始化一个坐标
        int x = 0;
        int y = 0;

        for (int i = 0; i < arrlenght; i++) {
            //设置此次遍历格子上的数
            arr[x][y] = i + 1;
            //(8,0)  如果与左下角45°相交，/2为确保坐标处于左下角 或者如果此坐标的前边或右边为空时
            if (x>arr.length/2&&Math.abs((arr.length-1)-x)==Math.abs(0-y)||(x>1&&y<arr[x].length-2&&arr[x][y+1]==0&&arr[x-1][y]==0)) {
                //向上
                x--;
                //如果此坐标的右边为空或未到达最后一个位置
            } else if (y < arr[x].length - 1 && arr[x][y + 1] == 0) {
                //向右
                y++;
                //如果此坐标的下边为空或未到达最后一个位置
            } else if (x < arr.length - 1 && arr[x + 1][y] == 0) {
                //向下
                x++;
                //如果此坐标的左边为空或未到达最后一个位置
            } else if (y > 0 && arr[x][y - 1] == 0) {
                //向左
                y--;
            }
        }

        System.out.println("耗时:"+(System.currentTimeMillis()-before));
    }


    public static void show(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t", arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void run3(int[][] arr) {
        int arrlenght = arr.length * arr[0].length;

        //设置x轴计数器
        int countX = 0;
        //设置y轴计数器
        int countY = 0;

        //计算中心位置
        int centerX = arr[0].length/2-1;
        int centerY = arr.length/2-1;

        for (int i = 0; i < arrlenght; i++) {

            arr[countY][countX] = i+1;


        }
    }

        public static void run1(int[][] arr) {

            long l = System.nanoTime();

            //计算格数
        int arrlenght = arr.length * arr[0].length;

        //初始化转弯格数
        int wayIndex = arr.length - 1;
            System.out.println(wayIndex);

        //设置x轴计数器
        int countX = 0;
        //设置y轴计数器
        int countY = 0;
        //设置步数器
        int count = 0;

        //设置方向
       final char top = '↑';
       final char bottom = '↓';
       final char left = '←';
       final char right = '→';

        //初始化方向
        char fx = right;

        for (int i = 0; i < arrlenght; i++) {

            arr[countY][countX] = i+1;

            if (count==wayIndex){

                count=0;
                switch (fx){
                    case top:
                        fx = right;
                        wayIndex-=1;
                        arr[countY][++countX]=++i+1;
                        break;
                    case right:
                        fx = bottom;
                        break;
                    case bottom:
                        fx = left;
                        break;
                    case left:
                        fx = top;
                        wayIndex--;
                        break;
                }
            }

            if (fx==right)
                countX++;
            else if (fx==bottom)
                countY++;
            else if (fx==left)
                countX--;
            else if (fx==top)
                countY--;

            count++;
        }


            System.out.println("消耗时间:"+(System.nanoTime()-l));

    }

    public static void run4(int[][] arr){

        int length = arr.length * arr[0].length;

        //获取xy
        int x = 0;
        int y = 0;
        //获取中心位置


        for (int i = 0; i < length; i++) {
            arr[y][x] = i+1;

            //向右
//            if (Math.abs(x-arr[i].length)==Math.abs(y-arr.length)&&x>){
//
//
//            }

        }

    }

}
