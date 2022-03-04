package algorithm05;

import java.util.HashSet;
import java.util.Set;

/**
 *  环形链表
 *
 *  给定一个链表，判断链表中是否有环。
 *  如果链表中有某个节点，可以通过连续跟踪next指针再次到达该节点，则链表中存在环
 *
 *  如果链表中存在环，则返回true。否则，返回false。
 * */
public class CircularLinkedList {

    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String args[]){
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node5.next = node3;

        System.out.println(hasCycle(node1));
        System.out.println(hasCycle2(node1));
    }

    // 方法一：遍历一次 所以时间复杂度为O(n) 空间复杂度为O(n)
    public static boolean hasCycle(ListNode head){
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null){
            if(!set.add(head)){
                return true;
            }
            head = head.next;
        }
        return false;
    }
    // 方法二：双指针 ，设置一个快指针，一个慢指针，如果两个指针相遇，说明存在环路。
    // 如果两个指针没有相遇，并且快指针指向了null，说明没有环路。
    // 该方法的时间复杂度为O(n) 空间复杂度就是两个指针
    public static boolean hasCycle2(ListNode head){
        if(head == null || head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow != quick){
            if(quick==null||quick.next==null){
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

}
