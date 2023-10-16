package dynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class TriangleN120 {
	
	class CustomKey{
		int row;
		int column;
		public CustomKey(int row, int column){
			this.row = row;
			this.column  = column;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Objects.hash(column, row);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			CustomKey other = (CustomKey) obj;
			return column == other.column && row == other.row;
		}
		
	}
    
	public int minimumTotal2(List<List<Integer>> triangle) {
		int[] currentMin = new int[1];
		currentMin[0] = Integer.MAX_VALUE;
		
		HashMap<CustomKey,Integer> memo = new HashMap<>();
		return dfs(0,0,triangle, memo);
		
    }
	public int dfs(int row, int column, List<List<Integer>>triangle, HashMap<CustomKey,Integer> memo) {
		if(memo.containsKey(new CustomKey(row, column)))
			return memo.get(new CustomKey(row, column));
		if(row == triangle.size()) {
			return 0;
		}
		int leftPathSum =   triangle.get(row).get(column) + dfs(row+1,column, triangle, memo);
		
		
		int rightPathSum =  triangle.get(row).get(column) + dfs(row+1,column+1, triangle,memo);
	
		memo.put(new CustomKey(row, column), Math.min(leftPathSum, rightPathSum));
		return Math.min(leftPathSum, rightPathSum);
	}

    public int minimumTotal(List<List<Integer>> triangle) {
    	int[][] dp = new int[triangle.size()][triangle.size()];
    	
    	for(int i = triangle.size()-1; i >= 0; i-- ) {
    		for(int j = i; j >= 0; j--) {
    			if(i+1 == triangle.size()) {
    				dp[i][j] = triangle.get(i).get(j);
    				continue;
    			}
    			dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
    		}
    	}
    	return dp[0][0];
        
    }

}

