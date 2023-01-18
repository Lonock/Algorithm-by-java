package 二叉树;

import java.util.LinkedList;
import java.util.Queue;
//import TreeNode;

/*
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {
    public TreeNode invertTree1(TreeNode root) {
    	if(root == null) return root;
    	TreeNode tmp = root.left;
    	root.left = root.right;
    	root.right = tmp;
    	invertTree1(root.left);
    	invertTree1(root.right);
    	return root;
    }
    
    public TreeNode invertTree(TreeNode root) {
    	if(root == null) return root;
    	
    	TreeNode ret = root;
    	Queue<TreeNode> q1 = new LinkedList<>();
    	q1.offer(root);
    	while(!q1.isEmpty()) {
	    	root = q1.remove();
	    	TreeNode tmp = root.left;
	    	root.left = root.right;
	    	root.right = tmp;  	
	    	if(root.left != null) {
	    		q1.offer(root.left);
	    	}
	    	
	    	if(root.right != null) {
	    		q1.offer(root.right);
	    	}
    	}
    	return ret;
    }
}
