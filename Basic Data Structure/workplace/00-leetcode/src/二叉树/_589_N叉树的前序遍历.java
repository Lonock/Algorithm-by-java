package 二叉树;
/*
 * https://leetcode.cn/problems/n-ary-tree-preorder-traversal/
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _589_N叉树的前序遍历 {
	List<Integer> preorderList = new LinkedList<>();
	
    public List<Integer> preorder1(Node root) {
    	if(root==null) return preorderList;
        
    	preorderList.add(root.val);
    	for (int i = 0; i < root.children.size(); i++) {
    		preorder(root.children.get(i));
		}
    	  
    	return preorderList;
    }
    
    public List<Integer> preorder(Node root) {
    	if(root==null) return preorderList;
        Stack<Node> preorderStack = new Stack<>();
//    	preorderList.add(root.val);
        preorderStack.push(root);
        while(!preorderStack.isEmpty()) {
        	root = preorderStack.pop();
        	preorderList.add(root.val);
        	for (int i = root.children.size() - 1; i >= 0; i--) {
        		if(root.children.get(i) != null)
        			preorderStack.push(root.children.get(i));
    		}
        }  
    	return preorderList;
    }
}
