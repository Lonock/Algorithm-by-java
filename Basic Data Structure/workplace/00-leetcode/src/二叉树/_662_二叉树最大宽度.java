package 二叉树;
/*
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _662_二叉树最大宽度 {
    public int widthOfBinaryTree(TreeNode root) {
    	List<Integer> indexQueue = new LinkedList<>();
    	Queue<TreeNode> q1 = new LinkedList<>();
    	int ret = 1;
    	
    	if(root == null) return 0;
    	q1.offer(root);
    	indexQueue.add(1);
    	int count = q1.size();
    	while(!q1.isEmpty()) {
    		root = q1.poll();
    		int index = indexQueue.remove(0);
    		
    		if(root.left!= null) {
    			q1.offer(root.left);
    			indexQueue.add(index*2);
    		}
    		if(root.right!= null) {
    			q1.offer(root.right);
    			indexQueue.add(index*2+1);
    		}
    		
    		if(--count==0) {
    			count = indexQueue.size();
    			if(indexQueue.size() >= 2) 
    				ret = Math.max(ret, indexQueue.get(indexQueue.size()-1) - indexQueue.get(0) + 1);
    		}
    	}

    	return ret;
    }
}
