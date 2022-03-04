package algorithm29;

import algorithm22.TreeNode;

import java.util.Stack;

// 二叉树遍历 后续遍历 迭代遍历
// 左右根
//                              1
//                           2      3
//                        4    5
//                            6  7
//               输出：
//                 4 6 7 5 2 3 1

public class BinaryTreeTraversalPostOrderTraversal {

    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        postorder(node1);
    }

    public static void postorder(TreeNode root){
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode prev = null;
            while (!stack.isEmpty()||root!=null){
                while (root!=null){
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if(root.right==null || root.right == prev){
                    System.out.println(root.val);
                    prev = root;
                    root = null;
                }else {
                    stack.push(root);
                    root = root.right;
                }
            }
        }
    }

}
