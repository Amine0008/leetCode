package BinarySearch;

public class SingleElementInASortedArrayN540 {

	
  public int singleNonDuplicate2(int[] nums) {
	  if(nums.length == 1)
		  return nums[0];
      int start = 0; 
      int end = nums.length - 1;
      
      while (start <= end) {
    	  if(nums[start] != nums[start + 1])
    		  return nums[start];
    	  if(nums[end] != nums[end-1])
    		  return nums[end];
    	  start++;
    	  end--;
      }
	  
	  return -1; 
    }
  public int singleNonDuplicate(int[] nums) {
	 if(nums.length == 1 )
		 return nums[0];
	  int right = nums.length - 1;
	 int left = 0;
	 int mid =0;
	 int leftCounter;
	 int rightCounter;

	 while(left <= right) {
			if(left == right ){
				return nums[left];
			}
			 
		 mid = (right-left)/2+left;
		 leftCounter = mid;
		 
		 if(mid-1>=0 && mid+1 < nums.length ) {
			 if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
				 return nums[mid];
			 }
				 
		 }
		 else {
			 if(mid-1>=0 && nums[mid-1] != nums[mid] && mid+1 >= nums.length){
				 return nums[mid];

			 }
			 if(mid+1<nums.length && nums[mid+1]!=nums[mid] && mid-1 < 0){
				 return nums[mid];

			 }
			
		 }
			 
		 
		 if( mid-1 >= 0) {
			 if(nums[mid-1] == nums[mid] && leftCounter != 0)
				 leftCounter--;
		 }


		 if(leftCounter % 2 != 0)
			 right = mid - 1;
		 else
			 left = mid + 1;
		 
	 }


	 return -1;
	 
  }
}
