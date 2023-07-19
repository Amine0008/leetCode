package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetsN78 {

	public static void main(String[] args) {
		
		System.out.println(subsets(new int[] {1}));

	}
	
    public static List<List<Integer>> subsets(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	List<Integer> list;
    	for(int i = 1; i<nums.length;i++) {
    		backTrack(result, i,new ArrayList<>(),Arrays.stream(nums).boxed().collect(Collectors.toList()));
    	}
    	//handle single degits manually
    	 result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    	 result.add(new ArrayList<>());
    	 return result;
    	
    }
    
    public static void backTrack(
    		List<List<Integer>> result, 
    		Integer combLength, 
    		List<Integer> combSet, 
    		List<Integer> remainingDegitsForComb) {
    	
    	if(combSet.size() == combLength ) {
    		if(!result.contains(combSet))
    			result.add(combSet);
    		System.out.println(combSet);
    		return;
    	}
    	for(int i = 0; i< remainingDegitsForComb.size(); i++ ) {
    		List<Integer> newComb = new ArrayList<>();
    		newComb.addAll(combSet);
    		newComb.add(remainingDegitsForComb.get(i));
    		backTrack(result,combLength, newComb, remainingDegitsForComb.subList(i+1,remainingDegitsForComb.size()));
    	}
    	
    }
    
    
    
    
    
    

}
