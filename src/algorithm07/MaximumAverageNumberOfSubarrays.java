package algorithm07;

/**
 *  子数组最大平均数
 *
 *  给一个整数数组，找出平均数最大且长度为k的下标连续的子数组，并输出该最大平均数。
 *
 *  输入：[1,12,-5,-6,50,3],k=4
 *  输出：12.75
 *  最大平均数(12-5-6+50)/4=51/4=12.75
 * */
public class MaximumAverageNumberOfSubarrays {
    public static void main(String[] args){
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
    //方法：滑动窗口算法
    //给一个整数数组，找出平均数最大且长度为k的下标连续的子数组，并输出该最大平均数。
    //  6 2 7 5 4 3 1
    // ↑     ↑
    //  6 2 7 5 4 3 1
    //   ↑     ↑
    //窗口移动时，窗口内的和等于sum加上新加进来的值，减去出去的值
    //滑动窗口算法其实就是双指针的特例
    public static double findMaxAverage(int[] nums,int k){
        int sum = 0;
        int n = nums.length;
        //  先统计最初窗口的和 6 + 2 + 7 + 5 =
        for(int i=0;i<k;i++){
            sum += nums[i];
        }
        int max = sum;
        // i取值[k,n] 体现滑动 nums[i-k]表示第一个指针所指元素 nums[i]表示第二个指针所指元素
        for(int i=k;i<n;i++){
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(sum,max);
        }
        return 1.0 * max / k;
    }
}
