package 杂;
/*
 * https://leetcode-cn.com/problems/time-needed-to-buy-tickets/
 */
public class _2073_买票需要的时间 {
    public int timeRequiredToBuy(int[] tickets, int k) {
    	int sumTime = 0;
    	int times =  tickets[k];
    	for (int i = 0; i < tickets.length; i++) {
    		if(i <= k) 
    			sumTime += tickets[i] < times ? tickets[i] : times;
    		else
    			sumTime += tickets[i] < times ? tickets[i] : times - 1;
		}
    	return sumTime;
    }
}
