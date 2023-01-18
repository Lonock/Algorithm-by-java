package 链表;

/*
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
   public ListNode deleteDuplicates(ListNode head) {
	   	if(head == null || head.next == null)
			return head;
		for (ListNode cur = head; cur.next != null;) {
			if(cur.next.val == cur.val) {
				cur.next = cur.next.next;
				if(cur.next == null)
					break;
			}else
				 cur = cur.next;
		}
	   	if(head == null || head.next == null)
			return head;
		if(head.val == head.next.val)
			head = head.next;
		
		return head;	   
    }
}
