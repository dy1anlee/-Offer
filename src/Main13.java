import java.util.Stack;

/**
 * @Author : Dylan
 * @Date : 2020/3/28 21:23
 * @Describe :输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Main13 {
    public void reOrderArray(int [] array) {
        if (array == null)
            return;
        int n = array.length;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = n - 1; i >= 0; i--){
            if (array[i] % 2 == 0)
                stack2.add(array[i]);
            else
                stack1.add(array[i]);
        }
        for (int i = 0; i < n; i++){
            if (!stack1.isEmpty())
                array[i] = stack1.pop();
            else
                array[i] = stack2.pop();
        }
    }
}
