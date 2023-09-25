package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class CombinationSumN39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Set<List<Integer>> result = new HashSet<>();
    	
    	LinkedList<Integer> br = new LinkedList<>();
		result.addAll(backtracking(br,0,candidates, target));
    	return result.stream().map(s->s.stream().collect(Collectors.toList())).collect(Collectors.toList());
    }
    
    public Set<List<Integer>> backtracking(LinkedList<Integer> br,int currentSum, int[] candidates, int target){
    	Set<List<Integer>> result = new HashSet<>();
    	if(currentSum == target) {
    		List<Integer> holder = new ArrayList<>(br);
    		holder.sort((a,b)->a-b);
    		result.add(holder);
    		br.removeLast();
    		return result;
    	}
    	for(Integer x : candidates) {
    		if( x + currentSum <= target ) {
    			br.add(x);
    			 result.addAll(backtracking(br, currentSum+x, candidates,target));
    		}
    	}
    	if(br.size()>=1)
    		br.removeLast();

    	return result;
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return backTracking2(new ArrayList<>(), 0, candidates, target, 0);
    }
    
    public List<List<Integer>> backTracking2(List<Integer> result,
    		int currentSum,
    		int[] choices,
    		int targetSum,
    		int choicesStartIndex){

    	List<List<Integer>> r =  new ArrayList<>();
    	
    	if(currentSum == targetSum) {
    		r.add(new ArrayList<Integer>(result));
    		return r;
    	}
    	
    	if(choicesStartIndex == choices.length || currentSum + choices[choicesStartIndex] > targetSum) {
    		return new ArrayList<>();
    	}
		
    	result.add(choices[choicesStartIndex]);
    	List<List<Integer>> first = backTracking2(result, 
									    		  currentSum + choices[choicesStartIndex], 
									    		  choices, 
									    		  targetSum,
									    		  choicesStartIndex);
    	result.remove(result.size()-1);
    	
    	
    	List<List<Integer>> second = backTracking2(result, 
												   currentSum, 
												   choices, 
												   targetSum, 
												   ++choicesStartIndex);
    	 
    	r.addAll(first);
    	r.addAll(second);
    	return r;

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
