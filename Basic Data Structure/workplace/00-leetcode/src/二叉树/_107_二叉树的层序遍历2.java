package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/
 */
public class _107_二叉树的层序遍历2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	Stack<List<Integer>> s1 = new Stack<>();
    	List<List<Integer>> l1 = new LinkedList<>();
    	List<Integer> l2 = new LinkedList<>();
    	Queue<TreeNode> q1 = new LinkedList<>();
    	if(root == null) return l1;
    	q1.offer(root);
    	int count = q1.size();
    	while(!q1.isEmpty()) {
    		root = q1.poll();
    		
    		if(root.left!=null) q1.offer(root.left);
    		if(root.right!= null) q1.offer(root.right);
    		
    		l2.add(root.val);
    		if(--count==0) {
    			count = q1.size();
    			List<Integer> l3 = new LinkedList<>(l2);
    			s1.push(l3);
    			l2.clear();
    		}
    	}
    	
    	while(!s1.isEmpty()) {
    		l1.add(s1.pop());
    	}
    	
		return l1;
    }
}
