import java.util.ArrayList;

/**
 * @Author : Dylan
 * @Date : 2020/3/28 21:53
 * @Describe :输入一个链表，输出该链表中倒数第k个结点。
 */
public class Main14 {

    //方法一 ：使用Arraylist 或者 栈
    public ListNode FindKthToTail(ListNode head,int k) {
        ArrayList<ListNode> list = new ArrayList<>();
        if(head == null)
            return null;

        while(head != null){
            list.add(head);
            head = head.next;
        }
        if(k > list.size() || k <= 0)
            return null;

        return list.get(list.size() - k);
    }

    //遍历一次
    public ListNode FindKthToTail2(ListNode head,int k) {
        if(head == null)
            return null;
        ListNode first = head;
        ListNode second = head;
        while(first != null){
            if(k == 0){
                first = first.next;
                second = second.next;
            }else{
                first = first.next;
                k--;
            }
            if(k != 0 && first == null)
                return null;
        }

        return second;
    }
    //递归
    int count = 1;
    ListNode node;
    public ListNode FindKthToTail3(ListNode head,int k) {
        if (head != null) {
            this.FindKthToTail(head.next, k);
            if (count++ == k) {
                node = head;
            }
        }
        return node;
    }
}
