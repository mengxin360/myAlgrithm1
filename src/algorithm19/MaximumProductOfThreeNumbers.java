package algorithm19;

import java.util.Arrays;

/**
 *  三个数的最大乘积
 *
 *  整型数组nums，在数组中找出由三个数字组成的最大乘积，并输出这个乘积。
 *
 *  乘积不会越界
 *
 *  重点考察：线性扫描
 *
 * */
public class MaximumProductOfThreeNumbers {

    public static void main(String args[]){
        System.out.println(getMaxMin(new int[]{-1,2,3,4,5}));
        System.out.println(getMaxMin2(new int[]{-1,2,3,4,5}));

    }
    //思路：1、全是负数或者全是正数 都是要找三个最大数
    //      2、有正有负  取两个数的绝对值最大再加上一个最大
    //  算法时间复杂度O(N*logN)
    //方法一 先排序再找值
    public static int getMaxMin(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n-1],nums[n-1] * nums[n-2] * nums[n-3]);
    }
    //方法二 线性扫描
    public static int getMaxMin2(int[] nums){
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE,max3 = Integer.MIN_VALUE;
        for(int x : nums){
            if(x < min1){
                min1 = x;
                min2 = min1;
            }else if(x < min2){
                min2 = x;
            }
            if(x > max1){
                max1 = x;
                max2 = max1;
                max3 = max2;
            }else if(x > max2){
                max2 = x;
                max3 = max2;
            }else if(x > max3){
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1,max1 * max2 * max3);
    }

}
