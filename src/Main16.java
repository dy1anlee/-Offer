import java.util.PriorityQueue;

/**
 * @Author : Dylan
 * @Date : 2020/3/29 9:04
 * @Describe :
 */
public class Main16 {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);

        ListNode root = Merge3(list1,list2);

        while (root != null){
            System.out.println(root.val);
            root = root.next;
        }

        ListNode root1 = new ListNode(0);
        ListNode head = root1;
        root1.next = new ListNode(2);
        System.out.println(head.next.val);

    }
    public static ListNode Merge(ListNode list1,ListNode list2) {

        if (list1 == null)
            return  list2;
        if (list2 == null)
            return list1;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //ArrayList<Integer> arrayList = new ArrayList<>();
        while(list1 != null){
            queue.add(list1.val);
            list1 = list1.next;
        }
        while(list2 != null){
            queue.add(list2.val);
            list2 = list2.next;
        }

        //System.out.println(queue.size());
        ListNode head = new ListNode(queue.poll());
        ListNode remove = head;
        while(!queue.isEmpty()) {

            ListNode x = new ListNode(queue.poll());
            remove.next = x;
            remove = x;
        }
        return head;
    }

    //递归
    public static ListNode Merge2(ListNode list1, ListNode list2){
        if (list1 == null)
            return  list2;
        if (list2 == null)
            return list1;

        if (list1.val <= list2.val){
            list1.next = Merge2(list1.next,list2);
            return list1;
        }else {
            list2.next = Merge2(list1,list2.next);
            return list2;
        }
    }

    public static ListNode Merge3(ListNode list1, ListNode list2){
        if (list1 == null)
            return  list2;
        if (list2 == null)
            return list1;
        ListNode root = null;
        ListNode head = new ListNode(1);
        root = head;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                head.next = list1;
                head = list1;
                list1 = list1.next;
            }else {
                head.next = list2;
                head = list2;
                list2 = list2.next;
            }
        }
        if (list1 != null){
            head.next = list1;
        }else {
            head.next = list2;
        }

        return  root.next;
    }
}
