/**
 * @Author : Dylan
 * @Date : 2020/3/27 21:28
 * @Describe :一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Main9 {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(6));
    }
    public static int JumpFloorII(int target) {

        return target <= 2 ? target : 1 << target-1;
    }
}
