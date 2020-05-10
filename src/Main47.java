/**
 * @Author : Dylan
 * @Date : 2020/4/7 10:33
 * @Describe :求1+2+3+...+n，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class Main47 {
    //递归
    public int Sum_Solution(int n) {
        if(n == 1)
            return 1;
        return n + Sum_Solution(n - 1);
    }
}
