package 杂;
import java.util.*;
import java.math.*;
/*
 * https://leetcode-cn.com/problems/reveal-cards-in-increasing-order/
 */
public class _950_按递增顺序显示卡牌 {
    public int[] deckRevealedIncreasing(int[] deck) {
    	Arrays.sort(deck);
    	int[] result = new int[deck.length];
    	int k = 0;
    	int h = 0;
//    	k = sqrt();
    	for(int i = 0; k < deck.length; i++) {
    		k = (int) (Math.pow(2, i) - 1);
    		for(int j = k; j < deck.length; j = j + 2 + k * 2)
    			result[j] = deck[h++];
    	}
    	return result;
    }
}
