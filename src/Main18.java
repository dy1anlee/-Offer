import java.util.Stack;

/**
 * @Author : Dylan
 * @Date : 2020/3/30 20:08
 * @Describe :操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Main18 {

    public static void Mirror(TreeNode root){
        if (root == null || (root.right == null && root.left == null))
            return;
        if (root.left != null)
            Mirror(root.left);
        if (root.right != null)
            Mirror(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    public static void Mirror1(TreeNode root){
        if (root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node.left != null || node.right != null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
    }


}
