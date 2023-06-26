package arrays;


public class productExceptSelfN238 {

	
	
    public int[] productExceptSelf(int[] nums) {
         
    	int[] prefix = new int[nums.length];
    	prefix[0]= 1 ;
    	
    	int[]suffix = new int[nums.length];
    	suffix[nums.length-1] = 1; 
    	
    	for(int i = 1; i < nums.length;i++) {
    		prefix[i] = prefix[i-1] *nums[i-1];
    	}
    	
    	for(int i = nums.length-2; i >= 0; i--) {
    		suffix[i] = suffix[i+1]*nums[i+1];
    	}
    	
    	int[] result = new int[nums.length];
    	
    	for(int i = 0; i < nums.length; i++) {
    		result[i] = prefix[i]*suffix[i];
    	}
    	return result;
    }
    
    public int[] productExceptSelf2(int[] nums) {
        
    	int[] result = new int[nums.length];
    	
    	result[0] = 1;
    	
    	for(int i = 1; i<nums.length; i++ ) {
    		result[i] = nums[i-1]*result[i-1];
    	}
    	int suffixConst = 1;
    	for(int i = nums.length-2;i>=0;i--) {
    		suffixConst = suffixConst * nums[i+1];
    		result[i] = result[i] *  suffixConst;
    	}
    	
    	return result;
    }
    
    
    
    
    
}
