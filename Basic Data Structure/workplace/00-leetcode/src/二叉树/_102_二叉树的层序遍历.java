package 二叉树;
/*
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/submissions/
 */
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class _102_二叉树的层序遍历 {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
    			l1.add(l3);
    			l2.clear();
    		}
    	}

    	
		return l1;
    }
}
