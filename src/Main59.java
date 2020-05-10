import java.util.*;

/**
 * @Author : Dylan
 * @Date : 2020/4/10 21:19
 * @Describe :请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class Main59 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(pRoot == null){
            return res;
        }

        Stack<TreeNode> stack1 = new Stack();
        Stack<TreeNode> stack2 = new Stack();
        stack1.push(pRoot);
        boolean flag = true;//先加左孩子，再加右孩子
        while(!stack1.empty() || !stack2.empty()){
            Stack<TreeNode> empty = stack1.empty() ? stack1 : stack2;
            stack1 = stack1 == empty ? stack2 : stack1;
            stack2 = empty;
            ArrayList<Integer> row = new ArrayList();
            while(!stack1.empty()){
                TreeNode p = stack1.pop();
                row.add(p.val);
                if(flag){
                    if(p.left != null){
                        stack2.push(p.left);
                    }
                    if(p.right != null){
                        stack2.push(p.right);
                    }
                }else{
                    if(p.right != null){
                        stack2.push(p.right);
                    }
                    if(p.left != null){
                        stack2.push(p.left);
                    }
                }
            }
            res.add(row);
            flag = !flag;
        }

        return res;
    }

    public static ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        while (!s1.empty() || !s2.empty()) {
            if (layer%2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if(node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sum = 1; // 用来保存每一层的节点的个数
        int num = 1;

        while (!queue.isEmpty() && root != null) {
            List<Integer> list = new LinkedList<>();
            int temp = 0;
            while (sum > 0) {
                TreeNode node = queue.poll();
                assert node != null;
                list.add(node.val);
                if(node.left != null) {
                    temp++;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    temp++;
                    queue.add(node.right);
                }
                sum--;
            }
            sum = temp;
            if(num % 2 == 0) {
                for (int i  = 0, j = list.size() - 1; i < j; i++, j--) {
                    int res = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, res);
                }
            }
            num++;
            ans.add(list);
        }
        return ans;
    }
}
