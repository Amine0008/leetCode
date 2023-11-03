package dynamicProgramming;

public class MaximalSquareN221 {
	public static void main(String[] args) {
		MaximalSquareN221 w = new MaximalSquareN221();
		w.maximalSquare(new char[][] {{'0','0','0','1'},
			{'1','1','0','1'},
			{'1','1','1','1'},
			{'0','1','1','1'},
			{'0','1','1','1'}});
	}
	
    public int maximalSquare(char[][] matrix2) {
    	int[][] matrix = new int[matrix2.length][matrix2[0].length];
    	for(int i = 0; i < matrix2.length; i++) {
    		for(int j =  0; j < matrix2[0].length;j++) {
    			if(matrix2[i][j] == '0')
    				matrix[i][j] = 0;
    			else
    				matrix[i][j] = 1;
    		}
    	}
    	
    	int[][] dp = new int[matrix.length][matrix[0].length];
    	
    	for(int i = 0; i < matrix.length; i++) {
    		dp[i][0] = matrix[i][0];
    	}
    	
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 1; j < matrix[0].length; j++) {
    			if(matrix[i][j] == 0)
    				dp[i][j] = 0;
    			else
    				dp[i][j] = dp[i][j-1]+1;
    		}
    	}
    	
    	int result = 0;

    	
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++) {
    			if(dp[i][j] == 0)
    				continue;
    			int maxSquareLenth = Math.min(i, j)+1;
    			int possibleSquareLenth = 1;
    			int minConsOnes = dp[i][j];
    			for(int k = 1; k < maxSquareLenth; k++) {
    				if(dp[i-k][j] == 0)
    					break;
    				if(dp[i-k][j]<possibleSquareLenth)
    					break;
    				possibleSquareLenth++;

    				if(dp[i-k][j]<minConsOnes)
    					minConsOnes = dp[i-k][j];
    				
    			}
    			int squareLenth = Math.min(minConsOnes, possibleSquareLenth);
    			if(result < squareLenth*squareLenth)
    				result = squareLenth* squareLenth;
    			
    		}
		}
    	return result;
    	
    		
    
    }

}
