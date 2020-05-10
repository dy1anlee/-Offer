import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author : Dylan
 * @Date : 2020/3/27 9:41
 * @Describe :输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class Main3 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode removeNode = head;

        for (int i = 1; i < 10; i++) {
            ListNode x = new ListNode(i);
            //x.next = null;
            removeNode.next = x;
            removeNode = x;
        }
        System.out.println(printListFromTailToHead3(head));

    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        while(listNode != null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while(listNode != null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }

    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {

        ArrayList<Integer> list = new ArrayList<>();
        if(listNode == null){
            return list;
        }
        return solve(list,listNode);
    }

    private static ArrayList<Integer> solve(ArrayList<Integer> list, ListNode listNode) {
        if (listNode != null){
            list = solve(list,listNode.next);
            list.add(listNode.val);
        }
        //list.add(listNode.val);
        return list;
    }


    ArrayList<Integer> list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead4(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}