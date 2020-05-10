/**
 * @Author : Dylan
 * @Date : 2020/4/10 20:08
 * @Describe :请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Main58 {
    //递归
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot == null){
            return true;
        }
        StringBuffer str1 = new StringBuffer("");
        StringBuffer str2 = new StringBuffer("");
        preOrder(pRoot, str1);
        preOrder2(pRoot, str2);
        return str1.toString().equals(str2.toString());
    }

    public void preOrder(TreeNode root, StringBuffer str){
        if(root == null){
            str.append("#");
            return;
        }
        str.append(String.valueOf(root.val));
        preOrder(root.left, str);
        preOrder(root.right, str);
    }

    public void preOrder2(TreeNode root, StringBuffer str){
        if(root == null){
            str.append("#");
            return;
        }
        str.append(String.valueOf(root.val));
        preOrder2(root.right, str);
        preOrder2(root.left, str);
    }
}
