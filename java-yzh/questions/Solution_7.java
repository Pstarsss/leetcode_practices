package questions;

import structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 *
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *
 *
 * 示例 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 * 要点是讲重建二叉树转化成重建小的二叉树
 */
public class Solution_7 {

    private Map<Integer,Integer> indexMap = new HashMap<>();

    public static void main(String[] args) {
        Solution_7 solution = new Solution_7();
        int[] preorder = {1,2,3};
        int[] inorder = {1,2,3};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        System.out.println(treeNode);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length < 1) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i],i);
        }
        return searchTree(preorder, 0,preorder.length-1, inorder,0,inorder.length -1);
    }

    private TreeNode searchTree(int[] preOrder, int pStart, int pEnd,int[] inOrder,int iStart,int iEnd) {
        if(pStart > pEnd){
            return null;
        }

        int val = preOrder[pStart];
        TreeNode root = new TreeNode(val);
        int rootIndex = indexMap.get(val);
        int count = rootIndex - iStart;

        root.left = searchTree(preOrder, pStart+1, pStart+count ,inOrder,iStart,rootIndex -1);
        root.right = searchTree(preOrder, pStart + count + 1,pEnd,inOrder,rootIndex+1,iEnd);

        return root;
    }


}
