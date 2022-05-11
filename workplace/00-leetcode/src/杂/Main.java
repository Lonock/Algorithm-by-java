package 杂;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_950_按递增顺序显示卡牌 a = new _950_按递增顺序显示卡牌();
		
		int[] b = {1,2,3,4,5,6,7,8,9};		
		b = a.deckRevealedIncreasing(b);
		for(int c : b) {
			System.out.println(c);
		}
	}

}
