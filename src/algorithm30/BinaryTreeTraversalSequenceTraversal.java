package algorithm30;

import algorithm22.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  层序遍历
 *  FIFO Queue
 *  输出：1 2 3 4 5 6 7
 * */
public class BinaryTreeTraversalSequenceTraversal {
    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        levelOrder(node1);
    }

    public static void levelOrder(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            if (node != null){
                System.out.println(node.val);
                q.add(node.left);
                q.add(node.right);
            }
        }

    }
}
