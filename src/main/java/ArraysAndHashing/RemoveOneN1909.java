package ArraysAndHashing;

public class RemoveOneN1909 {

	public static void main(String[] args) {
	
	}
	
    public boolean canBeIncreasing(int[] nums) {
    	if(isStrictlyIncreasing(nums,-1) == true)
    		return true;
        for(int i =0;i<nums.length;i++) {
        	if(isStrictlyIncreasing(nums,i) == true)
        		return true;
        }
    	return false;
    }
    
	public boolean isStrictlyIncreasing(int[] nums,int indexToRemove) {
		for(int i = 0; i < nums.length-1; i++) {
			if(i == indexToRemove)
				continue;
			if(i+1 == indexToRemove && indexToRemove == nums.length-1)
				continue;
			if(i+1 == indexToRemove && indexToRemove < nums.length-1) {
				if(nums[i] >= nums[i+2])
					return false;
			}
			
			else if(nums[i] >= nums[i+1])
				return false;
		}
	    	return true;
    }
	
    public boolean canBeIncreasing2(int[] nums) {
    	return false;
    }
	
	
	

}
