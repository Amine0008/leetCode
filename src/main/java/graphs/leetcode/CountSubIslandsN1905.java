package graphs.leetcode;

public class CountSubIslandsN1905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for(int i = 0; i < grid1.length; i++) {
        	for(int j = 0; j < grid1[0].length; j++) {
        		if(grid1[i][j] == 0 && grid2[i][j] == 1)
        			floodIsland(i,j,grid2);
        	}
        }
        int islandCount = 0;
        for(int i = 0; i < grid1.length; i++) {
        	for(int j = 0; j < grid1[0].length; j++) {
        		if(grid2[i][j] == 1) {
        			islandCount += 1;
        			floodIsland(i,j,grid2);
        		}
        	}
        }
        return islandCount;
        
    }
    
    
    public void floodIsland(int row, int column, int[][] grid) {
    	if(row < 0 || row == grid.length || column < 0 
    			|| column == grid[0].length || grid[row][column] == 0)
    		return ;
    	grid[row][column] = 0;
    	floodIsland(row+1,column,grid);
    	floodIsland(row-1,column,grid);
    	floodIsland(row,column+1,grid);
    	floodIsland(row,column-1,grid);
    }

}
