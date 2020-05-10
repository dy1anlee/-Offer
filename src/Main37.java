import java.util.GregorianCalendar;

/**
 * @Author : Dylan
 * @Date : 2020/4/3 20:35
 * @Describe :统计一个数字在排序数组中出现的次数。
 */
public class Main37 {

    public static void main(String[] args) {
        int[] array  = {1, 2, 3, 3, 3, 3, 4, 5};
        //System.out.println(GetNumberOfK(array,3));
        System.out.println(GetNumberOfK2(array,3));
    }
    public static int GetNumberOfK(int [] array , int k) {
        int n = array.length;
        if (n == 0)
            return 0;
        int start = -1;
        int end = -1;

        for (int i = 0; i < n; i++){

            if (start == -1 && array[i] == k)
                start = i;
            if (end == -1 && array[i] > k){
                end = i;
                break;
            }
        }

        if (start == -1)
            return 0;
        else
            return end == -1 ? n - start : end -start;
    }


    //方法二：
    public static int GetNumberOfK2(int [] array , int k) {
        if (array.length == 0) {
            return 0;
        }
        int firstPosition = findFirstPosition(array, k);
        int lastPosition = findLastPosition(array, k,0,array.length-1);
        System.out.println(firstPosition);
        System.out.println(lastPosition);
        if (firstPosition != -1 && lastPosition != -1) {
            return lastPosition - firstPosition + 1;
        }
        return 0;
    }
    private static int findFirstPosition(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = (start + end) >> 1;
            if (array[mid] == k) {
                if(mid - 1 >= 0 && array[mid - 1] == k) {
                    // 说明mid当前的位置不是初始位置,k的初始位置是在l~mid-1区间
                    end = mid - 1;
                } else {
                    // 就可以说明mid位置的数字就是k的初始位置
                    return mid;
                }
            } else if (array[mid] > k) {
                end = mid - 1; // k是属于l~mid-1区间
            } else {
                start = mid + 1; // k是属于mid+1~r区间
            }
        }
        return -1;
    }

    private static int findLastPosition(int[] array, int k, int start ,int end) {
        if(start > end){
            return -1;
        }
        int mid = (start + end) >> 1;
        if (array[mid] > k) {
            return findLastPosition(array,k,start,mid - 1) ;// k是属于l~mid-1区间
        }else if (array[mid] < k) {
            return findLastPosition(array,k,mid+1,end); // k是属于mid+1~r区间
        }else if (mid + 1 < array.length && array[mid + 1] == k) {
            // 说明mid当前的位置不是终止位置,k的初始位置是在mid+1~r区间
            return findLastPosition(array,k,mid+1,end);
        } else {
            // 就可以说明mid位置的数字就是k的终止位置
            return mid;
        }

    }
}
