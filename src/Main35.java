/**
 * @Author : Dylan
 * @Date : 2020/4/3 15:51
 * @Describe :在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class Main35 {
    private long  sum;
    public int InversePairs(int [] array) {
        sum = 0;
        int start = 0;
        int end = array.length - 1;
        divide(start ,end, array);
        return (int) (sum % 1000000007);
    }

    private void divide(int start, int end, int[] array) {
        if (start != end){
            int mid = (start + end) >> 1;
            divide(start, mid, array);
            divide(mid+1, end, array);
            merge(start,end,mid,array);
        }
    }

    private void merge(int start, int end, int mid, int[] array) {
        int p1 = start;
        int p2 = mid + 1;
        int[] temp = new int[end - start + 1];
        int tempindex = 0;
        while(p1 <= mid && p2 <= end){
            if (array[p1] > array[p2]){
                temp[tempindex++] = array[p2++];
                sum += mid - p1 + 1; //
            }else{
                temp[tempindex++] = array[p1++];
            }
        }
        while(p1 <= mid){
            temp[tempindex++] = array[p1++];
        }
        while(p2 <= end){
            temp[tempindex++] = array[p2++];
        }
        tempindex = 0;
        for (int i = start; i<= end;i++)
            array[i] = temp[tempindex++];
    }
}
