package algorithm15;

/**
 *  删除排序数组中的重复项
 *
 * 一个有序数组nums，原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度
 *
 * 不能使用额外的数组空间，必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 * 例：输入：[0,1,2,2,3,3,4]
 *     输出：5
 * 重点考察：双指针算法
 * */
// java中的数组没有提供删除数组元素的操作
public class RemoveDuplicatesFromArray {
    public static void main(String[] args){
        System.out.println(removeDuplicates(new int[]{0,1,2,2,3,3,4}));
    }

    /**
     * 思路：[0,1,2,2,3,3,4]
     *        i j
     * 数组完成排序后，我们可以放置两个指针i和j，其中i是慢指针而j是快指针。只要nums[i] = nums[j],
     * 我们就增加j以跳过重复项。
     *
     * 当遇到nums[j] != nums[i]时，跳过重复项的运行已经结束，必须把nums[j]的值复制到nums[j+1]。
     * 然后递增i，接着再次重复相同的过程，直到j到达数组的末尾为止。
     * */
    public static int removeDuplicates(int[] nums){
        if(nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j=1;j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }

        }
        return i + 1;
    }

}
