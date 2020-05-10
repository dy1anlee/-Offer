import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author : Dylan
 * @Date : 2020/4/7 9:34
 * @Describe :,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Main46 {
    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(8,3));
    }
    //方法一：链表
    public static int LastRemaining_Solution(int n, int m) {
        if (n <= 0 || m <= 0)
            return -1;
        if (n == 1) return 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        /*
        1，
        int bt = 0;
        while (list.size() > 1) {
            bt = (bt + m - 1) % list.size();
            list.remove(bt);
        }

        */
        //2, 两种计数方式
        int cur = -1;
        while(list.size()>1){
            for(int i = 0;i<m;i++){
                cur++;
                if(cur == list.size()){
                    cur = 0;
                }
            }
            //
            list.remove(cur);
            cur--;//cur--的原因，因为新的list中cur指向了下一个元素，为了保证移动m个准确性，所以cur向前移动一位。
        }
        return list.get(0);
    }

    //通过公式的推导可以推导出：f(n, m) = (f(n-1, m) + m) % n
    public int LastRemaining_Solution2(int n, int m) {
        if (n <= 0 || m <= 0) {
            return -1;
        }

        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }


    public int LastRemaining_Solution3(int n, int m) {
        if(n <= 0){
            //throw new IllegalArgumentException();
            return -1;
        }
        //最后一次重新编号：最后一个结点编号为1，出列前结点数为2
        return orginalNumber(2, 0, n, m);
    }

    //根据出列后的重新编号（newNumber）推导出列前的旧编号（返回值）
    //n：出列前有多少小朋友，N：总共有多少个小朋友
    public int orginalNumber(int n, int newNumber, int N, int m){
        int lastNumber = (newNumber + m - 1) % n + 1;
        if(n == N){
            return lastNumber;
        }
        return orginalNumber(n + 1, lastNumber, N, m);
    }

}
