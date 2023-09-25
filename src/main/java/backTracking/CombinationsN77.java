package backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationsN77 {

    public List<List<Integer>> combine(int n, int k) {
    	return backtracking(new ArrayList<>(), 1, n, k);
    }
    
    public List<List<Integer>> backtracking(List<Integer> combination, int min, int max, int combinationLength){
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if(combination.size() == combinationLength) {
    		result.add(new ArrayList<>(combination));
    		return result;
    	}
    	if(min > max)
    		return result;
    	combination.add(min);
    	List<List<Integer>> first =  backtracking(combination, min+1, max, combinationLength);
    	combination.remove(combination.size()-1);
    	List<List<Integer>> second =backtracking(combination, min+1, max, combinationLength);
    	
    	result.addAll(first);
    	result.addAll(second);
    	return result;
    }
    
    
}
