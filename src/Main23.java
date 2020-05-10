/**
 * @Author : Dylan
 * @Date : 2020/3/31 11:56
 * @Describe :输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Main23 {

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        System.out.println(VerifySquenceOfBST(array));
    }
    public static boolean solve(int [] sequence, int start, int end){
        if(start >= end)return true;
        int key = sequence[end];
        int i;
        //找到左右子数的分界点
        for(i=start; i < end; i++)
            if(sequence[i] > key)
                break;
        for(int j = i; j < end; j++)
            if(sequence[j] < key)
                return false;
        return solve(sequence, start, i-1) && solve(sequence, i, end-1);
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0)
            return false;
        return  solve(sequence, 0, sequence.length-1);

    }
}
