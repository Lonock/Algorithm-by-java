package 链表;
import 链表.ListNode;

/*
 * https://leetcode-cn.com/problems/reverse-linked-list/
 * 
 */
public class _206_反转链表 {
    public ListNode  reverseList(ListNode head) {
    	if (head.next == null)
    		return head;
    	ListNode newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	
    	return newHead;
    }
    
    public ListNode  reverseList2(ListNode head) {
    		ListNode nextHead = head.next;
    		ListNode nextHead2 = nextHead.next;
    	while(head != null && head.next != null) {
    		nextHead = head.next;
    		nextHead2 = nextHead.next;
    		nextHead.next = head;
    		head.next = null;
    		head = nextHead2;
    	}
    	return head;
    }
}
