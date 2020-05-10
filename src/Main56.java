/**
 * @Author : Dylan
 * @Date : 2020/4/10 15:50
 * @Describe :在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Main56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)return null;
        ListNode node = new ListNode(-1);
        node.next = pHead;
        ListNode pre = node;
        ListNode p = pHead;
        boolean flag = false;
        while (p != null){
            if (p.next != null && p.val == p.next.val){
                /*p = p.next;
                flag = true;
            }else if (flag){
                pre.next = p.next;
                p = pre.next;
                flag = false;*/
                while(p.next != null && p.val == p.next.val){
                    p = p.next;
                }
                pre.next = p.next;
                p = p.next;
            }else {
                pre = p;
                p = p.next;

            }
        }
        return node.next;
    }

    private ListNode change(ListNode x) {
        int temp = x.val;
        while (x != null && x.val == temp) {
            x = x.next;
        }
        return x;
    }
    public ListNode deleteDuplication2(ListNode pHead) {
        ListNode ans = pHead; // 最终链表的头节点
        // 确定最终链表的头节点
        while (ans != null) {
            if (ans.next != null && ans.val == ans.next.val) {
                // 当前ans所指的节点是重复节点
                ans = change(ans);
            } else {
                // 当前ans所指的节点就是我们最终链表的头节点
                break;
            }
        }
        if (ans != null) {
            ans.next = deleteDuplication(ans.next);
        }
        return ans;
    }
}
