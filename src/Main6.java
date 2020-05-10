import java.util.Arrays;

/**
 * @Author : Dylan
 * @Date : 2020/3/27 15:38
 * @Describe :
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class Main6 {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7, 1, 2};
        System.out.println(minNumberInRotateArray1(array));
        System.out.println(minNumberInRotateArray2(array));
    }

    public static int minNumberInRotateArray1(int [] array) {
        int n = array.length;
        if(n == 0){
            return 0;
        }
        int low = 0,high = n-1;

        while(high > low){
            int mid = (high + low)>>1;
            if(array[high] > array[low]){
                return array[low];
            }

            if(array[low] <= array[mid]){
                low = mid + 1;
            }else if(array[mid] <= array[high]){
                high = mid;
            }else{
                low++;
            }

        }
        return array[low];
    }

    public static int minNumberInRotateArray2(int [] array) {
        int n = array.length;
        if (n == 0){
            return 0;
        }
        for (int i = 0; i < n-1; i++){
            if (array[i] > array[i+1]){
                return array[i+1];
            }
        }
        return array[0];
    }

    public static int minNumberRotateArray3(int[] array){
        int n = array.length;
        if (n == 0) {
            return 0;
        }

        Arrays.sort(array);
        return  array[0];
    }
}
