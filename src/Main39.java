import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Dylan
 * @Date : 2020/4/5 13:18
 * @Describe :输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Main39 {
    //方法一：
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null)
            return true;
        return depth(root) != -1;
    }

    private int  depth(TreeNode node) {
        if (node == null)
            return 0;
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        if (Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        }
        return (leftDepth > rightDepth ? leftDepth:rightDepth)+1;
    }

    //方法二：
    private boolean ans;
    //判断二叉树中的每一个节点的左右孩子的高度差的绝对值是否大于1即可
    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null) {
            return true;
        }
        ans = true;
        TreeDepth(root);
        return ans;
    }

    private int TreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (ans) { // 剪枝操作
            int leftDepth = TreeDepth(node.left); // 求出当前节点的左子树的高度
            int rightDepth = TreeDepth(node.right); // 求出当前节点的右子树的高度
            if (Math.abs(leftDepth - rightDepth) > 1) {
                ans = false;
            }
            return Math.max(leftDepth, rightDepth) + 1;
        }
        return 0; // 这个地方返回什么已经不重要了，因为我们已经找一个节点不满足条件了
    }

    //方法三：双重递归
    public boolean IsBalanced_Solution3(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(TreeDepth1(root.left)-TreeDepth1(root.right))>1)
          return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
  }

    private int TreeDepth1(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth1(root.right),TreeDepth1(root.left)) + 1;
    }

}
