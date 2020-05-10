import java.util.Arrays;

/**
 * @Author : Dylan
 * @Date : 2020/4/7 0:33
 * @Describe :要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class Main45 {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length == 0) {
            return false;
        }
        int sum = 0;
        for (int x : numbers) {
            if (x == 0) {
                sum++;
            }
        }
        Arrays.sort(numbers);
        for (int i = sum + 1; i < numbers.length; i++) {
            sum -= numbers[i] - numbers[i - 1] - 1;
            if (sum < 0 || numbers[i] == numbers[i - 1]) {
                return false;
            }
        }
        return true;
    }

    //max 记录 最大值
    //min 记录  最小值
    //min ,max 都不记0
    //用数组d来判断是否有除了0以外的重复数，max记录最大值，min记录最小值，在判断是否差<5
    //满足条件 1 max - min <5
    //        2 除0外没有重复的数字(牌)
    //        3 数组长度 为5
    public boolean isContinuous2(int [] numbers) {
        int[]d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for(int i =0;i<len;i++){
            d[numbers[i]]++;
            if(numbers[i] == 0){
                continue;
            }
            if(d[numbers[i]]>1){
                return false;
            }
            if(numbers[i] >max){
                max = numbers[i];
            } if(numbers[i] <min){
                min = numbers[i];
            }

        }
        if(max -min<5){
            return true;
        }
        return false;
    }
    //必须满足两个条件
    //1. 除0外没有重复的数
    //2. max - min < 5
    public boolean isContinuous3(int [] numbers) {
        if(numbers.length != 5) return false;
        int min = 14;
        int max = -1;
        int flag = 0;
        for(int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            if(number < 0 || number > 13) return false;
            if(number == 0) continue;
            if(((flag >> number) & 1) == 1) return false;
            flag |= (1 << number);
            if(number > max) max = number;
            if(number < min) min = number;
            if(max - min >= 5) return false;
        }
        return true;
    }
}
