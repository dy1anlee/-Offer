/**
 * @Author : Dylan
 * @Date : 2020/4/15 22:07
 * @Describe :给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18
 */
public class Main67 {
    public int cutRope(int n) {
        int[] dp = new int[n + 1];
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2; // 1 + 2
        }
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3; // 1 + 2
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= k / 2; i++) {
                dp[k] = Math.max(dp[k], dp[i] * dp[k - i]);
            }
        }
        return dp[n];
    }
}
