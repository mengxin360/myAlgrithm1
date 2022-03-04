package algorithm27;

import algorithm22.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * 二叉树遍历 前序遍历 迭代
 *  借助栈 stack 后进先出
 *  用LinkedList可以实现栈
 *
 *                     1
 *                  2      3
 *               4    5
 *                   6  7
 *           输出：
 *              1 2 4 5 6 7 3
 * */
public class BinaryTreeTraversalPreorderIteration {

    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        preorder2(node1);

    }

    //前序遍历 根左右
    public static void preorder2(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            stack.add(root);
            //如果栈空了 循环就结束
            while (!stack.isEmpty()){
                root = stack.pop();//pop方法表示将栈顶元素出栈
                if (root!=null){
                    System.out.println(root.val);
                    stack.push(root.right);
                    stack.push(root.left);
                    //为什么先push右边再push左边？
                    //因为前序遍历要先打印左边再打印右边 如果反过来 右边节点就在栈顶了，会优先被打印
                }
            }
        }
    }

}
