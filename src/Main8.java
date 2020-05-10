/**
 * @Author : Dylan
 * @Date : 2020/3/27 21:22
 * @Describe :一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）
 */
public class Main8 {

    public static void main(String[] args) {
        int n = JumpFloor(29);
        System.out.println(n);
    }

    public static int JumpFloor(int target) {
        //1,简单递归
        //if(target <= 2)
        //    return target;
        //return JumpFloor(target - 1) + JumpFloor(target - 2);
        //2,
        if(target <= 2)
            return target;
        int sum = 2;
        int num = 1;
        for(int i = 3; i <= target; i++){
            sum = sum +num;
            num = sum - num;
        }
        return sum;
    }
}
