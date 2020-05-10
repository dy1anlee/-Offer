import java.util.*;

/**
 * @Author : Dylan
 * @Date : 2020/4/2 18:05
 * @Describe :在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.
 */
public class Main34 {

    public static void main(String[] args) {
        String str = "qwerrsadkjsaikd";
        System.out.println(FirstNotRepeatingChar("wwert"));
        System.out.println(FirstNotRepeatingChar1("wwert"));
    }

    //方法一：HashMap
    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++){
            char temp = str.charAt(i);
            if (map.containsKey(temp)){
                map.put(temp,-1);
            }else {
                map.put(temp,1);
            }
        }
        for (int i = 0; i < str.length(); i++){
            if (map.get(str.charAt(i)) == 1)
                 return i;
        }
        return -1;
    }

    //模仿hash
    public static int FirstNotRepeatingChar1(String str){
        int[] words = new int[58];
        for(int i = 0;i<str.length();i++){
            words[((int)str.charAt(i))-65] += 1;
        }
        for(int i=0;i<str.length();i++){
            if(words[((int)str.charAt(i))-65]==1)
                return i;
        }
        return -1;
    }
}
