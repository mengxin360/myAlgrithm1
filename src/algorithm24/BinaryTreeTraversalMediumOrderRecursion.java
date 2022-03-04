package algorithm24;

import algorithm22.TreeNode;

/**
 * 二叉树遍历 中序 递归
 * 遍历顺序：左根右
 * 对于中序遍历来说，相比于前序遍历，它不能第一次称为栈顶（入栈）时打印
 * 要优先打印最左边的节点
 * 也就是当节点第二次成为栈顶元素时打印
 *
 *                     1
 *                  2      3
 *               4    5
 *                   6  7
 *      输出：
 *        4 2 6 5 7 1 3
 * */
public class BinaryTreeTraversalMediumOrderRecursion {
    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        mediumOrder(node1);
    }

    public static void mediumOrder(TreeNode root){
        if(root==null){
            return;
        }
        mediumOrder(root.left);
        System.out.println(root.val);
        mediumOrder(root.right);
    }
}
