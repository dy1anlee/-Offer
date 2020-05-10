import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author : Dylan
 * @Date : 2020/4/3 22:21
 * @Describe :输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class Main38 {
    public int TreeDepth(TreeNode root) {
        if(root == null)return 0;
        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }

    public int TreeDepth2(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int high = 0;
        int size;//用size控制high增长的次数和时机(同一层的元素没有完全退出队列的时候high不可以增加)
        TreeNode node;
        while(queue.size() != 0){
            size = queue.size();//队列长度
            while(size != 0){
                node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                size--;//当size==0时说明同一层的元素遍历完成
            }
            high++;
        }
        return high;
    }

    public ArrayList<Integer> preOder(TreeNode root){
        if (root == null)
            return null;
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                root = node.right;
            }
        }
        return list;
    }
}
