package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakN139 {
	
	public static void  main(String[] s) {
		WordBreakN139 x = new WordBreakN139();
		List<String> dict  = new ArrayList<>();
		String[] str  = new String[] {"cats","dog","sand","and","cat"};
		
		x.wordBreak("catsandog",Arrays.asList(str));
	}
	
    public boolean wordBreak(String s, List<String> wordDict) {
	    
    	Set<String> dict = new HashSet<>();
	    for(String x: wordDict) {
	    	dict.add(x);
		}
	    boolean[] dp = new boolean[s.length()];
	    Arrays.fill(dp, false);
//	    if(dict.contains(""+s.charAt(0)))
//	    	dp[0] = true;
//	    else
//	    	dp[0] = false;
	    
	    for(int i = 0; i < dp.length; i++) {
	    	if(dict.contains(s.substring(0, i+1))) {
	    		dp[i] = true;
	    		continue;
	    	}
	    	dp[i] = false;
	    	for(int j = i-1; j >= 0; j--) {
	    		if(dp[j] && dict.contains(s.substring(j+1, i+1)) ) {
	    			dp[i] = true;
	    			break;
	    		}
	    	}
	    		
	    }
	    return dp[s.length()-1];
	    
    }

}
