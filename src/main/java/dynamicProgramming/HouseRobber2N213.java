package dynamicProgramming;

public class HouseRobber2N213 {

	
    public int rob(int[] nums) {
    	if(nums.length == 1)
    		return nums[0];
    	if(nums.length == 2)
    		return Math.max(nums[0], nums[1]);
    	int[] alwaysRobHouse1 = new int[nums.length-1];
    	int[] alwaysDontRobHouse1 = new int[nums.length-1];
    	alwaysRobHouse1[0] = nums[0];
    	alwaysRobHouse1[1] = nums[0];
    	
    	alwaysDontRobHouse1[0] = 0;
    	alwaysDontRobHouse1[1] = nums[1];
    	
    	for(int i = 0; i < nums.length-1; i++) {
    		alwaysRobHouse1[i] = Math.max(nums[i]+alwaysRobHouse1[i-2] , alwaysRobHouse1[i-1]);
    		alwaysDontRobHouse1[i] = Math.max(nums[i]+alwaysDontRobHouse1[i-2] , alwaysDontRobHouse1[i-1]);
    	}
    	int n = nums.length-1;
    	return Math.max(nums[n]+alwaysDontRobHouse1[n-2],Math.max(alwaysDontRobHouse1[n-1], alwaysRobHouse1[n-1]));
    }
}
