import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @Author : Dylan
 * @Date : 2020/4/15 16:25
 * @Describe :给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Main64 {
    //遍历
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num.length == 0 || num == null || size > num.length || size <= 0)
            return ans;

        for (int start = 0; start < num.length - size +1; start++) {
            int max = num[start];
            for (int i = start; i < start + size; i++) {
                if (num[i] > max){
                    max = num[i];
                }
            }
            ans.add(max);
        }
        return ans;
    }

    //通过记录之前保存的窗口中的最大值和最大值的下标来去更新当前窗口的最大值分为两种情况，
    //第一种情况：之前最大值还在当前数组中，那么就去比较当前区间的右端点和之前记录的最大值即可
    //第二种情况：之前保存的最大值不在当前区间，那么就从当前区间的左端点遍历到右端点在重新的找到一个最大值就行了
    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num.length == 0 || size == 0 || size > num.length) {
            return ans;
        }

        int Max = Integer.MIN_VALUE;
        int pos = -1;
        for (int i = 0; i < size; i++) {
            if (num[i] > Max) {
                Max = num[i];
                pos = i;
            }
        }
        ans.add(Max);
        for (int i = size; i <= num.length - 1; i++) { // i - > 窗口的右区间
            if (i - size + 1 <= pos) {
                if (num[i] > Max) {
                    Max = num[i];
                    pos = i;
                }
            } else {
                Max = Integer.MIN_VALUE;
                for (int j = i - size + 1; j <= i; j++) {
                    if (num[j] > Max) {
                        Max = num[j];
                        pos = j;
                    }
                }
            }
            ans.add(Max);
        }
        return ans;
    }
    //用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
    //1.判断当前最大值是否过期
    //2.新增加的值从队尾开始比较，把所有比他小的值丢掉
    public ArrayList<Integer> maxInWindows3(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) return res;
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(q.isEmpty())
                q.add(i);
            else if(begin > q.peekFirst())
                q.pollFirst();

            while((!q.isEmpty()) && num[q.peekLast()] <= num[i])
                q.pollLast();
            q.add(i);
            if(begin >= 0)
                res.add(num[q.peekFirst()]);
        }
        return res;
    }

    public ArrayList<Integer> maxInWindows4(int [] num, int size){
        ArrayList<Integer> res = new ArrayList();
        if(num == null || num.length == 0 || size <= 0 || size > num.length){
            return res;
        }

        //用队头元素保存窗口最大值，队列中元素只能是单调递减的，窗口移动可能导致队头元素失效
        LinkedList<Integer> queue = new LinkedList();
        int start = 0, end = size - 1;
        for(int i = start ; i <= end ; i++){
            addLast(queue, num[i]);
        }
        res.add(queue.getFirst());
        //移动窗口
        while(end < num.length - 1){
            addLast(queue, num[++end]);
            if(queue.getFirst() == num[start]){
                queue.pollFirst();
            }
            start++;
            res.add(queue.getFirst());
        }

        return res;
    }

    public void addLast(LinkedList<Integer> queue, int num){
        if(queue == null){
            return;
        }
        //加元素之前要确保该元素小于等于队尾元素
        while(queue.size() != 0 && num > queue.getLast()){
            queue.pollLast();
        }
        queue.addLast(num);
    }
}
