/**
 * @Author : Dylan
 * @Date : 2020/3/28 20:16
 * @Describe :给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *保证base和exponent不同时为0
 */
public class Main12 {

    public static void main(String[] args) {
        int exponent = 3;
        double base = 5.0d;
        System.out.println(Power(base,exponent));
        System.out.println(Power4(base,exponent));
    }
    //
    public static double Power(double base, int exponent) {
        if(base == 0.0)
        return 0;
        if(exponent == 0)
            return 1;
        //int ex = Math.abs(exponent);
        int ex = exponent > 0? exponent : -exponent;
        double num = 1;
        for(int i = 1; i <= ex; i++){
            num = num * base;
        }
        /*if(exponent > 0)
            return num;
        else
            return 1/num;*/
        return exponent > 0 ? num : 1/num;
    }

    public static  double power2(double base, int exponent){
        return Math.pow(base, exponent);
    }

    public static double Power3(double base, int exp) {

        boolean flag = false;
        if (exp < 0) {
            flag = true;
            exp = -exp;
        }
        double ans = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = ans * base;
            }
            exp >>= 1;
            base *= base;
        }
        return flag ? 1 / ans : ans;
    }


    public static double Power4(double base, int exp) {
        boolean flag = exp < 0;
        if (flag) {
            exp = -exp;
        }
        double result = getPower(base, exp);
        return flag ? 1 / result : result;
    }

    public static double getPower(double base, int exp) {
        if (exp == 0) {
            return 1;
        }
        if (exp == 1) {
            return base;
        }
        double ans = getPower(base, exp >> 1);
        ans *= ans;
        if ((exp & 1) == 1) {
            ans *= base;
        }
        return ans;
    }
}
