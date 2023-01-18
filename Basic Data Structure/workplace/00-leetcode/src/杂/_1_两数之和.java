package 杂;
/*
 * https://leetcode-cn.com/problems/two-sum/
 */

public class _1_两数之和 {
    public int[] twoSum(int[] nums, int target) {
    	int[] ret = new int[2];
    	for (int i = 0; i < nums.length; i++) {
    		if(nums[i] > target)
    			continue;
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j] > target)
	    			continue;
				if(target == (nums[i]+nums[j])) {
					ret[0] = i;
					ret[1] = j;
					return ret;
				}
			}
		}
    	return ret;
    }
}
