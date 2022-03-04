package algorithm08;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  二叉树的最小深度
 *
 *  给定一个二叉树，找出其最小深度。
 *  最小深度是从根节点到最近叶子结点的最短路径上的节点数量
 *  深度优先、广度优先
 *
 *                   1
 *             2           3
 *         4    5       6
 *                    7
 * */
//时间复杂度都为O(n) 都是只遍历了二叉树 空间复杂度：深度遍历取决于树的深度，其空间复杂度为O(logN)
//广度优先空间复杂度为O(N),与队列的长度有关
public class MinimumDepthOfBinaryTree {
    public static void main(String args[]){
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node6 = new TreeNode(6, node7, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node3 = new TreeNode(3, node6, null);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(minDepth(node1));
        System.out.println(minDepth2(node1));
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int deep; //广度优先遍历时需要用到的变量，用于维护每一个节点的深度
        TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    //方法一：深度优先
    //思路：深度遍历二叉树，找到每一个叶子节点，将叶子节点的深度记为1，从叶子节点开始往上走记录深度
    //由于本题找得是最小深度，所以涉及二者比较时，选择最小的值。
    //每一个节点的深度都取决于它子节点的深度，有较小子节点深度加1，得到本节点的深度，所以父子节点间
    // 存在深度递归关系
    public static int minDepth(TreeNode root){
        if (root==null){
            return 0;
        }
        // 通过这个if找到叶子节点
        if(root.left == null && root.right == null){
            return 1;
        }
        int min = Integer.MAX_VALUE;//保存最小深度的变量，初始化一个最大值
        if (root.left != null){ // 左边节点如果不为空，就要计算左边节点的深度
            min = Math.min(minDepth(root.left),min);
        }
        if (root.right != null){ // 右边节点如果不为空，就要计算右边节点的深度
            min = Math.min(minDepth(root.right),min);
        }
        return min + 1;
    }
    //方法二：广度优先
    //思路：把根节点标为1，由于是找最小深度，所以遍历二叉树，在找到第一个叶子节点后，其余的就不用再找了
    //广度优先使用一个先进先出的队列实现，先把1入队再出队，看看它是不是叶子节点，如果是叶子节点就结束了
    //如果1不是叶子节点，就把1的左子节点和右子节点都入队，左右子节点入队的先后顺序无所谓，没影响
    //假设左子节点先入队，右子节点后入队，那么在左子节点出队的时候，左子节点的两个子节点会入队，然后右边子
    //节点出队，然后右边子节点的两个子节点入队。
    public static int minDepth2(TreeNode root){
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//使用链表实现一个先进先出的队列
        root.deep = 1;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left==null&&node.right==null){
                return  node.deep;
            }
            if(node.left!=null){
                node.left.deep = node.deep+1;
                queue.offer(node.left);
            }
            if(node.right!=null){
                node.right.deep = node.deep+1;
                queue.offer(node.right);
            }
        }
        return 0;
    }
}
