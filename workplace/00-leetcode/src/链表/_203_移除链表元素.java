package 链表;

/*
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {

    public ListNode removeElements(ListNode head, int val) {
    	if(head == null)
    		return head;
    	for (ListNode cur = head; cur.next != null;) {
			if(cur.next.val == val) {
				cur.next = cur.next.next;
				if(cur.next == null)
					break;
			}else
				 cur = cur.next;
		}
    	if(head.val == val)
    		head = head.next;
    	
    	return head;
    }
}
