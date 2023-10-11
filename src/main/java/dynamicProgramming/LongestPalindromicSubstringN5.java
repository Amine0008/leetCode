package dynamicProgramming;

public class LongestPalindromicSubstringN5 {
	
    public String longestPalindrome(String s) {
    	String[] dp = new String[s.length()];
    	dp[0] = s.substring(0,1);
    	
    	for(int i = 1; i < s.length(); i++) {
    		dp[i] = dp[i-1];
    		for(int j = i - dp[i].length(); j >=0; j--) {
    			if(isPalindrome(s.substring(j,i+1))) {
    				dp[i] = s.substring(j, i+1);
    				break;
    			}
    		}
    	}
    	return dp[dp.length - 1];
    }
    public boolean isPalindrome(String s) {
    	int i = 0; int j = s.length() - 1;
    	while(i<j) {
    		if(s.charAt(i)!=s.charAt(j))
    			return false;
			i++;
			j--;
    	}
    	return true;
    }

    
    public String longestPalindrome2(String s) {
    	String clps = ""+s.charAt(0);
    	int x;
    	int y;
    	for(int i = 0; i < s.length(); i++) {
    		x = i-1;
    		y = i+1;
    		while(x >= 0 && y < s.length()) {
    			if(s.charAt(x) == s.charAt(y) && y-x+1>clps.length())
    				clps = s.substring(x,y+1);
    			if(s.charAt(x) != s.charAt(y))
    				break;
    			y++;
    			x--;
    		}
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    		x = i;
    		y = i+1;
    		while(x >= 0 && y < s.length()) {
    			if(s.charAt(x) == s.charAt(y) && y-x+1>clps.length())
    				clps = s.substring(x,y+1);
    			if(s.charAt(x) != s.charAt(y))
    				break;
    			y++;
    			x--;
    		}
    	}
    	return clps;
    	
    }

}
