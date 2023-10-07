package backTracking;

import java.util.Arrays;
import java.util.Collections;

public class PartitionToKEqualSumSubsetsN698 {
	
    public boolean canPartitionKSubsets(int[] nums, int k) {
    	//Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
    	//Arrays.sort(arr,Collections.reverseOrder());
    	Arrays.sort(nums);
		int sum = 0;
    	for(int i = 0; i < nums.length; i++) {
    		sum+=nums[i];
    	}
    	if(sum % k != 0)
    		return false;
    		
    		
    	int[] subsetsSum = new int[k];
    	return backtracking(sum/k,k,subsetsSum,nums,0);
    }
    
    public boolean backtracking(int targetSetSum, int subsetsLeft , int[] subsetsSum, int[] nums, int choiceIndex) {
    	if(subsetsLeft == 0)
    		return true;
    	if(choiceIndex == nums.length)
    		return false;
    	boolean result = false;
    	for(int i = 0; i < subsetsSum.length; i++) {
    		if(nums[choiceIndex] > targetSetSum) {
    			result = backtracking(targetSetSum, subsetsLeft, subsetsSum, nums, choiceIndex + 1);
    			if(result)
    				return true;
    		}
    		else {
    			if(subsetsSum[i] + nums[choiceIndex] == targetSetSum) {
    				subsetsSum[i] = subsetsSum[i] + nums[choiceIndex];
    				result =  backtracking(targetSetSum, subsetsLeft - 1, subsetsSum, nums, choiceIndex + 1);
    				subsetsSum[i] = subsetsSum[i] - nums[choiceIndex];
    				if(result)
    					return true;
    			}
    			else if(subsetsSum[i] + nums[choiceIndex] > targetSetSum) {
    				break;
    			}
    			else {
    				subsetsSum[i] = subsetsSum[i] + nums[choiceIndex];
    				result = backtracking(targetSetSum, subsetsLeft, subsetsSum, nums, choiceIndex + 1);
    				subsetsSum[i] = subsetsSum[i] - nums[choiceIndex];
    				if(result)
    					return true;
    			}
    		}
    	}
    	return false;
    }

}
