import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author : Dylan
 * @Date : 2020/4/1 11:06
 * @Describe :输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba
 */
public class Main27 {

    public static void main(String[] args) {
        String str = "abca";
        ArrayList<String> array = Permutation(str);
        System.out.println(array);
        System.out.println(array.size());
    }
    public static ArrayList<String> Permutation(String str) {

        char[] array = str.toCharArray();
        ArrayList<String> arrayList = new ArrayList<>();
        solve(arrayList,array,0,array.length);
        //方法一：
        Collections.sort(arrayList);
        //方法二：TreeSet去重，排序
        //TreeSet<String> set = new TreeSet<String>();
        //set.addAll(arrayList);
        //arrayList.clear();
        //arrayList.addAll(set);

        return arrayList;

    }

    private static void swap(char[] a,int i, int j){
        char temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    private static void solve(ArrayList<String> arrayList, char[] array, int index, int length) {

        if (index == length - 1){
            String val = String.valueOf(array);
            if (!arrayList.contains(val)){
                arrayList.add(val);
            }
        }else {
            for (int i = index; i < length; i++){
//                char temp = array[i];
//                array[i] = array[index];
//                array[index] = temp;

                swap(array,i,index);
                solve(arrayList,array,index+1,length);
                //回溯
                swap(array,i,index);
//                temp = array[i];
//                array[i] = array[index];
//                array[index] = temp;
            }
        }
    }
}
