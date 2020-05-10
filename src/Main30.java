/**
 * @Author : Dylan
 * @Date : 2020/4/1 20:51
 * @Describe :HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当
 * 向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class Main30 {
    //方法一：通过枚举起点和终点去统计起点到终点的序列的和。时间复杂度O(n^2)
    public int FindGreatestSumOfSubArray(int[] array) {
        int n = array.length;
        if(n == 1)
            return array[0];
        int[] sum = new int[n];
        sum[0] = array[0];
        for (int i = 1; i < n; i++){
            sum[i] = sum[i-1] + array[i];
        }

        int Max = sum[0];
        for (int i = 0; i < n; i++){
            for (int j = 0; j <= i; j++){
                if (j == 0){
                    Max = Math.max(Max, sum[i]);
                }else {
                    Max = Math.max(Max, sum[i] - sum[j - 1]);
                }
            }
        }
        return Max;
    }

    //通过定义一个sum变量去统计若干段连续子序列的和，然后再去比较出每段子序列和的最大值即可。时间复杂度为O(n)
    public int FindGreatestSumOfSubArray1(int[] array) {
        int max = array[0];
        int sum = 0;
        for (int i = 0; i < array.length; i++){
            sum += array[i];
            max = Math.max(sum,max);
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
