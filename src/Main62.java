import java.util.Stack;

/**
 * @Author : Dylan
 * @Date : 2020/4/14 20:54
 * @Describe :给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）
 * 中，按结点数值大小顺序第三小结点的值为4。
 */
public class Main62 {
    //中序遍历的 弹出顺序
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        while(!stack.isEmpty() || pRoot != null){
            if (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }else {
                TreeNode node = stack.pop();
                if (--k == 0) {
                    return node;
                }
                System.out.print(node.val + " ");
                pRoot = node.right;
            }
        }
        return null;
    }
}
