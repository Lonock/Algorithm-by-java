package 栈;
import java.util.Stack;

/*
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */
public class _856_括号的分数 {
    public int scoreOfParentheses(String s) {
    	Stack<String> st = new Stack<String>();
    	int sum = 0;
    	boolean mark = false;
    	for(int i = 0; i < s.length(); i++) {
    		String c = s.substring(i,i+1);
    		if(c.equals("(")) {
    			st.push(c);
    			mark = true;
    		}else if(c.equals(")")) {
    			if(mark) {
    			sum += Math.pow(2,st.size() - 1);
    			st.pop();
    			mark = false;
    			}else
    				st.pop();
    		}
    	}
    	
    	return sum;
    }
}
