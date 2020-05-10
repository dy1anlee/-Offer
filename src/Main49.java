/**
 * @Author : Dylan
 * @Date : 2020/4/7 20:05
 * @Describe :
 */
public class Main49 {
    public static void main(String[] args) {
        String str = "123";
        System.out.println(StrToInt(str));
    }

    public static int StrToInt(String str) {
        if(str.length() == 0 || str == null) return 0;
        int index;
        int flag = 1;
        for (index = 0 ;index < str.length();index++){
            if (str.charAt(index) == '-'||str.charAt(index) == '+'||
                    (str.charAt(index)>= '0')&&str.charAt(index) <= '9'){
                break;
            }
        }
        long num = 0;
        long judge = 0;
        if(str.charAt(index) == '-')flag = -1;
        for (int i =(str.charAt(index) == '-' || str.charAt(index) == '+') ? index+1:index;i < str.length();++i){
            if (str.charAt(i) < '0' || str.charAt(i) > '9'){
                return 0;
            }
            num = (num << 1) + (num << 3) + str.charAt(i) - '0';
            judge = num* flag;
            if ( judge > Integer.MAX_VALUE || 0 - judge < Integer.MIN_VALUE)
                return 0;
        }

        return (int) (num * flag);
    }
}
