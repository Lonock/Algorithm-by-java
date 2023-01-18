package 链表;
import 链表.ListNode;

public class _24_两两交换链表中的节点 {
    public ListNode swapPairs(ListNode head) {
    	if(head == null || head.next == null)
    		return head;
    	ListNode nextNode = head.next;
    	head.next = nextNode.next;
    	nextNode.next = head;
    	head = nextNode;
    	nextNode = head.next;
    	nextNode.next = swapPairs(nextNode.next);
    	
    	return head;
    }
}
