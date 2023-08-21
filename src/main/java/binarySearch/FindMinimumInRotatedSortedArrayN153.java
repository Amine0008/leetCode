package binarySearch;

public class FindMinimumInRotatedSortedArrayN153 {

	
	public static void main(String[] args) {
		int[] nums = new int[] {1};
		
	//	System.out.println(findPivotIndex(nums));
	}
	
	public int findPivotIndex(int[] nums) {
		if(nums.length == 1)
			return -1;
		int left = 0;
		int right = nums.length-1;
		int mid;
		
		if(nums[0]>nums[1])
			return 0;
		if(nums[right]<nums[right-1])
			return right-1;
		
		while(left<=right) {
			mid = (right-left)/2+left;
			if(mid+1 >= nums.length || mid-1< 0)
				return - 1;
			if(nums[mid]<nums[mid-1])
				return mid-1;
			if(nums[mid]>nums[mid+1])
				return mid;
			if(nums[mid]>=nums[left])
				left = mid + 1;
			else
				right = mid - 1;
		}
		return - 1; 
	}

    public  int findMin(int[] nums) {
        int pivotIndex = findPivotIndex(nums);
        if(pivotIndex == -1)
        	return nums[0];
        return nums[pivotIndex+1];
    }
}
