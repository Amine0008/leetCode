package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsN46 {
	
	public static void main(String[] args) {
		PermutationsN46 x = new PermutationsN46();
		x.permute5(new int[] {1,2,3});
		
	}
	
	public List<List<Integer>> permute(int[] nums) {
		return permutations(new ArrayList<>(), nums, new HashSet<>());
	}

	public List<List<Integer>> permutations(List<Integer> perm, int[] nums, Set<Integer> permIndices) {
		List<List<Integer>> p;
		if (perm.size() == nums.length) {
			p = new ArrayList<>();
			p.add(perm);
			return p;
		}
		p = new ArrayList<>();
		List<Integer> holder;
		Set<Integer> setHolder;
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (permIndices.contains(i))
				continue;
			holder = new ArrayList<>(perm);
			holder.add(nums[i]);
			setHolder = new HashSet<>(permIndices);
			setHolder.add(i);
			result.addAll(permutations(holder, nums, setHolder));

		}
		return result;

	}

	public List<List<Integer>> permute2(int[] nums) {
		return permutations2(new ArrayList<>(), nums, 0);
	}

	public List<List<Integer>> permutations2(List<Integer> list, int[] nums, int choiceIndex) {
		List<List<Integer>> result = new ArrayList<>();
		if (choiceIndex == nums.length) {
			result.add(list);
			return result;
		}
		List<List<Integer>> holder;

		for (int i = 0; i < list.size() + 1; i++) {
			List<Integer> copy = new ArrayList<>(list);
			List<Integer> left = new ArrayList<>(copy.subList(0, i));

			List<Integer> right = new ArrayList<>(copy.subList(i, copy.size()));
			left.add(nums[choiceIndex]);
			left.addAll(right);
			holder = permutations2(left, nums, choiceIndex + 1);
			result.addAll(holder);
		}
		return result;
	}

	public List<List<Integer>> permute3(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permutations3(result, new ArrayList<>(), nums, 0);
		return result;
	}

	public void permutations3(List<List<Integer>> result, List<Integer> list, int[] nums, int choiceIndex) {
		if (choiceIndex == nums.length) {
			result.add(list);
			return;
		}
		for (int i = 0; i < list.size() + 1; i++) {
			List<Integer> left = new ArrayList<>(list.subList(0, i));
			List<Integer> right = new ArrayList<>(list.subList(i, list.size()));
			left.add(nums[choiceIndex]);
			left.addAll(right);
			permutations3(result, left, nums, choiceIndex + 1);
		}

	}
	
    public List<List<Integer>> permute4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
  
        backtracking(new ArrayList<>(), nums,result);
        return result;
        
    }
    
    public void backtracking(List<Integer> list, int[] choices, List<List<Integer>> result) {
    	if(list.size() == choices.length) {
    		result.add(new ArrayList<>(list));
    		return;
    	}
    	for(Integer x :choices) {
    		if(list.contains(x))
    			continue;
    		list.add(x);
    		backtracking(list,choices,result);
    		list.remove(list.size()-1);
    	}
    }
	
    public List<List<Integer>> permute5(int[] nums) {
    	if(nums.length == 1)
    		return Arrays.asList(Arrays.asList(nums[0]));
        
    	Set<Integer> set = new HashSet<>();
    	for(Integer x: nums) {
    		set.add(x);
    	}
    	return backTracking5(set);
    }
    
    public List<List<Integer>> backTracking5(Set<Integer> set){
    	List<List<Integer>> result = new ArrayList<>();
    	if(set.size() == 2) {
    		List<Integer> comb1 = new ArrayList<>();
    		for(Integer x : set) {
    			comb1.add(x);
    		}
    		result.add(comb1);
    		result.add(new ArrayList<>(Arrays.asList(comb1.get(1),comb1.get(0))));
    		return result;
    	}
    	
    	List<Integer> copy = new ArrayList<>(set);
    	List<List<Integer>> holder;
    	for(Integer x: copy) {
    		set.remove(x);
    		holder = backTracking5(set);
    		if(holder.size() != 0) {
    			List<Integer> nl;
    			for(List<Integer> l:holder) {
    				nl =  new ArrayList<>();
    				nl.add(x);
    				nl.addAll(l);
    				result.add(l);
    			}
    		}
    		set.add(x);
    	}
    	return result;
    }
	
    
    public List<List<Integer>> permute6(int[] nums) {
    	LinkedList<Integer> ll = new LinkedList<>();
    	for(int i = 0; i<nums.length; i++) {
    		ll.add(nums[i]);
    	}
    	return  backTracking6(ll);
    }
    
    public List<List<Integer>> backTracking6(LinkedList<Integer> numbers){
    	List<List<Integer>> result = new ArrayList<>();
    	if(numbers.size() == 1) {
    		result.add(numbers);
    		return result;
    	}
    	if(numbers.size() == 2) {
    		List<Integer> perm2 = new ArrayList<>(numbers);
    		int t = perm2.get(0);
    		perm2.set(0, perm2.get(1));
    		perm2.set(1, t);
    		result.add(numbers);
    		result.add(perm2);
    		return result;
    	}
    	int originalLength = numbers.size();
    	for(int i = 0; i < originalLength; i++) {
    		int removed = numbers.removeFirst();
    		List<List<Integer>> holder = backTracking6(numbers);
    		for(List<Integer> holderList: holder) {
    			List<Integer> re = new ArrayList<>();
    			re.add(removed);
    			re.addAll(holderList);
    			result.add(re);
    		}
    		numbers.add(removed);
    	}
    	return result;
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
