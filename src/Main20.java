/**
 * @Author : Dylan
 * @Date : 2020/3/31 9:11
 * @Describe :定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
import java.util.Stack;
public class Main20 {

    private static Stack<Integer> data = new Stack<>();
    private static Stack<Integer> min = new Stack<>();

    public void push(int node){
        data.push(node);
        if (min.isEmpty() || node < min.peek()){
            min.push(node);
        }
    }

    public void pop(){

        if (!data.isEmpty()){
            if (data.peek() == min.peek()){
                data.pop();
                min.pop();
            }else{
                data.pop();
            }
        }

    }

    public int top(){
            return data.peek();
    }

    public static int min(){
        return min.peek();
    }
}
