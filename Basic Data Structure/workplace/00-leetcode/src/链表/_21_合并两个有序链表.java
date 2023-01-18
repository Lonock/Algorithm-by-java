package 链表;

import 链表.ListNode;
/*
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	if(list1 == null) {
    		return list2;
    	}else if(list2 == null) {
    		return list1;
    	}
    	if(list1.val <= list2.val) {
    		list1.next = mergeTwoLists(list1.next,list2);
    		return list1;
    	}else {
    		list2.next = mergeTwoLists(list1,list2.next);
    		return list2;
    	}
    	
    }
}
