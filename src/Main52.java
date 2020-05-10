/**
 * @Author : Dylan
 * @Date : 2020/4/8 16:18
 * @Describe :请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Main52 {

    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null) return false;
        if(str.length == 0 && pattern.length == 0) return true;

        return solve(str, 0, pattern, 0);
    }

    private boolean solve(char[] str, int index1, char[] pattern, int index2) {

        if (index2 >= pattern.length)
            return index1 >= str.length;
        if (index1 >= str.length){
            if (index2 + 1 < pattern.length && pattern[index2+1] == '*'){
                return solve(str, index1,pattern,index2+2);
            }else {
                return false;
            }
        }
        if (index2 + 1 < pattern.length && pattern[index2 +1] == '*'){
            if (str[index1] == pattern[index2] || pattern[index2] == '.'){
                return solve(str,index1+1,pattern,index2) || solve(str,index1+1,pattern,index2);
            }else{
                return solve(str,index1,pattern,index2+2);
            }
        } else{
            if(str[index1] == pattern[index2] || pattern[index2] == '.'){
                return solve(str,index1 + 1,pattern,index2 + 1);
            }else
                return false;
        }
    }

}
