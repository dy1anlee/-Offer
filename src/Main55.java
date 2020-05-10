import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Author : Dylan
 * @Date : 2020/4/10 11:55
 * @Describe :给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Main55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null)
            return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode node = pHead;
        while (node != null){
            if (set.contains(node)){
                return node;
            }else {
                set.add(node);
                node = node.next;
            }
        }
        return null;
    }

    public ListNode EntryNodeOfLoop2(ListNode pHead)
    {
        Map<ListNode, Integer> map = new HashMap<>();
        ListNode node =  pHead;
        while (node != null) {
            map.put(node, map.getOrDefault(node, 0) + 1);
            if (map.get(node) == 2) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    ListNode EntryNodeOfLoop3(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == p2)
                    return p1;
            }
        }
        return null;
    }
}
