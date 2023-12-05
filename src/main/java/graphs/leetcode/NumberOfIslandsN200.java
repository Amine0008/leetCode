package graphs.leetcode;

public class NumberOfIslandsN200 {
	
   public int numIslands(char[][] grid) {
	   int islandCounter = 0;
	   for(int i = 0; i < grid.length; i++) {
		   for(int j = 0; j < grid[0].length; j++) {
			   if(grid[i][j] == '0' || grid[i][j] == '2')
				   continue;
			   islandCounter++;
			   bfs(grid,i, j);
			   grid[i][j] = '2';
		   }   
	   }
	   return islandCounter;
   }
   
   public void bfs(char[][] grid, int row, int column) {
	   if(row<0 
		   || column<0
		   ||row == grid.length 
		   || column == grid[0].length 
		   || grid[row][column] == '0' 
		   || grid[row][column] == '2')
		   return;
	   grid[row][column] = '2';
	   bfs(grid,row-1,column);
	   bfs(grid,row+1,column);
	   bfs(grid,row,column+1);
	   bfs(grid,row,column-1);
	   
   }
   

}
