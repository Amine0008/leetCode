package graphs.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlowN417 {
    public List<List<Integer>> pacificAtlantic2(int[][] heights) {
    	List<List<Integer>> result = new ArrayList<>();
    	String[][] dp = new String[heights.length][heights[0].length];
    	for(String[] row: dp) {
        	Arrays.fill(row, new String(""));
        }
    	for(int i = 0; i < heights[0].length;i++) {
    		dp[0][i] = dp[0][i]+"P";
    	}
    	for(int i = 1; i < heights.length;i++) {
    		dp[i][0] = dp[i][0]+"P";
    	}
    	
    	for(int i = 0; i < heights.length;i++) {
    		dp[i][heights[0].length-1] = dp[i][heights[0].length-1]+"A";
    	}
    	
    	for(int i = 0; i < heights[0].length - 1 ;i++) {
    		dp[heights.length-1][i] = dp[heights.length-1][i]+"A";
    	}
    	
        for (String[] row : dp)
        	 
        // converting each row as string
        // and then printing in a separate line
        System.out.println(Arrays.toString(row));
    
        for(int k = 0; k < Math.max(heights.length, heights[0].length);k++)  {
        	for(int i = 0; i < heights.length; i++) {
        		for(int j = 0; j < heights[0].length; j++) {
        			updateCellValue(i,j,dp,i+1,j,heights);
        			updateCellValue(i,j,dp,i-1,j,heights);
        			updateCellValue(i,j,dp,i,j+1,heights);
        			updateCellValue(i,j,dp,i,j-1,heights);
        		}		
        	}
        }

    	for(int i = 0; i < heights.length; i++) {
    		for(int j = 0; j < heights[0].length; j++) {
    			if(dp[i][j].length() == 2)
    				result.add(Arrays.asList(i,j));
    		}
		}
    	return result;
    
    
    
    }
    void updateCellValue(int currentCellRow,
    		int currentCellColumn,
    		String[][]dp,
    		int adjacentCellRow,
    		int adjacentCellColumn,
    		int[][]heights){
    	if(adjacentCellRow == dp.length ||
    			adjacentCellRow < 0 ||
    			adjacentCellColumn == dp[0].length ||
    			adjacentCellColumn<0 ||
    			heights[adjacentCellRow][adjacentCellColumn] < heights[currentCellRow][currentCellColumn])
    		return ;
    	if(dp[currentCellRow][currentCellColumn].length() > dp[adjacentCellRow][adjacentCellColumn].length()) 
    		dp[adjacentCellRow][adjacentCellColumn] = dp[currentCellRow][currentCellColumn];
    	if(dp[currentCellRow][currentCellColumn].length() < dp[adjacentCellRow][adjacentCellColumn].length()) 
    		return;
		else {
    		if(dp[adjacentCellRow][adjacentCellColumn].equals(dp[currentCellRow][currentCellColumn]))
    			return;
    		dp[adjacentCellRow][adjacentCellColumn] = "AP";
    	}
    		
    }

    
    public static void main(String[] args) {
    	int[][] heights= new int [][] {{3,4},{4,2}};
    	List<List<Integer>> result = pacificAtlantic(heights);
    	System.out.print(result);
    }
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
    	List<List<Integer>> result = new ArrayList<>();
    	String[][] oceans = new String[heights.length][heights[0].length];
    	char[][] visited = new char[heights.length][heights[0].length];
    	
    	for(String[] row: oceans) {
        	Arrays.fill(row, new String(""));
        }
    	for(int i = 0; i < heights[0].length;i++) {
    		oceans[0][i] = oceans[0][i]+"P";
    	}
    	for(int i = 1; i < heights.length;i++) {
    		oceans[i][0] = oceans[i][0]+"P";
    	}
    	
    	for(int i = 0; i < heights.length;i++) {
    		oceans[i][heights[0].length-1] = oceans[i][heights[0].length-1]+"A";
    	}
    	
    	for(int i = 0; i < heights[0].length - 1 ;i++) {
    		oceans[heights.length-1][i] = oceans[heights.length-1][i]+"A";
    	}
    	
///////////////////
    	for(int i = 0; i < heights[0].length;i++) {
    		dfs(0,i,0,i,oceans,visited,heights);
    	}
    	for(int i = 1; i < heights.length;i++) {
    		dfs(i,0,i,0,oceans,visited,heights);
    	}
    	
    	for(int i = 0; i < heights.length;i++) {
    		dfs(i,heights[0].length-1,i,heights[0].length-1,oceans,visited,heights);
    	}
    	
    	for(int i = 0; i < heights[0].length - 1 ;i++) {
    		dfs(heights.length-1,i,heights.length-1,i,oceans,visited,heights);
    	}
     	for(int i = 0; i < heights.length; i++) {
    		for(int j = 0; j < heights[0].length; j++) {
    			if(oceans[i][j].length() == 2)
    				result.add(Arrays.asList(i,j));
    		}
		}
     	return result;
    	
    }
    
    static void dfs(int parentRow, int parentColumn ,int row, int column,
    		String[][] oceans,
    		char[][] visited,
    		int[][] heights) {
    	if(row < 0 || row == oceans.length || column < 0 || column == oceans[0].length)
    		return;
    	if(visited[row][column] == 'v')
    		return;
    	if(heights[row][column] < heights[parentRow][parentColumn])
    		return;
    	if(oceans[row][column].length() > oceans[parentRow][parentColumn].length())
    		return;
    	if((row != parentRow || column != parentColumn)
    			&& oceans[row][column].length() == oceans[parentRow][parentColumn].length()
    			&& oceans[row][column].equals(oceans[parentRow][parentColumn]))
    		return;
    	visited[row][column] = 'v';
    	if(oceans[parentRow][parentColumn].length() == 2)
    		oceans[row][column] = "AP";
    	
    	else if(oceans[row][column].length() == 0)
    		oceans[row][column] = oceans[parentRow][parentColumn];
    	
    	else if(!oceans[row][column].equals(oceans[parentRow][parentColumn]))
    			oceans[row][column] = "AP";
    	
    	dfs(row,column,row+1,column,oceans,visited,heights);
    	dfs(row,column,row-1,column,oceans,visited,heights);
    	dfs(row,column,row,column+1,oceans,visited,heights);
    	dfs(row,column,row,column-1,oceans,visited,heights);
    	visited[row][column] = 'x';
    	
    	
    }
    
    
    
    
    
    
    
    
    
}
