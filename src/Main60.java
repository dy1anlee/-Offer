import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Dylan
 * @Date : 2020/4/13 19:46
 * @Describe :从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Main60 {

    //层序遍历
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (pRoot == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while(!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                array.add(node.val);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            list.add(new ArrayList<>(array));
            array.clear();
        }
        return list;
    }

    //二，递归
    ArrayList<ArrayList<Integer> > Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if(root == null) return;
        if(depth > list.size())
            list.add(new ArrayList<Integer>());
        list.get(depth -1).add(root.val);

        depth(root.left, depth + 1, list);
        depth(root.right, depth + 1, list);
    }
}
