package backTracking;

import java.util.ArrayList;
import java.util.List;

public class NumberOfDiceRollsWithTargetSumN1155 {

	
	public static void main(String[] args) {
		System.out.print(diceComb(10));
	}
	
    public static int numRollsToTarget(int n, int k, int target) {
        return combinatorial(0,n,k,target);
    }
    
    public static int combinatorial(int currentSum, int raminingNumberOfDice, int faces, int targetSum) {
    	if(raminingNumberOfDice == 0 && currentSum != targetSum)
    		return 0;
    	else if(raminingNumberOfDice == 0 && currentSum == targetSum)
    		return 1;
    	int sum = 0;
    	int min;
    	int max;
    	max = Math.min(faces, targetSum-currentSum);
    	if(targetSum-currentSum <= faces)
    		min = targetSum-currentSum;
    	else
    		min = 1;
    	for(int i = min; i <= max; i++){
    		sum += combinatorial(currentSum+i,raminingNumberOfDice-1,faces,targetSum );
    	}
    	return (int) (sum%(Math.pow(10,9)+7  ));
    	
    }


    public static List<String> diceComb(int target){
    	List<String> results = new ArrayList<>();
    	combine("",target, results);
    	return results;
    }
    
    public static void combine(String result, int choices, List<String> results) {
    	if(choices == 0) {
    		results.add(result);
    		return;
    	}
    	for(int i = 1; i <= Math.min(6, choices); i++) {
    		combine(result+i,choices-i,results);
    	}
    }
}
