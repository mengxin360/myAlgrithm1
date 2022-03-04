package algorithm04;

/**
 *  排列硬币
 *
 *  总共有n枚硬币，将它们摆成一个阶梯形状，第k行就必须正好有k枚硬币。
 *
 *  给定一个数字n，找出可形成完整阶梯行的总行数。
 *
 *  n是一个非负整数，并且在32位有符号整型的范围内。
 *
 *  如果输入的数字为5 则返回2 ；如果输入的数字为6 则返回3
 * */
public class ArrangeCoins {

    public static void main(String args[]){
        System.out.println(arrangeCoins(10));
        System.out.println(arrangeCoins2(10));
        System.out.println(arrangeCoins3(10));
    }

    /**
     *  思路：
     *  放第一行硬币    剩余硬币数：n
     *  放第二行硬币    剩余硬币数：n-1
     *  放第三行硬币    剩余硬币数：n-1-2
     *
     * */
    //方法一：暴力破解（迭代）
    public static int arrangeCoins(int n){
        for(int i=1;i<=n;i++){
            n = n - i;
            if(n <= i){
                return i;
            }
        }
        return 0;
    }
    //方法二：二分查找 从一行硬币数一直加到第x行硬币数，使得这些的和等于n。n为硬币总数
    // 累出的阶梯行数一定小于n，所以转化成二分查找的思想，就相当于从第一行到第n行之间找出一个第x行，使得。。。
    // 1+2+3+4+...+x = ((1+x)*x)/2 = (x^2+x)/2
    public static int arrangeCoins2(int n){
        int low = 0 , high = n;
        while (low <= high){
            int mid = (high - low) / 2 + low;
            int cost = ((mid + 1) * mid)/2;
            if (cost == n){
                return mid;
            }else if (cost>n){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return 0;
    }

    //方法三：牛顿迭代:(x+n/x)/2
    //(x^2+x)/2=n
    //x^2+x=2*n
    // x^2 = 2*n-x;
    //这是一个求平方根问题，所以可以用牛顿迭代方法来做
    public static int arrangeCoins3(int n){
        if(n == 0){
            return 0;
        }
        return (int) sqrt(n,n);
    }

    private static double sqrt(double x, int n) {
        double res = (x + (2*n-x)/x)/2;
        if (res == x){
            return x;
        }else {
            return sqrt(res,n);
        }

    }

}
