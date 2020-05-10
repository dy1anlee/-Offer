/**
 * @Author : Dylan
 * @Date : 2020/3/28 8:14
 * @Describe :输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Main11 {

    public static void main(String[] args) {
        int n = -5;
        System.out.println(NumberOf1(n));
        System.out.println(NumberOf2(n));
    }
    public static int NumberOf2(int n){

        int sum = 0;
        int temp = 1;
        while(temp != 0){
            sum = (n & temp) != 0 ? sum + 1 : sum;
            temp = temp << 1;
        }
        return sum;
    }

    public static int NumberOf1(int n) {

        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n;
        }
        return count;
    }
}
