package dynamicProgramming;

public class IntegerBreakN343 {
	
	public static void main(String[] args) {
		IntegerBreakN343 x = new IntegerBreakN343();
		x.integerBreak(6);
	}
	
    public int integerBreak(int n) {
	   	if(n<3)
	   		return 1;
	   	int[] dp = new int[n+1];
	   	dp[0] = 1;
	   	dp[1] = 1;
	   	dp[2] = 1;
	   	
	   	int maxHolder;
	   	int holder;
	   	for(int i = 3; i < n+1; i++) {
	   		maxHolder = 0;
	   		for(int j = i-1; j > 1; j--) {
	   			holder =  Math.max(Math.max(Math.max(j* (i/j), i/j * dp[j]),(int)Math.pow(Math.max(dp[j],j), i/j) ),(int)Math.pow(Math.max(dp[i/j],i/j),j))* Math.max(i%j, dp[i%j]);
	   			if(holder > maxHolder)
	   				maxHolder = holder;
	   		}
	   		dp[i] = maxHolder;
	   	}
	   	return dp[n];
   }

}
