package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MaximumAlternatingSubsequenceSumN1911 {
	
    public long maxAlternatingSum(int[] nums) {
        Map<String, Long> memo = new HashMap<>();
        return dfs(0,true,memo,nums);
    }
    
    public long dfs(int index,boolean pol, Map<String, Long> memo, int[] nums) {
    	String key = index+","+(pol?"e":"o");
    	if(memo.containsKey(key))
    		return memo.get(key);
    	if(index == nums.length) 
    		return 0;
    	
    	long left = (pol?nums[index]:(-nums[index]))+dfs(index+1, !pol, memo, nums);
    	long right = dfs(index+1, pol, memo,nums);
    	memo.put(key, Math.max(left, right));
    	return memo.get(key);
    		
    }
}
