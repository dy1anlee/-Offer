import java.util.ArrayList;

/**
 * @Author : Dylan
 * @Date : 2020/4/1 15:37
 * @Describe :输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Main29 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k > input.length || k <= 0 )
            return new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = input.length;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if (input[i] > input[j]){
                    int temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }

        for (int a=0; a < k;a++){
            ans.add(input[a]);
        }
        return  ans;

    }
}
