package questions;

import structure.TreeNode;

/**
 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。

 示例 1:

 给定二叉树 [3,9,20,null,null,15,7]

     3
   /   \
  9    20
      /  \
     15   7
 返回 true 。

 示例 2:

 给定二叉树 [1,2,2,3,3,null,null,4,4]

           1
         /   \
        2     2
      /  \
     3   3
   /  \
  4   4
 返回 false 。
 *
 */

public class Solution_55 {

    private boolean flag;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);
        Solution_55 solution = new Solution_55();
        boolean balanced = solution.isBalanced(node);
        System.out.println(balanced);
    }
    public boolean isBalanced(TreeNode root) {
        height(root);
        return flag;
    }

    private int height(TreeNode root){
        if(root==null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1){
            flag = false;
        }
        //代码能运行到这里，表示层数应该+1
        return Math.max(left,right)+1;
    }

}
