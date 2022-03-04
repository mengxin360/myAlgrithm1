package algorithm23;

import algorithm22.TreeNode;

/**
 * 二叉树遍历 前序 递归
 *  遍历顺序：根左右
 *                 root
 *          left         right
 *      null   null    null   null
 *
 *
 * 递归存在一个调用栈
 * 首先根节点先入栈，同时打印这个根节点，但是此时根节点并不能直接出栈，而是先判断是否有
 * 左子节点和右子节点，当根节点不存在左右子节点时，才能够出栈。如果该根节点存在左右子
 * 节点时，它就首先需要将左子节点入栈，同时打印该左子节点。此时左子节点压入它的左子节点，
 * 发现为null，则将其出栈，然后压入它的右子节点，发现也为null，则也将其出栈，此时根节点的
 * 左子节点已经没有可以压入的节点了，那么它就可以出栈了。此时根节点发现它的右侧存在右子节
 * 点，那么将其压入栈，同时打印根节点的右子节点，与左子节点同理，右子节点也会压入它的左子
 * 节点，发现其也为null，则将其出栈，然后压入根节点的右子节点，发现也为null，将其出栈后，
 * 根节点的右子节点也会出栈。最后根节点会发现它也没有可以压入栈中的节点了，那么此时根节点
 * 也会出栈
 *
 * 总结：当节点第一次称为栈顶元素时，打印出这个节点。
 *       当栈中压入null时，则null出栈
 *       节点没有可以继续压入的节点时（各节点不重复压入），节点出栈
 *
 *
 *                     1
 *                  2      3
 *               4    5
 *                   6  7
 *      输出：
 *        1 2 4 5 6 7 3
 * */
public class BinaryTreeTraversalPreOrderRecursion {

    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        preorder(node1);
    }

    public static void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

}
