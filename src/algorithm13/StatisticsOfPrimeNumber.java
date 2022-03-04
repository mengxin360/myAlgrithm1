package algorithm13;

/**
 *  素数个数统计
 *
 *  统计n以内的素数个数
 *  素数：只能被1和自身整除的自然数，0、1除外
 *
 *  例：输入：100
 *      输出：25
 *  重点考察：埃筛法
 * */
public class StatisticsOfPrimeNumber {

    public static void main(String args[]){
        System.out.println(bf(100));
        System.out.println(eratosthenes(100));
    }

    //方法一：暴力算法 统计个数
    public static int bf(int n){
        int count = 0;
        for(int i = 2; i < n; i++){
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }
    // 假设看n是否为素数 则可以从2——（n-1）中找到能被n整除的数
    public static boolean isPrime(int x){
        // i<x可以改成根号下x
        // 例如：12 = 2*6 = 3*4 = 4*3 = 6*2 前后重复 所以只需要判断前半部分即可
        // 分界点就在根号下12乘根号下12
       //  可以用Math中的开根号方法也可以用i*i<=x 效果一样
        for(int i = 2 ;i * i <= x ; i++){
            if(x % i == 0){
                return false;
            }
        }
        return true;
    }

    //方法二：埃筛法
    //素数 非素数（合数） 12 = 2 * 6  两个素数的乘积一定为合数 已经使合数的 不再重复遍历
    public static int eratosthenes(int n){
        boolean[] isPrime = new boolean[n];//false代表素数
        int count = 0;
        for(int i=2;i<n;i++){
            if(!isPrime[i]){
                count++;
//                for(int j=2*i;j<n;j+=i  ){//j就是合数的标记位 j=2*i+i=3*i
//                    isPrime[j] = true;
//                }
                for(int j=i*i;j<n;j+=i  ){
                    isPrime[j] = true;
                }
            }
        }
        return count;
    }
    /**
     *  将合数标记为true，j=i*i从2*i优化而来，系统2会随着遍历递增（j+=i，相当于递增了系数2），每一个合数
     *  都会有两个比自身要小的因子（0,1除外），2*i必然会遍历到这两个因子
     *
     *  当2递增到大于根号n时，其实后面的已经无需再判断（或者只判断后面一段），而2到根号n，实际上在i递增
     *  的过程中已经计算过了，i实际上就相当于根号n
     *
     *  例如：n=25会计算如下
     *  2*4=8
     *  3*4=12
     *  但实际上8和12已经标记过，在n=17时已经计算了3*4，2*4
     * */
}
