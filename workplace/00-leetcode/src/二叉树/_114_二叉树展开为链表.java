package 二叉树;

import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/
 */
public class _114_二叉树展开为链表 {
	List<TreeNode> preorderList = new LinkedList<>();
	
	public TreeNode preorder(TreeNode root) {
		if(root == null) return root;
		
		preorderList.add(root);
		preorder(root.left);
		preorder(root.right);
		return root;
	}
	
    public void flatten1(TreeNode root) {
    	if(root == null) return;
        preorder(root);
        
        TreeNode node = preorderList.remove(0);
        while(!preorderList.isEmpty()) {
        	node.left = null;
        	node.right = preorderList.remove(0);
        	node = node.right;
        }
    }
    
    TreeNode last = null;
    public void flatten(TreeNode root) {
    	if(root == null) return;
    	flatten(root.right);
    	flatten(root.left);
    	root.right = last;
    	root.left = null;
    	last = root;
    }
}
