package 栈;
import java.util.Stack;

/*/
 * https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */
public class _150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
    	Stack<Integer> st = new Stack<Integer>();
    	int num1 = 0;
    	int num2 = 0;
    	for(String s:tokens) {
    		if(s.equals("+")) {
    			num1 = st.pop();
    			num2 = st.pop();
    			st.push(num2 + num1);
    		}else if(s.equals("-")) {
    			num1 = st.pop();
    			num2 = st.pop();
    			st.push(num2 - num1);
    		}else if(s.equals("*")) {
    			num1 = st.pop();
    			num2 = st.pop();
    			st.push(num2 * num1);
    		}else if(s.equals("/")) {
    			num1 = st.pop();
    			num2 = st.pop();
    			st.push(num2 / num1);
    		}else
    			st.push(Integer.parseInt(s));
    	}
    	
    	return st.peek();
    }
}
