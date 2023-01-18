package 杂;
/*
 * https://leetcode-cn.com/problems/palindrome-number/
 */
import java.util.Deque;
import java.util.LinkedList;

public class _9_回文数 {
    public boolean isPalindrome(int x) {
    	Deque<Integer> dq = new LinkedList<>();
    	if(x < 0)
    		return false;
    	for(;x > 0; x /= 10) 
    		dq.add(x%10);
    	while(dq.size() > 1)
    		if(dq.pollFirst() != dq.pollLast())
    			return false;
    	
    	return true;
    }
    
    public boolean isPalindrome2(int x) {

    	if(x < 0 || x % 10 == 0)
    		return false;
    	int renum = 0;
    	for(;x > 0; x /= 10) 
    		renum += x % 10 *10;
    	if(renum != x)
    		return false;
    	
    	return true;
    }
}
