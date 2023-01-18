package 栈;

/*
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class _42_接雨水 {
    public int trap(int[] height) {
    	if(height.length < 3)
    		return 0;
    	int sum = 0;
    	int lebig = 0;
    	int ribig = 2;
		for (int j = 3; j < height.length; j++) {
			if(height[j] > height[ribig])
				ribig = j;
		}
    	for (int i = 1; i < height.length-1; i++) {
			if(i == ribig) {
				ribig = i+1;
				for (int j = i+2; j < height.length; j++) {
					if(height[j] > height[ribig])
						ribig = j;
				}
			}
//			System.out.println(height[ribig]);
//			System.out.println(height[lebig]);
			int big = height[lebig] < height[ribig] ? height[lebig] : height[ribig];
//			System.out.println(big + "big");
			if(big > height[i]) {
//				System.out.println(big+"big");
//				System.out.println(height[i]+ "i");
				sum += big - height[i];
//				System.out.println(sum+100);
			}
			if(height[i] > height[lebig])
//				System.out.println(i+20);
				lebig = i;
		}
    	
    	return sum;
    }
}
