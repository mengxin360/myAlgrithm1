package algorithm20;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  两数之和-无序数组
 *
 *  给定一个整数数组numbers，从数组中找出两个数满足相加之和等于目标数target。
 *
 *  假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素。
 *
 *  返回两数的下标值，以数组形式返回
 * */
public class SumOfTwoUnorderedArray {

    public static void main(String args[]){
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5,6},10)));
        System.out.println(Arrays.toString(solution2(new int[]{1,2,3,4,5,6},10)));
    }

    //暴力算法
    //时间复杂度O(n^2)   空间复杂度O(1)
    public static int[] solution(int[] nums,int target){
        for (int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }

    //暴力算法
    //时间复杂度O(n)   空间复杂度O(n)
    public static int[] solution2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0;i<nums.length;i++){
            if(map.containsKey(target -nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
