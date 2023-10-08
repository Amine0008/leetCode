package dynamicProgramming;

public class ClimbingStairsN70 {

    public int climbStairs(int n) {
    	if(n == 1)
    		return 1;
    	if(n == 2)
    		return 2;
        int[] stairs = new int[n];
        stairs[0] = 1;
        stairs[1] = 2;
        for(int i = 2; i < stairs.length;i++) {
        	stairs[i] = stairs[i-1]+stairs[i-2];
        }
        return stairs[stairs.length - 1];
    }
}
