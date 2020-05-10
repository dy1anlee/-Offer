/**
 * @Author : Dylan
 * @Date : 2020/4/10 18:32
 * @Describe :
 */
public class Main57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null)return null;
        if (pNode.next == null && pNode.left == null && pNode.right == null) return null;

        if (pNode.left == null && pNode.right == null){
            if (pNode.next != null && pNode == pNode.next.left){
                return pNode.next;
            }else if(pNode.next != null && pNode == pNode.next.right) {
                while (pNode.next != null && pNode == pNode.next.right){
                    pNode = pNode.next;
                }
                if (pNode.next != null)
                    return pNode.next;
                return null;
            }else {
                return null;
            }
        }else if (pNode.right != null){
            TreeLinkNode node = pNode.right;
            while (node.left != null){
                node = node.left;
            }
            return node;
        }else{
            if (pNode.next == null)
                return null;
            return pNode.next;
        }
    }

    //1. 如果当前结点有右子树，那么其后继结点就是其右子树上的最左结点
    //2. 如果当前结点没有右子树，那么其后继结点就是其祖先结点中，将它当做左子树上的结点的那一个。
    public TreeLinkNode GetNext1(TreeLinkNode pNode){
        if(pNode == null){
            return null;
        }
        //如果有右子树，后继结点是右子树上最左的结点
        if(pNode.right != null){
            TreeLinkNode p = pNode.right;
            while(p.left != null){
                p = p.left;
            }
            return p;
        }else{
            //如果没有右子树，向上查找第一个当前结点是父结点的左孩子的结点
            TreeLinkNode p = pNode.next;
            while(p != null && pNode != p.left){
                pNode = p;
                p = p.next;
            }

            if(p != null && pNode == p.left){
                return p;
            }
            return null;
        }
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}