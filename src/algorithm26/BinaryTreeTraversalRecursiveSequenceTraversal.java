package algorithm26;

import algorithm22.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  二叉树遍历 层序遍历 递归遍历
 *  层序遍历：从上往下、从左往右
 *
 *  list可以自动扩容 所以用list而不用数组
 *
 *              i
 *         2*i    2*i+1
 *
 *             1
 *         2        3
 *     4      5
 *          6  7
 * */
public class BinaryTreeTraversalRecursiveSequenceTraversal {

    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
        ArrayList list = new ArrayList();
        levelOrder(node1,1,list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void levelOrder(TreeNode root,int i, ArrayList list){

        if (root==null){
            return;
        }
        //防止数组越界
        int length = list.size();
        if(length<=i){
            for(int j=0;j<=i-length;j++){
                list.add(length+j,null);
            }
        }
        //list中的add方法会导致下标出现错误
        //list中的set是针对某一个索引位置的值就行一次修改
        list.set(i,root.val);
        levelOrder(root.left,2*i,list);
        levelOrder(root.right,2*i+1,list);

    }
}
