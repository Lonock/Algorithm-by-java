package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {
	List<Integer> inorderList = new LinkedList<>();
	
	public TreeNode inorder(TreeNode root) {
		if(root == null) return root;
		

		inorder(root.left);
		inorderList.add(root.val);
		inorder(root.right);
		return root;
	}	
	
    public List<Integer> inorderTraversal1(TreeNode root) {
    	inorder(root);
		return inorderList;
    }
    
    public List<Integer> inorderTraversal2(TreeNode root) {
    	if(root == null) return inorderList;
    	Stack<TreeNode> st = new Stack<>();
    	
    	do {
//    		st.add(root);
    		while(root!=null) {
    			st.push(root);
    			root = root.left;
    		}
    		root = st.pop();
    		inorderList.add(root.val);
    		root = root.right;
    	}while(!st.isEmpty() || root!=null);
    	
		return inorderList;
    }
}
