package ArraysAndHashing;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class RemoveDuplicatesFromSortedArrayN26 {
	
	public static void main(String[] args) {
	}
	
    public int removeDuplicatesN1(int[] nums) {
    	HashMap<Integer,Object> uniqueElements = new HashMap<>();
    	Queue<Integer> valQue = new PriorityQueue<>();
    	for(int i = 0; i<nums.length;i++) {
    		if(!uniqueElements.containsKey(nums[i])) {
    			uniqueElements.put(nums[i], null);
    			valQue.add(nums[i]);
    		}
		}
    	int k = valQue.size();
    	for(int i = 0; i < k; i++) {
    		nums[i] = valQue.remove();
    	}
    	return k;
    }
    
    public int removeDuplicatesN2(int[] nums) {
    	int k = 0;
    	int counter = 0;
    	
    	while(counter < nums.length) {
    		nums[k] = nums[counter];
    		k++;
    		for(int i = counter+1; i< nums.length;i++) {
    			if(nums[i] == nums[counter])
    					counter ++;
    			else
    				break;
    		}
    		counter++;
    	}
    	return k;
    }
    
    public int removeDuplicatesN3(int[] nums) {
    	int k = 1;
    	
    	for(int i = 1; i < nums.length; i++) {
    		if(nums[i]== nums[i-1])
    			continue;
    		else {
    			nums[k] = nums[i];
    			k++;
    		}
    	}
    	
    	
    	return k;
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
