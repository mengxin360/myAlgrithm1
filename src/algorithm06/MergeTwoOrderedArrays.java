package algorithm06;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *  合并两个有序数组
 *
 *  两个有序整数数组nums1和nums2，将nums2合并到nums1中，使nums1成为一个有序数组。
 *
 *  初始化nums1和nums2的元素数量分别为m和n。假设nums1的空间大小等于m+n，这样它就有足够的空间保存来自nums2的元素。
 * */
public class MergeTwoOrderedArrays {

    public static void main(String args[]){
        int[] nums1 = new int[]{1,3,5,7,9,0,0,0,0};
        int[] nums2 = new int[]{2,4,6,8};
        System.out.println(Arrays.toString(merge3(nums1,5,nums2,4)));
    }

    //方法一：时间复杂度比较高 空间复杂度比较优秀
    public static int[] merge(int[] nums1,int m,int[] nums2,int n){
        //表示将nums2拷贝，从nums2零的位置开始拷贝，拷贝进nums1里，从nums1中m的位置开始覆盖，拷贝n个元素
        //拷贝后的nums1变成了 1,3,5,7,9，2,4,6,8
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
        return nums1;
    }
    //方法二：双指针，将两个指针所指的元素进行大小比较，元素比较小的进入新的数组，并将进入新数组元素的指针后移
    //该方法的时间复杂度为O(m+n) 空间复杂度为O(n)
    public static int[] merge2(int[] nums1,int m,int[] nums2,int n){
        //该方法有三个指针，其实也是双指针问题，双指针中的双只是一个量词，不光是只有两个指针问题才叫双指针问题
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);

        int p1 = 0;//指向nums1_copy
        int p2 = 0;//指向nums2
        int p = 0;//指向nums1

        while (p1 < m && p2 < n){
            nums1[p++] = nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++];//后加加：先赋值在加加
        }
        if(p1 < m){ //p2已经等于n，此时nums2全放进去nums1，要做的就是把nums1_copy中剩下的数据拷贝进nums1
            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if(p2 < n){ //p1已经等于m，此时nums1_copy全放进去nums1，要做的就是把nums2中剩下的数据拷贝进nums1
            System.arraycopy(nums2,p2,nums1,p2+p1,m+n-p1-p2);
        }
        return nums1;
    }
    //方法三：双指针，从后往前遍历  可以省去nums1_copy的空间开销
    public static int[] merge3(int[] nums1,int m,int[] nums2,int n){
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m+n - 1;//num1的最后一个下标

        while (p1 >= 0 && p2 >= 0){
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];//后加加：先赋值在加加
        }
        //nums2里面的数字还没有移完的情况
        //从高位开始覆盖，最后没移完的一定是最前面的索引为0的，nums1中也从0开始放。
        //正常情况从高位开始覆盖，如果nums2中有剩余元素，则从低位开始复制进nums1。
        //0...p2...m+n 从高位开始覆盖，覆盖到p2还省下p2+1个元素没有被覆盖，因为数组下标从零开始
        System.arraycopy(nums2,0,nums1,0,p2+1);
        return nums1;
    }
}
