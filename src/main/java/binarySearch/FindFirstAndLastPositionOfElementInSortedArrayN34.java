package binarySearch;

public class FindFirstAndLastPositionOfElementInSortedArrayN34 {
	
	
    public int[] searchRange(int[] nums, int target) {
     int[] result = new int[] {-1,-1};
     int left = 0;
     int right = nums.length-1;
     int mid;
     
     while(left<=right) {
    	 mid = (right-left)/2+left;
    	 if(nums[mid] == target) {
    		 int firstIndex = mid;
    		 int lastIndex = mid;
    		 while(firstIndex >= 0){
    			 firstIndex--;
    			 if(firstIndex != -1 && nums[firstIndex] == target)
    				 continue;
    			 else
    				 break;
    		 }
   			 if(firstIndex == -1)
				 result[0] = 0;
			 else
				 result[0] = firstIndex+1;
    		 while(lastIndex < nums.length) {
    			 lastIndex++;
    			 if(lastIndex != nums.length && nums[lastIndex] == target)
    				 continue;
    			 else
    				 break;
    		 }
				 if(lastIndex == nums.length)
					 result[1] = nums.length-1;
				 else
					 result[1] = lastIndex-1;
    		 return result;
    	 }
    	 else if(nums[mid]<target)
    		 left = mid + 1;
    	 else
    		 right = mid-1;
     }
     return result;
    }

    
   public int[] searchRange2(int[] nums, int target) {
        
	   int[] result = new int[] {-1,-1};
	   result[0] = leftRightBinarySearch(nums, target, false);
	   result[1] = leftRightBinarySearch(nums, target, true);
	   return result;
	   
	   
    }
   
   public int leftRightBinarySearch(int[] nums, int target, boolean rightOnEqual) {
	   int result = -1;
	   int left = 0;
	   int right = nums.length - 1;
	   int mid;
	   
	   while(left <= right) {
		   mid = (right-left)/2+left;
		   if(nums[mid] == target) {
			   result = mid;
			   if(rightOnEqual)
				   left = mid + 1;
			   else
				   right = mid - 1;
		   }
		   else if(nums[mid]>target)
			   		right = mid - 1;
		   else
			   left = mid + 1;
	   }
	   return result;
   }
   
   
   
   
}
