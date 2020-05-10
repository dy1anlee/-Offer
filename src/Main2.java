/**
 * @Author : Dylan
 * @Date : 2020/3/27 9:37
 * @Describe :
 */
public class Main2 {
    public static void main(String[] args) {

        String str = "Hello world nihao";
        System.out.println(replace(str));
        System.out.println(replaceSpace(str));
    }

    public static String replace(String str){

        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
            char c = str.charAt(i);
            /*if (c ==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }*/
            sb.append(c == ' ' ? "%20" : c );
        }
        return sb.toString();
    }

    public static String replaceSpace(String str) {
        return str.toString().replace(" ", "%20");
    }


}
