/**
 * @Author : Dylan
 * @Date : 2020/3/30 12:32
 * @Describe :输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Main17 {

    //递归
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {

        if(root1 == null || root2 == null){
            return false;
        }

        return doesTree2inTree1(root1,root2) || doesTree2inTree1(root1.left,root2) || doesTree2inTree1(root1.right,root2);
    }

    public boolean doesTree2inTree1(TreeNode root1,TreeNode root2){
        if (root1 == null)
            return false;
        if (root2 == null)
            return true;
        if (root1.val != root2.val)
            return doesTree2inTree1(root1.left,root2) || doesTree2inTree1(root1.right,root2);
        return doesTree2inTree1(root1.left,root2.left) && doesTree2inTree1(root1.right,root2.right);
    }


}
