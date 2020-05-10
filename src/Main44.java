/**
 * @Author : Dylan
 * @Date : 2020/4/6 19:55
 * @Describe :牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class Main44 {
    public static void main(String[] args) {
        String str = "student.  a  am I";
        System.out.println(ReverseSentence(str));
    }
    public static String ReverseSentence(String str) {
        if(str == null || str.length() <= 1){
            return str;
        }
        char[] arr = str.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int start = -1;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != ' '){
                //初始化start
                start = (start == -1) ? i : start;
            }else{
                //如果是空格，不用担心start>i-1，reverse会忽略它
                reverse(arr, start, i - 1);
                start = i + 1;
            }
        }
        //最后一个单词，这里比较容易忽略！！！
        reverse(arr, start, arr.length - 1);

        return new String(arr);
    }

    private static void reverse(char[] str, int start, int end) {
        if(str == null || str.length == 0 || start < 0 || end > str.length - 1 || start >= end){
            return ;
        }
        for(int i = start, j = end ; j > i ; i++, j--){
            char tmp = str[i];
            str[i] = str[j];
            str[j] = tmp;
        }
    }

    public String ReverseSentence2(String str) {
        String flipStr = new StringBuilder(str).reverse().toString(); // 第一次翻转
        StringBuilder res = new StringBuilder(); // 用来遍历每一个单词
        StringBuilder ans = new StringBuilder(); // 用来保存结果
        for (int i = 0; i < flipStr.length(); i++) {
            if (flipStr.charAt(i) == ' ') {
                ans.append(res.reverse().toString()).append(" "); // 第二次翻转
                res = new StringBuilder();
            } else {
                res.append(flipStr.charAt(i));
            }
        }
        ans.append(res.reverse().toString()); // 最后那个单词的翻转结果保存到ans当中
        return ans.toString();
    }
    /* //leetcode
     *   public String ReverseSentence2(String str) {
        String flipStr = new StringBuilder(str.trim()).reverse().toString(); // 第一次翻转
        StringBuilder res = new StringBuilder(); // 用来遍历每一个单词
        StringBuilder ans = new StringBuilder(); // 用来保存结果
        for (int i = 0; i < flipStr.length(); i++) {
            if (flipStr.charAt(i) == ' ') {
                if(res.length > 0){
                    ans.append(ans.length == 0 ? res.reverse() : " " + res.reverse; // 第二次翻转
                    res = new StringBuilder();
                }
            } else {
                res.append(flipStr.charAt(i));
            }
        }
        if(res.length > 0){
                    ans.append(ans.length == 0 ? res.reverse() : " " + res.reverse; // 第二次翻转
         }
        return ans.toString();
    }
     **/

}
