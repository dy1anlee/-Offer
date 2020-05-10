/**
 * @Author : Dylan
 * @Date : 2020/4/6 18:18
 * @Describe :汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Main43 {

    //方法一：使用String方法
    public String LeftRotateString(String str,int n) {
        if (str == null || str.length() == 0 || n <= 0 || n == str.length())return str;
        if (n > str.length()) n = n % str.length();
        return str.substring(n) + str.substring(0,n);
    }

    //将开头的一段子串移到串尾：将开头的子串翻转一下、将剩余的子串翻转一下，最后将整个子串翻转一下。
    public String LeftRotateString2(String str,int n) {
        if(str == null || str.length() == 0 || n <= 0){
            return str;
        }
        char[] arr = str.toCharArray();
        reverse(arr, 0, n - 1);
        reverse(arr, n, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        return new String(arr);
    }

    public void reverse(char[] str, int start, int end) {
        if (str == null || str.length == 0 || start < 0 || end > str.length - 1 || start >= end) {
            return;
        }
        for (int i = start, j = end; j > i; i++, j--) {
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }
}
