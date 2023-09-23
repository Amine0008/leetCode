package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
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
    
    public List<List<Integer>> subsets2(int[] nums) {
    	
    	Set<Set<Integer>> result = new HashSet<>();
    	int maxSetLength = nums.length-1;
    	Set<Integer> setOfAllElements = new HashSet<>();
    	for(int i = 0; i<nums.length;i++) {
    		setOfAllElements.add(nums[i]);
    		BT(nums[i], new HashSet<>(), maxSetLength, result, nums);
    	}
    	result.add(new HashSet<>());
    	result.add(setOfAllElements);
    	return result.stream()
    			.map(s ->s.stream().collect(Collectors.toList()))
    			.collect(Collectors.toList());
    	
    }
    
    public void BT(int i, Set<Integer> set, int maxSetLength, Set<Set<Integer>> result, int[] nums) {
    	Set<Integer> setCopy = set.stream().map(Function.identity()).collect(Collectors.toSet());
    	
    	setCopy.add(nums[i]);
    	if(!result.contains(setCopy)) {
    		result.add(setCopy);
    		return;
    	}
    	if(setCopy.size() == maxSetLength)
    		return;
    	
    	for(int j = i+1;j<nums.length; j++) {
    		if(setCopy.contains(nums[j]))
    			continue;
    		BT(nums[j], setCopy, maxSetLength, result, nums);
    	}
    }
    
    public List<List<Integer>> subsets3(int[] nums) {
    	return createSubsets(new ArrayList<>(), nums, 0);
    }
    
    public List<List<Integer>> createSubsets(List<Integer> subSet, int[] nums, int choiceIndex) {
    	if(choiceIndex == nums.length) {
    		List<List<Integer>> r = new ArrayList<>();
    		r.add(subSet);
    		return r;
    	}
    	List<Integer> includeChoice =new ArrayList<>(subSet);
    	includeChoice.add(nums[choiceIndex]);
    	
    	List<List<Integer>> r1 =createSubsets(includeChoice, nums, choiceIndex + 1);
    	List<List<Integer>> r2 =createSubsets(new ArrayList<>(subSet), nums, choiceIndex + 1);
    	r1.addAll(r2);
    	return r1;
    	
    }
    
    
    
    public List<List<Integer>> subsets4(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	result.add(new ArrayList<>());
    	int currentSize;
    	List<Integer> holder;
    	for(int i = 0; i < nums.length; i++) {
    		currentSize = result.size();
    		for(int j = 0; j < currentSize; j++) {
    			holder = new ArrayList<>(result.get(j));
    			holder.add(nums[i]);
    			result.add(holder);
    		}
    	}
    	return result;
    }
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
