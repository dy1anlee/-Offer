import java.util.Stack;

/**
 * @Author : Dylan
 * @Date : 2020/3/31 10:20
 * @Describe :输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class Main21 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {

        if (popA.length != pushA.length || popA.length == 0)
            return false;
        Stack<Integer> stack = new Stack<>();
        int push = 0;
        int pop = 0;
        while(push < pushA.length){
            if (!stack.isEmpty() && stack.peek() == popA[pop]){
                stack.pop();
                pop++;
            }else {
                stack.push(pushA[push]);
                push++;
            }
        }

        while (!stack.isEmpty()){
            if (popA[pop] == stack.pop()){
                pop++;
            }else{
                return false;
            }
        }
        return true;
    }
}
