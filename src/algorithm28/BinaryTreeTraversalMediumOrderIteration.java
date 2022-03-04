package algorithm28;

import algorithm22.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *  二叉树遍历 中序遍历 迭代
 *  遍历顺序 左根右
 *
 *                     1
 *                  2      3
 *               4    5
 *                   6  7
 *      输出：
 *        4 2 6 5 7 1 3
 */
public class BinaryTreeTraversalMediumOrderIteration {

    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        midorder2(node1);
    }

    public static void midorder2(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            while (!stack.isEmpty()||root!=null){
                if(root!=null){
                    stack.push(root);
                    root = root.left;
                }else {
                    root= stack.pop();
                    System.out.println(root.val);
                    root = root.right;
                }
            }
        }
    }
}
