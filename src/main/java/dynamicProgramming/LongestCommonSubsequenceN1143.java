package dynamicProgramming;

import java.util.Arrays;

public class LongestCommonSubsequenceN1143 {

	public static void main(String[] args) {
		LongestCommonSubsequenceN1143 x = new LongestCommonSubsequenceN1143();
		x.longestCommonSubsequence("bsbininm","jmjkbkjkv");
	}
	
   public int longestCommonSubsequence(String text1, String text2) {

	   int[][] dp = new int[text1.length()][text2.length()];

	   if(text2.charAt(0) == text1.charAt(0))
		   dp[0][0] = 1;
	   else
		   dp[0][0] = 0;
        for(int i = 1; i < dp[0].length; i++) {
        	dp[0][i] = Math.max(dp[0][i-1], text2.charAt(i)==text1.charAt(0) ? 1:0);
        }
        for(int i = 1; i < text1.length(); i++) {
        	dp[i][0] = Math.max(dp[i-1][0], text1.charAt(i) == text2.charAt(0) ?1:0);
        }
        
        for(int j = 1; j < text2.length(); j++) {
        	for(int i = 1; i < text1.length(); i++) {
        		int currentMax = Math.max(dp[i-1][j], dp[i][j-1]);
        		
    			if(text2.charAt(j) == text1.charAt(i) && (1+dp[i-1][j-1])>currentMax)
    				currentMax = 1+dp[i-1][j-1];
        		dp[i][j] = currentMax;
        	}
        }
        return dp[text1.length()-1][text2.length()-1];
   }
   
   
   
   
   
   
   

}
