package binarySearch;

public class SplitArrayLargestSumN410 {

	
    public int splitArray(int[] nums, int k) {
        //left will hold the max element in nums
    	int left = nums[0];
    	
    	//right will hold the sum of all elements in nums
        int right = 0;
        int mid ; 
        int result = left;
        
        for(int i = 0; i<nums.length; i++) {
        	if(nums[i]>left)
        		left = nums[i];
        	right+=nums[i];
        }
        
        while(left <= right) {
        	mid = (right-left) / 2 + left;
        	if(canCreateSplitWithLSLessThanOrEqualToTarget(nums,k, mid)) {
        		right = mid - 1;
        		result = mid;
        	}
        		
        	else
        		left = mid + 1;
        }
    	
    	return result;
    }
    
    public boolean canCreateSplitWithLSLessThanOrEqualToTarget(int[] nums, int k, int targetSum) {
    	//start of next sub array
    	int sns = 0;
    	int currentSubArraySum;
    	for(int i = 1; i<=k; i++) {
    		currentSubArraySum = 0;
    		while(currentSubArraySum <= targetSum && sns < nums.length) {
    			
    			if(currentSubArraySum + nums[sns] <= targetSum) {
    				currentSubArraySum += nums[sns];
    				sns++;
    			}
    			else {
    				break;
    			}
    		}
    	}
    	if(sns == nums.length)
	    	return true;
    	else
    		 return false;
    }
    
    
}
