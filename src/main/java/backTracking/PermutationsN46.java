package backTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsN46 {
    public List<List<Integer>> permute(int[] nums) {
    	return permutations(new ArrayList<>(),nums,new HashSet<>());
    }	
    
    public List<List<Integer>> permutations(List<Integer> perm, int[] nums, Set<Integer> permIndices){
    	List<List<Integer>> p;
    	if(perm.size() == nums.length) {
    		p = new ArrayList<>();
    		p.add(perm);
    		return p;
    	}
    	p = new ArrayList<>();
    	List<Integer> holder;
    	Set<Integer> setHolder;
    	List<List<Integer>> result = new ArrayList<>();
    	for(int i = 0; i < nums.length; i++) {
    		if(permIndices.contains(i))
    			continue;
    		holder = new ArrayList<>(perm);
    		holder.add(nums[i]);
    		setHolder = new HashSet<>(permIndices);
    		setHolder.add(i);
    		result.addAll(
    				permutations(holder, nums, setHolder));
    		
    	}
    	return result;
    		
    }

    
    public List<List<Integer>> permute2(int[] nums) {
        return permutations2(new ArrayList<>(),nums,0);
    }
    
    public List<List<Integer>> permutations2(List<Integer> list, int[] nums, int choiceIndex){
    	List<List<Integer>> result = new ArrayList<>();
    	if(choiceIndex == nums.length) {
    		result.add(list);
    		return result;
    	}
    	List<List<Integer>> holder;
    	
    	for(int i = 0; i < list.size() + 1; i++) {
    		List<Integer> copy = new ArrayList<>(list);
    		List<Integer> left = new ArrayList<>(copy.subList(0, i));

    		List<Integer> right = new ArrayList<>(copy.subList(i,copy.size()));
    		left.add(nums[choiceIndex]);
    		left.addAll(right);
    		holder = permutations2(left,nums,choiceIndex+1);
    		result.addAll(holder);
    	}
    	return result;
    }
    
    
    public List<List<Integer>> permute3(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
    	permutations3(result, new ArrayList<>(), nums,0);
    	return result; 
    }
    
    public void permutations3(List<List<Integer>> result, List<Integer> list, int[] nums, int choiceIndex) {
    	if(choiceIndex == nums.length) {
    		result.add(list);
    		return;
    	}
    	for(int i = 0; i < list.size()+1;i++) {
    		List<Integer> left = new ArrayList<>(list.subList(0, i));
    		List<Integer> right = new ArrayList<>(list.subList(i,list.size()));
    		left.add(nums[choiceIndex]);
    		left.addAll(right);
    		permutations3(result,left,nums,choiceIndex+1);
    	}
    	
    }

    
    
    
    
}
