import java.util.ArrayList;


/**
 * @Author : Dylan
 * @Date : 2020/4/5 22:03
 * @Describe :输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class Main42 {
    public static void main(String[] args) {
        int[] array = {1,2,4,7,11,16};
        System.out.println(FindNumbersWithSum(array,17));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        int low = 0;
        int high = array.length - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while (low < high){
            if (sum == array[low] + array[high]){
                ans.add(array[low]);
                ans.add(array[high]);
                break;
            }else if (sum > array[low] + array[high]){
                low++;
            }else {
                high--;
            }
        }
        return ans;
    }
}
