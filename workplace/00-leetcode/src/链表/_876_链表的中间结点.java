package 链表;

/*
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
    	int count = 0;
    	for (ListNode node = head; node != null; node=node.next) 
			count++;
    	int mid = count / 2;
    	for (int i = 0; i < mid; i++) {
			head = head.next;
		}
    	return head;
    }
    public ListNode middleNode2(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	while(fast!=null && fast.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return head;
    }
}
