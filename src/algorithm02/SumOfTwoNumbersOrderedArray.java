package algorithm02;

import java.util.Arrays;

/* 两数之和，有序数组
*
*  给定一个升序排列的整数数组numbers，从数组中找出两个数满足相加之和等于目标数target。
*
*  假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
*
*  返回两数的下标值，以数组形式返回。
* */
public class SumOfTwoNumbersOrderedArray {
    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5,6},10)));
        System.out.println(Arrays.toString(twoSearch(new int[]{1,2,3,4,5,6},10)));
        System.out.println(Arrays.toString(twoPoint(new int[]{1,2,3,4,5,6},10)));
    }
    // 解法一：暴力解法 时间复杂度 O（n^2） 数组无序也可以用
    public static int[] solution(int[] nums,int target){
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    // 解法二：二分查找 需要数组有序
    // 思路：假设x为数组中的一个值，判断target-x在不在数组中（可以利用二分法判断）
    // 时间复杂度：x向后走 为O（n）  二分查找为O(logn)
    // 所以该算法的时间复杂度为O（n*logn）
    public static int[] twoSearch(int[] numbers,int target){
        for(int i=0;i<numbers.length;i++){
            int low = i,high = numbers.length - 1;
            while(low <= high){
                int mid = (high - low)/2 + low;
                if(numbers[mid] == target - numbers[i]){
                    return new int[]{i,mid};
                }else if(numbers[mid] > target - numbers[i]){
                    high = mid - 1;
                }else {
                    low = mid + 1;
                }
            }
        }
        return new int[0];
    }
    // 解法三：双指针 需要数组有序
    // 思路：假设x指向最左侧，y指向最右侧
    // 当x + y > target时，y左移；当x + y < target时，x右移；直到x + y = target时
    // x往右移，y往左移，直至重合，所以最多就是把数组变量一遍，说以时间复杂度为O（n）
    // 此算法并没占用多余的容器，所以空间复杂度为O(1)
    public static int[] twoPoint(int[] numbers,int target){
        int low = 0,high=numbers.length-1;
        while (low < high){
            int sum = numbers[low] + numbers[high];
            if(sum == target){
                return new int[]{low,high};
            }else if(sum <target){
                low ++;
            }else {
                high --;
            }
        }
        return new int[]{0};
    }
}
