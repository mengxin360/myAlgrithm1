package algorithm17;

/**
 *  x的平方根
 *
 *  在不使用sqrt(x)函数的情况下，得到x的平方根的整数部分
 *
 *  重点考察：二分法、牛顿迭代
 * */
public class SquareRootOfX {

    public static void main(String args[]){
        System.out.println(binarySearch(6));
        System.out.println(newton(6));
    }

    //方法一：暴力破解 i*i<x (i+1)*(i+1)>x
    //说明i是x平方根的整数部分
    //时间复杂度O(n)

    //方法二：二分法 值一定介于1到（x-1）之间 时间复杂度O(logn)
    public static int binarySearch(int x){
        int index = -1,left = 1,right = x;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(mid * mid <= x){
                index = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return index;
    }

    //该方法只能找到开方后是整数的数的平方根
//    public static int binarySearch2(int x){
//        int index = -1,left = 1,right = x;
//        while (left <= right){
//            int mid = left + (right - left)/2;
//            int result = mid * mid;
//            if(result < x){
//                left = mid + 1;
//            }else if(result > x){
//                right = mid - 1;
//            }else {
//                return mid;
//            }
//        }
//        return index;
//    }

    //方法三：牛顿迭代 （x/n+n）/ 2   直到  x/n = n
    public static int newton(int x){
        if(x == 0){
            return 0;
        }
        return (int) sqrt(x,x);
    }
    public static double sqrt(double i,int x){
        double res = (i + x/i)/2;
        if(res == i){
            return i;
        }else {
            return sqrt(res,x);
        }
    }
}
