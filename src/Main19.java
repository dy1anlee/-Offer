import java.util.ArrayList;

/**
 * @Author : Dylan
 * @Date : 2020/3/30 22:21
 * @Describe :输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Main19 {


    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (matrix == null)
            return arrayList;
        int low = 0;
        int high = matrix.length -1;
        int left = 0;
        int right = matrix[0].length-1;
        while (true){

            //向右
            for (int i = left; i <= right; i++)
                arrayList.add(matrix[low][i]);
            low++;
            //判断
            if (low > high)
                break;

            //向下
            for (int i = low; i <= high; i++)
                arrayList.add(matrix[i][right]);
            right--;
            //判断
            if (right < left)
                break;

            //向左
            for (int i = right; i>= left; i--)
                arrayList.add(matrix[high][i]);
            high--;
            //判断
            if (high < low)
                break;

            //向上
            for (int i = high; i >= low; i--)
                arrayList.add(matrix[i][left]);
            left++;

            if (left > right)
                break;
        }
        return arrayList;

    }
}
