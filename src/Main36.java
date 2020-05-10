import java.util.ArrayList;

/**
 * @Author : Dylan
 * @Date : 2020/4/3 19:58
 * @Describe :输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class Main36 {

    //使用ArrayList 或者 HashMap,HasSet...
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 ==null || pHead2 == null)
            return null;
        ArrayList<ListNode> list = new ArrayList<>();
        while (pHead1 != null){
            list.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2!=null){
            if (list.contains(pHead2)){
                return pHead2;
            }
            pHead2 = pHead2.next;
        }
        return null;

    }

    //方法二：使用两个指针 每个遍历一次两个链表
    public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
        if (pHead1 ==null || pHead2 == null) return null;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if(p1 != p2){
                p1 = p1 == null ? pHead2 : p1;
                p2 = p2 == null ? pHead1 : p2;
            }
        }
         return p1;
    }

}
