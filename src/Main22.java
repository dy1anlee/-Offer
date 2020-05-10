import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Dylan
 * @Date : 2020/3/31 11:26
 * @Describe :从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class Main22 {

    public  static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            arrayList.add(node.val);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

        return arrayList;
    }

    public  static ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (root == null)
            return arrayList;
        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.remove(0);
            arrayList.add(temp.val);
            if (temp.left != null){
                queue.add(temp.left);
            }
            if (temp.right != null){
                queue.add(temp.right);
            }
        }

        return arrayList;
    }
}
