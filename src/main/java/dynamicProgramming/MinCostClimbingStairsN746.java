package dynamicProgramming;

public class MinCostClimbingStairsN746 {
    
	public int minCostClimbingStairs(int[] cost) {
		int[] minCostTo =  new int[cost.length+1];
		minCostTo[0] = 0;
		minCostTo[1] = 0;
		for(int i = 2; i< minCostTo.length; i++) {
			minCostTo[i] = Math.min(minCostTo[i-1]+cost[i-1], minCostTo[i-2]+cost[i-2]);
		}
		return minCostTo[cost.length];
    }

}
