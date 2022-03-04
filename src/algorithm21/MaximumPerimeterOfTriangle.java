package algorithm21;

import java.util.Arrays;

/**
 *  三角形的最大周长
 *
 *  给定由一些正数(代表长度)组成的数组arr，返回由其中三个长度组成的、面积不为零的三角形
 *  的最大周长
 *
 *  如果不能形成任何面积不为零的三角形，返回0
 *
 *  主要考察：贪心算法
 *  思路：对数组进行排序，取数组中最大的三个数看是否满足三角形形成的条件，如果可以返回
 *  如果不可以，则把最后的去掉，加上第四大的元素，看这三个数是否满足三角形形成条件。。。
 *  haha
 *  hah
 * */
public class MaximumPerimeterOfTriangle {

    public static void main(String args[]){
        System.out.println(largestPerimeter(new int[]{3,6,2,3}));
    }

    public static int largestPerimeter(int[] a){
        Arrays.sort(a);
        for(int i=a.length-1;i>=2;i--){
            if(a[i-1] + a[i-2] > a[i]){
                return a[i-1] +a[i-2] +a[i];
            }
        }
        return 0;
    }

}
