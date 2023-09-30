package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2N40 {
	
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    	Arrays.sort(candidates);
    	List<List<Integer>> result = new ArrayList<>();
    	backtracking(new ArrayList<>(), 0, 0, candidates, target, result);
    	return result;
    }
    	
    public void backtracking(
    		List<Integer> des,
    		int currentSum, 
    		int currentIndex, 
    		int[] candidates, 
    		int target,
    		List<List<Integer>> result) 
    {
    	
    	if(currentSum == target) { 
    		result.add(new ArrayList<>(des));
    		return;
    	}
    	if(currentIndex == candidates.length || currentSum > target)
    		return; 
    	
    	des.add(candidates[currentIndex]);
    	
    	backtracking(des, currentSum + candidates[currentIndex], currentIndex + 1, candidates, target, result);
    	
    	des.remove(des.size() - 1);
    	int newchoiceIndex = currentIndex+1;
    	while(newchoiceIndex < candidates.length && candidates[newchoiceIndex] == candidates[currentIndex]) {
    		newchoiceIndex++;
    	}
    	if(newchoiceIndex == candidates.length)
    		return;
    	backtracking(des, currentSum, newchoiceIndex, candidates, target, result);
    	
    }

}
