package algorithm01;

// 链表反转 迭代法
// 迭代，重复某一过程，每一次处理结果作为下一次处理的初始值，而这些初始值类似于状态
// 每次处理都会改变状态、直至达到最终状态
public class LinkedListInversionIteration {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
    }

    //迭代
    public static ListNode iterate(ListNode head){
        ListNode prev=null,next;
        ListNode curr = head;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String args[]){
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

       ListNode prev = iterate(node1);
      System.out.println(prev);

    }


}
