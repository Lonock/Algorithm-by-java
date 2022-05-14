package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
	List<Integer> preorderList = new LinkedList<>();
	
	public TreeNode preorder(TreeNode root) {
		if(root == null) return root;
		
		preorderList.add(root.val);
		preorder(root.left);
		preorder(root.right);
		return root;
	}
	
    public List<Integer> preorderTraversal(TreeNode root) {
    	preorder(root);
    	
		return preorderList;
    }
    
    public List<Integer> preorderTraversal2(TreeNode root) {
    	Stack<TreeNode> st = new Stack<>();
    	if(root == null) return preorderList;
    	st.push(root);
    	while(!st.isEmpty()) {
    		TreeNode node = st.pop();
    		preorderList.add(node.val);
    		if(node.right != null) st.push(node.right);
    		if(node.left != null) st.push(node.left);
    	}
		return preorderList;
    }
}
