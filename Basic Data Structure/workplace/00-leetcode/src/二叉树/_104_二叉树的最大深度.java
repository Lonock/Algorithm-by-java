package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class _104_二叉树的最大深度 {
	
	public int maxDepthByRecurrence(TreeNode root,int count) {
		if(root == null) return count;
		
		
		int count1 = maxDepthByRecurrence(root.left, count);
		int count2 = maxDepthByRecurrence(root.right, count);
		count = count1 > count2 ? count1 : count2;
		count++;
		
		return count;
	}
	
	
    public int maxDepth(TreeNode root) {
    	int ret = 0;
 
    	Queue<TreeNode> q1 = new LinkedList<>();
    	if(root == null) return ret;
    	q1.offer(root);
    	int count = q1.size();
    	
    	while(!q1.isEmpty()) {
    		root = q1.poll();
    		
    		if(root.left!=null) q1.offer(root.left);
    		if(root.right!= null) q1.offer(root.right);
    		
//    		l2.add(root.val);
    		if(--count==0) {
    			ret++;
    			count = q1.size();
    		}
    	}
    	
    	return ret;
//		return maxDepthByRecurrence(root, 0);
    }
}
