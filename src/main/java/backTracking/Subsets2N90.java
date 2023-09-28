package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2N90 {
	
    public List<List<Integer>> subsetsWithDup(int[] nums) {
    	Arrays.sort(nums);
    	List<List<Integer>> result = new ArrayList<>();
    	backtracking(new ArrayList<>(), nums, 0, result);
    	return result;
    }
    
    public void backtracking(List<Integer> subset, int[] nums, int choiceIndex,  List<List<Integer>> results) {
    	if(choiceIndex == nums.length) {
    		results.add(new ArrayList<>(subset));
    		return;
    	}
    	subset.add(nums[choiceIndex]);
    	backtracking(subset, nums, choiceIndex + 1, results);
    	
    	subset.remove(subset.size()-1);
    	int newChoiceIndex = choiceIndex+1;
    	while(newChoiceIndex < nums.length && nums[choiceIndex] == nums[newChoiceIndex]) {
    			newChoiceIndex++;
    	}
    	backtracking(subset, nums, newChoiceIndex, results);
    }
    
    

}
