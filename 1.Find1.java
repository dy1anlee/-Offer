import java.util.Scanner;

public class Find1 {

    public static void main(String[] args) {

        int m,n;
        Scanner cin = new Scanner(System.in);
        m = cin.nextInt();
        n = cin.nextInt();
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++)
                array[i][j] = cin.nextInt();
        }
        for (int i = 1; i < m*n+1; i++){
            int target = cin.nextInt();
            System.out.println(find3(target,array));
        }

    }


    public static boolean find2(int target,int[][] array){
        int row = array.length;
        int col = array[0].length;


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (array[i][j] == target)
                    return true;
            }
        }
        return false;
    }

    /**
     * @author: dylan on 2020/3/19 16:44
     * @description:从右上角查找
     *
     */
    public static boolean find3(int target,int[][] array){
        int row = array.length;
        int col = array[0].length;

        int i = 0;
        int j = col - 1;
        while(i >=0 && i < row && j >= 0 && j<col){
            if (array[i][j] > target){
                j--;
            }else if (array[i][j] < target) {
                i++;
            }else
                return true;
        }
        return false;
    }
    /**
     * @author: dylan on 2020/3/19 16:42
     * @description:从左下角查找
     *
     */
    public static boolean find(int target,int[][] array) {

        int rows = array.length;
        if(rows==0){
            return false;
        }

        int cols = array[0].length;
        if (cols==0){
            return false;
        }

        //从左下角开始
        int i = rows-1;
        int j = 0;
        while (i>=0 && j < cols && j >= 0 && i < rows){
            if(array[i][j]>target){
                i--;
            }else if(array[i][j]<target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
