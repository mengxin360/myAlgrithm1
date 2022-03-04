package algorithm31;

import algorithm22.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 31、32、33
 *  二叉树遍历-线索二叉树
 *                     1
 *                2         3
 *           4       5
 *                6    7
 *  前序遍历顺序：1 2 4 5 6 7 3
 *  前序线索二叉树：4指向5  6指向7   7指向3
 *  中序遍历顺序：4 2 6 5 7 1 3
 *  中序线索二叉树（常用）：中序二叉树就相当于二叉树垂直投影到一跳直线上
 *  方便找前后驱节点
 *  后续遍历顺序：4 6 7 5 2 3 1
 * */
public class BinaryTreeTraversalClueBinaryTree {

    public static  void main(String args[]){
        TreeNode node7 = new TreeNode(7,null,null);
        TreeNode node6 = new TreeNode(6,null,null);
        TreeNode node5 = new TreeNode(5,node6,node7);
        TreeNode node4 = new TreeNode(4,null,null);
        TreeNode node3 = new TreeNode(3,null,null);
        TreeNode node2 = new TreeNode(2,node4,node5);
        TreeNode node1 = new TreeNode(1,node2,node3);
//        morrisPre(node1);
//        morrisMid(node1);
        morrisPost(node1);
    }
    //前序morris
    public static void morrisPre(TreeNode cur){
        if(cur == null){
            return;
        }
        TreeNode mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){//建立线索指针
                    mostRight.right = cur;
                    System.out.println(cur.val);
                    cur = cur.left;
                    continue;
                }else{//mostRight.right == cur 删除线索指针
                    mostRight.right = null;
                }
            }else{
                System.out.println(cur.val);
            }
            cur = cur.right;
        }
    }

    //中序morris
    public static void morrisMid(TreeNode cur){
        if(cur == null){
            return;
        }
        TreeNode mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){//建立线索指针
                    mostRight.right = cur;
//                    System.out.println(cur.val);
                    cur = cur.left;
                    continue;
                }else{//mostRight.right == cur 删除线索指针
                    mostRight.right = null;
                }
            }else{
//                System.out.println(cur.val);
            }
            System.out.println(cur.val);
            cur = cur.right;
        }
    }

    public static void morrisPost(TreeNode cur){
        if(cur == null){
            return;
        }
        TreeNode root = cur;
        TreeNode mostRight = null;
        while(cur != null){
            mostRight = cur.left;
            if(mostRight != null){
                while(mostRight.right != null && mostRight.right != cur){
                    mostRight = mostRight.right;
                }
                if(mostRight.right == null){//建立线索指针
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else{//mostRight.right == cur 删除线索指针
                    mostRight.right = null;
                    printNode(cur.left);
                }
            }
            cur = cur.right;
        }
        printNode(root);
    }

    public static void printNode(TreeNode head){
        TreeNode tail = reverse(head);
        while (tail != null){
            System.out.println(tail.val);
            tail = tail.right;
        }
        reverse(tail);
    }

    public static TreeNode reverse(TreeNode head){
        TreeNode prev = null,cur,next;
        cur = head;
        while (cur!=null){
            next = cur.right;
            cur.right = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

}
