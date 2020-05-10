import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Author : Dylan
 * @Date : 2020/4/2 15:27
 * @Describe :输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *              例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class Main32 {

    //方法一：字符串全排列：同 27 题
    public String PrintMinNumber(int [] numbers) {

        TreeSet<String> set = new TreeSet<>();
        solve(set,numbers,0);
        return set.pollFirst();
    }

    private void solve(TreeSet<String> set, int[] numbers, int start) {
        int len = numbers.length;
        if (start == len -1){
            String ans = " ";
            for (int i = 0; i < len; i++) {
                ans += numbers[i];
            }
            set.add(ans);
        }else {
            for (int i = start; i < len ;i++){
                swap(numbers,i,start);
                solve(set,numbers,start+1);
                swap(numbers,i,start);
            }
        }

    }

    private void swap(int[] numbers, int i, int start) {
        int temp = numbers[i];
        numbers[i] = numbers[start];
        numbers[start] = temp;
    }

    //方法二：对数组内的数字进行优先级排序
    public String PrintMinNumber2(int [] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int x : numbers) {
            list.add(x + "");
        }
        list.sort((s, t1) -> {
            String str1 = s + t1;
            String str2 = t1 + s;
            return str1.compareTo(str2);
        });
        StringBuilder ans = new StringBuilder();
        for (String x : list) {
            ans.append(x);
        }
        return ans.toString();
    }
}
