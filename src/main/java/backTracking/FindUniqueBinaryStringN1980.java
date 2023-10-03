package backTracking;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryStringN1980 {
	
    public String findDifferentBinaryString(String[] nums) {
    	Set<String> set = new HashSet<>();
    	for(String x: nums) {
    		set.add(x);
    	}
    	
    	return dfs(nums.length,set,"");
    }
    
    public String dfs(int targetLength, Set<String> set, String s) {
    	if(s.length() > targetLength)
    		return null;
    	if(s.length() == targetLength) {
    		if(set.contains(s))
    			return null;
    		else
    			return s;
    	}
    	String result = dfs(targetLength, set, s+"0");
    	if(result != null)
    		return result;
    	result = dfs(targetLength, set, s+"1");
    	return result;
    }

}
