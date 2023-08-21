package binarySearch;

public class SearchInsertPositionN35 {

	public static void main(String[] args) {
		
	}	
	
    public int searchInsert(int[] nums, int target) {
        int startIndex = 0; 
		int endIndex = nums.length-1;
		int midIndex=0;
		
		while(startIndex <= endIndex) {
			midIndex = (endIndex-startIndex)/2+startIndex;
			if(nums[midIndex] == target)
				return midIndex;
			if(nums[midIndex] > target)
				endIndex = midIndex-1;
			else
				startIndex = midIndex+1;
		}
		if(nums[midIndex]>target)
			if(midIndex==0)
				return 0;
			else
				return midIndex-1;
		else
			return midIndex+1;
    }
    
}
