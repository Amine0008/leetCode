package graphs.leetcode;

public class MaxAreaOfIslandN695 {
   
	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		int currentArea;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 0 || grid[i][j] == -1)
					continue;
				currentArea = bfsWithCount(i,j,grid);
				if(currentArea > maxArea)
					maxArea = currentArea;
			}
		}
		return maxArea;
    }
	public int bfsWithCount(int row, int column, int[][] grid) {
		if(row == grid.length || row < 0 || column == grid[0].length || column < 0
				|| grid[row][column] == 0 || grid[row][column] == -1)
			return 0;
		grid[row][column] = -1;
		return 1 
				+ bfsWithCount(row+1,column,grid)
				+bfsWithCount(row-1,column,grid)
				+bfsWithCount(row,column+1,grid)
				+bfsWithCount(row,column-1,grid);
	}
}
