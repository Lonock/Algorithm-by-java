package 队列;
import java.util.*;
/*
 * 
 */
public class _225_用队列实现栈 {
	Queue<Integer> list1;
	Queue<Integer> list2;
    public _225_用队列实现栈() {
    	list1 = new LinkedList<>(); 
    	list2 = new LinkedList<>(); 
    }
    
    public void push(int x) {
    	list1.offer(x);
    	while(!list2.isEmpty())
    		list1.offer(list2.remove());
    	Queue<Integer> tmp = list2;
    	list2 = list1;
    	list1 = tmp;
    }
    
    public int pop() {
    	return list2.remove();
    }
    
    public int top() {
    	return list2.peek();
    }
    
    public boolean empty() {
    	return list2.isEmpty();
    }
}
