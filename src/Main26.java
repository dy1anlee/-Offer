import java.util.Stack;

/**
 * @Author : Dylan
 * @Date : 2020/3/31 22:40
 * @Describe :输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要
 * 求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class Main26 {

    //非递归
    public TreeNode Convert(TreeNode pRootOfTree) {

        if (pRootOfTree == null)
            return pRootOfTree;

        TreeNode root = pRootOfTree;
        TreeNode pre = null;
        TreeNode node;
        TreeNode ans = null;
        boolean isHead = true;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                if(isHead){
                    node = stack.pop();
                    ans = node;
                    pre = ans;
                    isHead = false;
                }else {
                    node = stack.pop();
                    pre.right = node;
                    node.left = pre;
                    pre = node;
                }
                root = node.right;
            }
        }
        return ans;
    }

    //递归
    public TreeNode Convert1(TreeNode root) {
        if(root==null)
            return null;
        //if(root.left==null&&root.right==null)
        //   return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = Convert(root.left);
        TreeNode pre = left;
        // 2.定位至左子树双链表最后一个节点
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if(pre != null){
            while(pre != null && pre.right != null){
                pre = pre.right;
            }
            pre.right = root;
            root.left = pre;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = Convert(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if(right!=null){
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }
}
