package algorithm22;

/**
 *  二叉树遍历
 *  前序遍历：根左右
 *  中序遍历：左根右
 *  后序遍历：左右根
 *  层序遍历：从上往下、从左往右
 *
 *  递归遍历：使用递归方法遍历
 *  迭代遍历：使用迭代方法实现递归函数，与递归等价
 *
 *  递归一定可以转迭代，迭代也一定可以转递归
 *
 *  morris遍历
 * */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;
    public int deep;
    public TreeNode(){}
    public TreeNode(int val){this.val=val;}
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
