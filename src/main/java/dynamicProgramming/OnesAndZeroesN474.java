package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class OnesAndZeroesN474 {
	
    public int findMaxForm(String[] strs, int m, int n) {
    	Map<String, Integer> memo = new HashMap<>();
    	return dfs(0, memo, strs,m,n,0);
       
    }
    
    int dfs(int size,Map<String, Integer> memo , String[] strs, int rz, int ro, int index) {
    	if(rz<0 || ro <0)
    		return -1;

    	String key = index+",L:"+rz+",R"+ro;
    	if(memo.containsKey(key))
    		return memo.get(key);
    	if(index == strs.length || (rz == 0 && ro == 0))
    		memo.put(key, size);
    	
    	else {
	    	int[] vals = parseBinaryString(strs[index]);
	    	int left = 1+dfs(0, memo, strs, rz-vals[1], ro-vals[0], index+1);
	    	int right = dfs(0, memo, strs, rz, ro, index+1);
	    	memo.put(key, Math.max(left, right)+size);
	    }
    	return memo.get(key);
    }
    
    public int[] parseBinaryString(String str) {
    	int[] result = new int[2];
    	for(int i = 0; i < str.length();i++) {
    		if(str.charAt(i)=='1')
    			result[0] = result[0]+1;
    		else
    			result[1] = result[1]+1;
    	}
    	return result;
    }

}
