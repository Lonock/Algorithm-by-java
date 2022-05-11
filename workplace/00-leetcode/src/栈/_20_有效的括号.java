package 栈;
import java.util.HashMap;
import java.util.Stack;
/*
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {
//	private HashMap<String,String> map = new HashMap<>();
	
	
    public boolean isValid(String s) {
    	Stack<String> st = new Stack<String>();
    	for(int i = 0; i < s.length(); i++) {	
    		String c = s.substring(i,i+1);
    		if(c.equals("(") || c.equals("{") || c.equals("[")) {//如果是左括号，入栈
    			st.push(c);
    			continue;
    		}
    		if(c.equals(")") || c.equals("}") || c.equals("]")) {//如果是右括号，匹配
    			if(st.empty())
    				return false;
	    		if(c.equals(")")) {
	    			if(!st.pop().equals("("))
	    				return false;
	    		}else if(c.equals("}")) {
	    			if(!st.pop().equals("{"))
	    				return false;
	    		}else if(c.equals("]")) {
	    			if(!st.pop().equals("["))
	    				return false;
	    		}
    		}
    	}
    	if(st.isEmpty())
    		return true;
    	return false;
    }
}
