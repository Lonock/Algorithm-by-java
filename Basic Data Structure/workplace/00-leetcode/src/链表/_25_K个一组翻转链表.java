package 链表;
import 链表._206_反转链表;

/*
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */

public class _25_K个一组翻转链表 {
	
    public ListNode  reverseList(ListNode head) {
    	if (head.next == null)
    		return head;
    	ListNode newHead = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	
    	return newHead;
    }
	
    public ListNode reverseKGroup(ListNode head, int k) {
    	ListNode node1 = head;
    	ListNode nextNode = head;
    	for(int i = 1; i < k; i++) {
    		if(node1 == null)
    			return head;
    		node1 = node1.next;
    		if(i == k) {
    			nextNode = node1.next;
    			node1.next = null;
    		}
    	}
    	reverseList(head);
    	head.next = reverseKGroup(nextNode, k);
    	
    	return nextNode;
    }
}
