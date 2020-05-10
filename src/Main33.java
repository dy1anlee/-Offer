/**
 * @Author : Dylan
 * @Date : 2020/4/2 17:24
 * @Describe :把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class Main33 {
    public int GetUglyNumber_Solution(int index) {
        if(index < 1)
            return 0;
        int[] array = new int[index];
        array[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 1; i < index; i++){

            array[i] = Math.min(Math.min(array[index1]*2,array[index2]*3),array[index3]*5);

            if (array[i] == array[index1]*2){
                index1++;
            }
            if (array[i] == array[index2]*3){
                index2++;
            }
            if (array[i] == array[index3]*5){
                index3++;
            }
        }
        return array[index-1];
    }
}
