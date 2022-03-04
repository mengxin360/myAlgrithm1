package algorithm10;

/**
 *  最长连续递增序列
 *
 *  给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
 *
 *  序列的下标是连续的
 *
 *  思路：利用贪心算法
 *  一开始贪心算法并不知道这个题的解是多少，但是贪心算法会首先逐个逐个地去数数
 *  首先发现1,2,3是连续的，所以会记3是解
 *  后来又发现2,3,4，是连续的，所以记得解仍然是3
 *  最后发现3,4,5,6,7是连续的，所以记得解会变为4
 *  所以就得到了最终解
 *
 *  贪心算法会首先假设找到的一个解为最终解，随着算法执行的步步深入，会逐渐更新之前的解
 *  最后得到真正的解
 * */
public class LongestContinuousIncreasingSequence {
    public static void main(String[] args){
        System.out.println(findLength(new int[]{1,2,3,2,3,4,3,4,5,6,7}));
    }

    public static int findLength(int[] nums){
        int start = 0;
        int max = 0; // max也可以设置为Integer.MIN_VALUE 但没必要
        for(int i = 1;i<nums.length;i++){
            if(nums[i] <= nums[i-1]){
                start = i;
            }
            max = Math.max(max,i - start + 1); // max记录的是最大的值也就是解
        }
        return max;
    }
}
