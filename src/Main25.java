import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Dylan
 * @Date : 2020/3/31 18:01
 * @Describe :输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Main25 {
    public static void main(String[] args) {
        RandomListNode node = new RandomListNode(3);
        node.next = new RandomListNode(4);
        node.next.next = new RandomListNode(9);
        node.next.random = node;
        node.next.next.random = node.next;
        node.random = node.next.next;

        Clone1(node);
    }

    //使用map 方法一
    //    1 --->2--->3               1 --->2--->3
    //                    ------>
    //new 1     2    3               1 --->2--->3
    public static RandomListNode Clone(RandomListNode pHead){
        if (pHead == null)
            return null;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode head = pHead;
        while (head != null){
            RandomListNode node = new RandomListNode(head.label);
            map.put(head,node);
            head = head.next;
        }
        head = pHead;
        while(head != null){
            RandomListNode node = map.get(head);
            node.next = map.get(head.next);
            node.random = map.get(head.random);
            head = head.next;
        }
        return map.get(pHead);
    }

    //方法二：
    public static RandomListNode Clone2(RandomListNode pHead){
        if (pHead == null)
            return null;
        RandomListNode removeNode = pHead;
        while (removeNode != null){
            RandomListNode node = new RandomListNode(removeNode.label);
            node.next = removeNode.next;
            removeNode.next = node;
            removeNode = node.next;
        }

        removeNode = pHead;
        while (removeNode != null){
            RandomListNode node = removeNode.next;
            node.random = removeNode.random == null ? null : removeNode.random.next;
            removeNode = node.next;
        }

        removeNode = pHead;
        RandomListNode clobeHead = removeNode.next;
        while (removeNode != null){
            RandomListNode node = removeNode.next;
            removeNode.next = node.next;
            node.next = node.next == null ? null : node.next.next;
            removeNode = removeNode.next;
        }
        return  clobeHead;
    }

    //不符合题意
    public static RandomListNode Clone1(RandomListNode pHead)
    {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<RandomListNode> random = new ArrayList<>();

        while(pHead != null){
            array.add(pHead.label);
            random.add(pHead.random);
            pHead = pHead.next;
        }

        RandomListNode newNode1;
        newNode1 = new RandomListNode(array.remove(0));
        RandomListNode newNode = newNode1;
        while(array.size() > 0){
            newNode1.next = new RandomListNode(array.remove(0));
            newNode1 = newNode1.next;
        }

        RandomListNode answer = newNode;
        while (newNode != null){
            newNode.random = random.remove(0);
            newNode = newNode.next;
        }

        return answer;
    }
}


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}