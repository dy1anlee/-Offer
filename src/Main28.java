import java.util.HashMap;

/**
 * @Author : Dylan
 * @Date : 2020/4/1 14:10
 * @Describe :数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Main28 {

    //方法一：使用HashMap
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array == null)
            return 0;
        int n = array.length;
        if(n == 1)
            return array[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int x : array){
            if (!map.containsKey(x)){
                map.put(x, 1);
            }else {
                int count = map.get(x) + 1;
                map.put(x, count);
                if (count > n / 2)
                    return x;
            }
        }
        return 0;
    }
    //方法二：
    public int MoreThanHalfNum_Solution1(int [] array) {
        int n = array.length;
        if (array == null || n == 0)
            return 0;
        if (n == 1)
            return array[0];
        int target = array[0];
        int sum = 0;
        for (int x : array) {
            if (x == target) {
                sum++;
            } else {
                sum--;
            }
            if (sum == 0) {
                target = x;
                sum = 1;
            }
        }

        int num = 0;
        for (int y : array) {
            if (y == target)
                num++;
        }
        return num > n / 2 ? target : 0;
    }
}
