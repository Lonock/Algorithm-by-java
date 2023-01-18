package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.cn/problems/binary-tree-postorder-traversal/
 */
public class _145_二叉树的后序遍历 {
	List<Integer> postorderList = new LinkedList<>();
	
	public TreeNode postorder(TreeNode root) {
		if(root == null) return root;
		

		postorder(root.left);
		postorder(root.right);
		postorderList.add(root.val);
		return root;
	}	
	
    public List<Integer> postorderTraversal1(TreeNode root) {
    	postorder(root);
		return postorderList;
    }
    
    public List<Integer> postorderTraversal2(TreeNode root) {
    	if(root == null) return postorderList;
    	Stack<TreeNode> st1 = new Stack<>();
    	Stack<TreeNode> st2 = new Stack<>();
    	st1.push(root);
    	while(!st1.isEmpty()) {
    		root = st1.pop();
    		st2.push(root);
    		if(root.left!=null)
    			st1.push(root.left);
    		if(root.right!=null)
    			st1.push(root.right);
    	}
    	
    	while(!st2.isEmpty())
    		postorderList.add(st2.pop().val);
    	
		return postorderList;
    }
}
