package graphs.leetcode;

public class IslandPerimeterN463 {
	
    public int islandPerimeter(int[][] grid) {
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			if(grid[i][j] == 1)
    				return bfs(grid,i,j);
    		}
    	}
    	return 0;
    }
    public int bfs(int[][] grid,int i, int j) {
    	if(i < 0 || i >= grid.length)
    		return 0;
    	if(j < 0 || j >= grid[0].length)
    		return 0;
    	if(grid[i][j] == -1 || grid[i][j] == 0)
    		return 0;
    	grid[i][j] = -1;
    	int contour = 0;
    	if(i == grid.length-1)
    		contour++;
    	if(i == 0)
    		contour++;
    	if(j == 0)
    		contour++;
    	if(j == grid[0].length-1)
    		contour++;
    	if(j-1 >= 0 && grid[i][j-1] == 0)
    		contour++;
    	if(j+1 < grid[0].length && grid[i][j+1] == 0)
    		contour++;
    	if(i-1 >= 0 && grid[i-1][j] == 0)
    		contour++;
    	if(i+1 < grid.length && grid[i+1][j] == 0)
    		contour++;
    	return contour+bfs(grid,i-1,j)+bfs(grid,i+1,j)+bfs(grid,i,j+1)+bfs(grid,i,j-1);
    }

}
