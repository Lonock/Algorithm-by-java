package 二叉树;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.cn/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {
	private List<Integer> postorderList = new LinkedList<>(); 
	
    public List<Integer> postorder1(Node root) {
        if(root == null)  return postorderList;
    	
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while(!st1.isEmpty()) {
        	root = st1.pop();
        	st2.push(root);
        	for (int i = 0; i < root.children.size(); i++) {
        		if(root.children.get(i) != null)
        			st1.push(root.children.get(i));
			}
        }   
        while(!st2.isEmpty())
        	postorderList.add(st2.pop().val);
        
    	return postorderList;
    }
    
    public List<Integer> postorder(Node root) {
    	if(root == null)  return postorderList;
    	
    	for (int i = 0; i < root.children.size(); i++) {
			postorder(root.children.get(i));
		}
    	postorderList.add(root.val);
    	
    	return postorderList;
    }
    
}
