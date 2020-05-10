/**
 * @Author : Dylan
 * @Date : 2020/3/27 22:06
 * @Describe :我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class Main10 {

    public static void main(String[] args) {
        System.out.println(RectCover(10));
    }
    public static int RectCover(int target) {

        if(target <= 2)
            return target;

        int sum = 2;
        int num = 1;
        for(int i =3; i <= target; i++){
            sum = sum + num;
            num = sum - num;
        }
        return sum;
    }

    public static int RectCover1(int target){
        if (target <= 2)
            return target;
        return RectCover1(target - 1) + RectCover1(target -2);
    }
}
