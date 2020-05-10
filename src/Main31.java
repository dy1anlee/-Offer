/**
 * @Author : Dylan
 * @Date : 2020/4/2 10:32
 * @Describe :求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 */
public class Main31 {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(315));
        System.out.println(NumberOf1Between1AndN_Solution2(315));
        System.out.println(NumberOf1Between1AndN_Solution3(315));
    }
    //暴力求解
    public static int NumberOf1Between1AndN_Solution(int n) {
        int sum = 0;
        int x = 0;
        for (int i = 1; i <= n; i++){
            x = i;
            while(x != 0){
                if (x % 10 == 1)
                    sum++;
                x = x / 10;
            }
        }
        return sum;
    }
    /*方法二：
     *数学总结
    当n = 3141592时:
    m	    a	        b	    ones
    1	    3141592	    0	    (3141592+8)/10*1+0=314160
    10	    314159	    2	    (314159+8)/10*10+0=314160
    100	    31415	    92	    (31415+8)/10*100+0=314200
    1000	3141	    592	    (3141+8)/10*1000+1(592+1)=314593
     **/
    public static int NumberOf1Between1AndN_Solution2(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i*=10){
            int a = n/i;
            int b = n%i;
            sum += a % 10 == 1 ? (a  + 8)/10 * i + (b + 1) :(a  + 8)/10 * i;
        }
        return sum;
    }

    //方法三：递归通过对1-n的分区间讨论(递归的过程)，在求1-n的时候，分为两个区间，
    // 第一个区间是1-b(b是n去掉首部数字之后的数字)， 第二个区间是（b+1, n）。
    // 对于每个区间的计算时，分为了两种情况，
    // 第一种情况是当前n的首部数字是1，第二种情况是除了首位的其他位是1。主要是这两中情乱的讨论。
    public static int NumberOf1Between1AndN_Solution3(int n) {
        if (n == 0)
            return 0;
        if (n > 0 && n < 10)
            return 1;
        String str = "" + n;
        int large = (int) Math.pow(10,str.length() - 1); //最高位的单位
        int firstNum = n / large;
        int firstBit = firstNum == 1 ? (n % large) + 1 : large;
        int otherBit = firstNum * (str.length() - 1) * large/10;
        return firstBit + otherBit + NumberOf1Between1AndN_Solution(n % large);
    }

}
