package dynamicProgramming;

public class CountWaysToBuildGoodStringsN2466 {
	
    public int countGoodStrings(int low, int high, int zero, int one) {
    	
    	int[] dp = new int[high + 1];
    	dp[zero] = 1;
    	dp[one] += 1;
    	int sumOfGoodStrings = 0;
    	for(int i = 1; i < dp.length; i++) {
    		if(i+zero <= high)
    			dp[i+zero] = (dp[i+zero]+dp[i])% 1000000007;
    		if(i+one <= high)
    			dp[i+one] = (dp[i+one]+dp[i])% 1000000007;
    		if(i>= low && i<= high) 
    			sumOfGoodStrings = (sumOfGoodStrings + dp[i])% 1000000007;
    	}
    	return sumOfGoodStrings;
    }

}
