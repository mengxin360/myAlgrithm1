package algorithm11;

/**
 *  柠檬水找零
 *  在柠檬水摊上，每一杯柠檬水的售价为5美元。顾客排队购买你的产品，一次购买一杯。
 *  每位顾客只买一杯柠檬水，然后向你付5美元、10美元或20美元。必须给每个顾客正确找零
 *  注意，一开始你手头没有任何零钱。
 *  如果你能给每位顾客正确找零，返回true，否则返回false。
 *
 *  例如：[5,20,10,5] false
 *        [5,10,5,10] true
 *
 *  思路：贪心算法（找局部最优，最终达到总体最优）
 *  客人只会拿出5、10、20三个情况，拿出5块，只会产生一种结果，那就是把5收下，
 *  拿出10也只会产生一种结果，那就是找客人5元，拿出20则会产生两种结果
 *  那么找10和5，要么找三个5.
 *  也就是说，在该背景下5相对于10来说更加的有用，所以遇到20优先用10和5组合，也就是优先
 *  把通用性不如5的10给用掉
 *  但是20对找零没帮助 所以只需要记录有多少张5元、有多少张10元即可
 * */
public class LemonadeChange {

    public static void main(String[] args){
        System.out.println(change(new int[]{5,5,20}));
        System.out.println(change(new int[]{5,5,10}));
    }

    public static boolean change(int[] bills){
        int five = 0,ten=0;
        for (int bill:bills){
            if(bill==5){
                five++;
            }else if (bill==10){
                if(five==0){
                    return false;
                }
                five --;
                ten ++;
            }else {//20
                if(five>0 && ten>0){
                    five--;
                    ten--;
                }else if (five>=3){
                    five -= 3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

}
