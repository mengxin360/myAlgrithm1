package algorithm12;

/**
 *  链表反转
 *  例如：输入 12345
 *        输出 54321
 *
 *  思路：递归法
 *  将整个大问题，拆解成一个个性质一样的小问题,解决这些个小问题进而解决大问题
 * */
public class LinkedListInversion {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next){
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
        ListNode prev = recursion(node1);
        System.out.println(prev);

    }

    public static ListNode recursion(ListNode head){

        //head == null表示链表本身为空，所以返回null就可以
        // head.next==null表示到达最后的节点 所以返回head
        if (head == null ||  head.next==null){
            return head;
        }

        //自己调用自己找到最后一个节点 往recursion中传入head.next就可以找到head的下一个节点了
        ListNode new_head = recursion(head.next); // 2

        head.next.next = head; //1
        head.next = null;  //1

        return new_head;
    }
}
