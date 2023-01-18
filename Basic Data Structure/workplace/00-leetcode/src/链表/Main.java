package 链表;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(0);
		for (int i = 1; i < 9; i++) {
			a = new ListNode(i,a);
		}
		_203_移除链表元素 b = new _203_移除链表元素();
		b.removeElements(a, 0);
//		System.out.println("test");
		
	}

}
