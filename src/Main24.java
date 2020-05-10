import java.util.ArrayList;

/**
 * @Author : Dylan
 * @Date : 2020/3/31 16:36
 * @Describe :输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Main24 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(FindPath(root,5));
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, target , list ,answer);
        change(answer);

        return answer;
    }
    //选择排序
    private static void change(ArrayList<ArrayList<Integer>> answer) {
        for (int i = 0; i < answer.size(); i++) {
            int index = i;
            for (int j = i + 1; j < answer.size(); j++) {
                if (answer.get(j).size() > answer.get(index).size()) {
                    index = j;
                }
            }
            if (i != index)
            {
                ArrayList<Integer> temp = answer.get(i);
                answer.set(i, answer.get(index));
                answer.set(index, temp);
            }
        }
    }

    private static void solve(TreeNode root, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> answer) {
        if (root == null)
            return;
        target -= root.val;
        list.add(root.val);
        if (target == 0 && root.left == null && root.right == null)
            answer.add(new ArrayList<>(new ArrayList<>(list)));
        solve(root.left, target, list, answer);
        solve(root.right, target, list, answer);
        //回溯
        list.remove(list.size() -1 );
    }
}
