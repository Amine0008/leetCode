package dynamicProgramming;

import java.util.Arrays;

public class MinCostClimbingStairsN746 {
    
	//technique#2 (looking backwards)
	public int minCostClimbingStairs(int[] cost) {
		int[] minCostTo =  new int[cost.length+1];
		minCostTo[0] = 0;
		minCostTo[1] = 0;
		for(int i = 2; i< minCostTo.length; i++) {
			minCostTo[i] = Math.min(minCostTo[i-1]+cost[i-1], minCostTo[i-2]+cost[i-2]);
		}
		return minCostTo[cost.length];
    }
	
	//technique#1 (looking forward)
	public int minCostClimbingStairs2(int[] cost) {
		
		int[] minCostTo = new int[cost.length + 1];
		Arrays.fill(minCostTo, Integer.MAX_VALUE);
		minCostTo[0] = 0;
		minCostTo[1] = 0;
		
		for(int i = 0; i < minCostTo.length - 2; i++) {
			if(minCostTo[i]+cost[i] < minCostTo[i+1])
				minCostTo[i+1] = minCostTo[i]+cost[i];
			
			if(minCostTo[i]+cost[i] < minCostTo[i+2])
				minCostTo[i+2] = minCostTo[i]+cost[i];
		}
		int beforeLastElementIndex = minCostTo.length-2;
		if(minCostTo[beforeLastElementIndex]+cost[beforeLastElementIndex] < minCostTo[beforeLastElementIndex+1])
			minCostTo[beforeLastElementIndex+1] = minCostTo[beforeLastElementIndex]+cost[beforeLastElementIndex];
		
		return minCostTo[cost.length];
		
	}
	

}
