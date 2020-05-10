import java.util.ArrayList;
import java.util.HashSet;

/**
 * @Author : Dylan
 * @Date : 2020/4/10 10:52
 * @Describe :请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class Main54 {
    HashSet<Character> set = new HashSet<>();
    ArrayList<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public void Insert(char ch) {
        if (set.contains(ch)){
            for (int i = 0;i<list.size(); i++){
                if (ch == list.get(i)){
                    list.remove(i);
                }
            }
        }else {
            set.add(ch);
            list.add(ch);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        if (!list.isEmpty()){
            return  list.get(0);
        }
        return '#';
    }
}
