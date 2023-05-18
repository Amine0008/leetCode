package arrays;

import java.util.Arrays;

public class SingleNumberN136 {
	
	public static void main(String[] args) {
	}
	
    public int singleNumber(int[] nums) {
    	Arrays.sort(nums);
    	for(int i = 0 ; i < nums.length; i++) {
    		if(i==nums.length-1)
    			return nums[i];
    		if(nums[i] == nums[i+1])
    			i++;
    		else
    			return nums[i];
    	}
    	return -1;
    }
    public int singleNumber2(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
