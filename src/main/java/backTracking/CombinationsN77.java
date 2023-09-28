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

    public List<List<Integer>> combine2(int n, int k) {
    	List<List<Integer>> result = new ArrayList<>();
    	backtracking2(result, new ArrayList<>(),n,k,1);
    	return result;
    }
    
    
    public void backtracking2(List<List<Integer>> result , List<Integer> resultList, 
    		int rangeLength, 
    		int resultListLength, 
    		int rangeStarting ){
    	
    	if(resultList.size() == resultListLength) 
    		result.add(new ArrayList<>(resultList));
    	
    	for(int i = rangeStarting; i <=resultListLength-resultList.size()-1 ; i++) {
    		resultList.add(i);
    		backtracking2(result, resultList,rangeLength,resultListLength, i+1);
    		resultList.remove(resultList.size()-1);
    	}
    	
    }
    
    
    
    
    
}
