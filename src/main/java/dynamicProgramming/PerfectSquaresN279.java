package dynamicProgramming;

public class PerfectSquaresN279 {
	
    public int numSquares(int n) {
    	int[] dp = new int[n+1];
    	for(int i = 0; i < n; i++) {
    		dp[i]= i;
    	}
    	for(int i = 1; i <= n-1; i++) {
    		if(i*i <= n)
    			dp[i*i] = 1;
    		if(dp[i] != 1)
    			continue;
    		for(int j = i+1; j <= n-1; j++) {
    			dp[j] = Math.min(dp[j], j/i*dp[i]+dp[j%i]);
    		}
    	}
    	return dp[n];
    }

}
