package algorithm03;

/* 斐波那契数列
*
*  求取斐波那契数列第N位的值。
*
*  斐波那契数列：每一位的值等于他前两位数字之和。前两位固定 0,1,1,2,3,5,8。。。。
* */
public class FibonacciSequence {
    public static void main(String args[]){
        System.out.println(calculate(10));
        System.out.println(calculate2(10));
        System.out.println(iterate(10));
    }

    // 方法一：暴力解法 一般递归 时间复杂度O(2^n)
    public static int calculate(int num){
        if(num == 0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        return calculate(num-1) + calculate(num-2);
    }
    // 方法二：去掉方法一中重复的计算 去重递归 时间复杂度O(n)
    public static int calculate2(int num){
        int[] arr = new int[num + 1];

        if(num == 0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        return recurse(arr,num-1) + recurse(arr,num-2);
    }
    private static int recurse(int[] arr,int num){
        if(num == 0){
            return 0;
        }
        if (num==1){
            return 1;
        }

        //起去重作用的代码
        if(arr[num] != 0){
            return arr[num];
        }

        arr[num] = recurse(arr,num-1) + recurse(arr,num-2);
        return arr[num];
    }
    //方法三：双指针迭代 时间复杂度O(n)(因为只是把数组遍历一遍) 空间复杂度O(1)
    public static int iterate(int num){
        if(num == 0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        int low = 0,high = 1;
        for(int i=2;i<=num;i++){
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }
}
