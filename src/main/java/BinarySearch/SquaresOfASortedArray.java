package BinarySearch;

public class SquaresOfASortedArray {

	   public int[] sortedSquares(int[] nums) {
	     int[] result = new int[nums.length];
	     
	     int left = 0; 
	     int right = nums.length - 1;
	     int resultIndexCounter = nums.length-1;
	     while(right > left) {
	    	 if(nums[right]*nums[right] >= nums[left]*nums[left]) {
	    		 result[resultIndexCounter] = nums[right]*nums[right];
	    		 right--;
	    	 }
	    	 else {
	    		 result[resultIndexCounter] = nums[left]*nums[left];
	    		 left++;
	    	 }
	    	 resultIndexCounter--;
	    		 
	     }
	     return result;
		   
	    }

}
