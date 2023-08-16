package BinarySearch;

public class BinarySearchN704 {

	
	public int search(int[] nums, int target) {
		
		int startIndex = 0; 
		int endIndex = nums.length-1;
		int midIndex;
		
		while(startIndex<=endIndex) {
			midIndex = (endIndex-startIndex)/2+startIndex;
			if(nums[midIndex] == target)
				return midIndex;
			if(nums[midIndex] > target)
				endIndex = midIndex-1;
			else
				startIndex = midIndex+1;
		}
		return -1;
	}
}
