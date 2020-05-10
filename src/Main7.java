/**
 * @Author : Dylan
 * @Date : 2020/3/27 20:17
 * @Describe :
 */
public class Main7 {

    public static void main(String[] args) {
        System.out.println(Fibonacci3(30));
    }

    //简单递归
    public static int Fibonacci1(int n) {
        if (n <= 1)
            return n;
        return Fibonacci1(n -1) + Fibonacci1(n-2);
    }

    public static   int Fibonacci2(int n){
        int[] ans = new int[40];
        ans[0] = 0;
        ans[1] = 1;
        for(int i = 2; i < 40; i++)
            ans[i] = ans[i -1] + ans[i -2];
        return ans[n];
    }

    public static int Fibonacci3(int n){
        if (n <= 1) {
            return n;
        }
        int sum = 1;
        int num = 0;
        for (int i = 2; i <= n; i++) {
            sum = sum + num;
            num = sum - num;
        }
        return num;
    }
}
