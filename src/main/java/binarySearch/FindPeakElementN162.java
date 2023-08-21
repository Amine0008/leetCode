package binarySearch;

public class FindPeakElementN162 {
	
    public int findPeakElement(int[] nums) {
    	int left = 0; 
    	int right = nums.length - 1;
    	int mid;
    	if(nums.length == 1)
    		return 0;
    	
    	if(nums[left]>nums[left+1])
    		return left;
    	if(nums[right]>nums[right-1])
    		return right;
    	
    	while(left <= right) {
    		mid = (right - left) / 2 + left;
    		if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
    			return mid;
    		if(nums[mid+1]>nums[mid])
    			left = mid+1;
    		else
    			right = mid-1;
    	}
    	
    	return -1;
    }

}
