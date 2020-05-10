import java.util.HashMap;

/**
 * @Author : Dylan
 * @Date : 2020/4/5 14:36
 * @Describe :一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Main40 {
    public static void main(String[] args) {
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        FindNumsAppearOnce(array,num1,num2);
        FindNumsAppearOnce2(array,num1,num2);


    }
    //
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < array.length; i++){
            if(map.containsKey(array[i]))
                map.put(array[i],2);
            else
                map.put(array[i],1);
        }
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == 1){
                if (flag){
                    num1[0] = array[i];
                    flag = false;
                }else {
                    num2[0] = array[i];
                }
            }
        }

    }
    //
    public static void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {
        if (array.length == 0 || array == null)
            return;
        int xor = 0;
        for (int x : array){
            xor ^= x;
        }
        int index = 1;
        while ((index & xor) ==0){
            index = index << 1;
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int y :array){
            if ((y & index) == 0){
                num1[0] = num1[0] ^ y;
            }else {
                num2[0] = num2[0] ^ y;
            }
        }
        System.out.println(num1[0]);
        System.out.println(num2[0]);
    }
}
