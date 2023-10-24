package dynamicProgramming;

public class LongestPalindromicSubsequenceN516 {
	
    public int longestPalindromeSubseq(String s) {
     int[][] dp = new int[s.length()][s.length()];
     int holder;
     int result = 0;
     for(int j = s.length()-1; j >= 0; j--) {
    	 for(int i = j; i < s.length(); i++) {
    		 if(i==j) {
    			 dp[i][j] = 1;
    		 }
    		 else {
	    		 holder = 0;
	    		 if(s.charAt(i) == s.charAt(j)) {
	    			 for(int x = j+1; x < s.length(); x++) {
	    				 if(dp[i-1][x] == 0)
	    					 break;
	    				 if(dp[i-1][x] > holder)
	    					 holder = dp[i-1][x];
	    			 }
	    			 holder+=2;
	    		 }
	    		 dp[i][j] = Math.max(dp[i-1][j], holder);
    		 }
    		 if(i == s.length() - 1 && dp[i][j] > result)
    			 result = dp[i][j];
    	 }
     }
     return result;
    }

}
