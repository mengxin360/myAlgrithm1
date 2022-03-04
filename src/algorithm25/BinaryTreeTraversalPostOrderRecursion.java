package algorithm25;

import algorithm22.TreeNode;

/**
 * 二叉树遍历 后序 递归
 * 遍历顺序：左右根
 * 当节点第三次成为栈顶元素时打印
 *
 *                      1
 *                  2      3
 *               4    5
 *                   6  7
 *  输出：4 6 7 5 2 3 1
 * */
public class BinaryTreeTraversalPostOrderRecursion {

    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        postOrder(node1);
    }

    public static void postOrder(TreeNode root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }

}
