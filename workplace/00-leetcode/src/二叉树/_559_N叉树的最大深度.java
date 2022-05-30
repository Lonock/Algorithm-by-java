package 二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * https://leetcode.cn/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度 {
    public int maxDepth(Node root, int maxcount) {
    	if(root == null) return maxcount;   	
    	int nowcount = maxcount;	
    	for (int i = 0; i < root.children.size(); i++) {
			int count = maxDepth(root.children.get(i), nowcount);
			maxcount = count > maxcount ? count : maxcount;
		}
    	maxcount++;
    	return maxcount;
    }
	
    public int maxDepth1(Node root) {
    	return maxDepth(root,0);
    }
    
    public int maxDepth(Node root) {
    	if(root == null) return 0;
    	int count = 0;
    	Queue<Node> floorList = new LinkedList<>();
    	floorList.offer(root);
    	int sizecount = 1;
    	while(!floorList.isEmpty()) {
    		root = floorList.poll();   		
    		for (int i = 0; i < root.children.size(); i++) {
				floorList.offer(root.children.get(i));
			}
    		
    		if(--sizecount == 0) {
    			sizecount = floorList.size();
    			count++;
    		}
    	}
    	
    	
    	return count;
    }
}
