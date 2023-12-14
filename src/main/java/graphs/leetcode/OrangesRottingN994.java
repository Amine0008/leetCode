package graphs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrangesRottingN994 {
  public int orangesRotting2(int[][] grid) {
      int counter = 0;  
	  while(minuteLaps(grid)) {
        	counter ++;
	  }
	for(int i = 0; i < grid.length; i++) {
		for(int j = 0; j < grid[0].length; j++) {
			if(grid[i][j] == 1)
				return -1;
		}
	}
	return counter;
  }
  public boolean minuteLaps(int[][]grid) {
	  boolean orangeGoneRotten = false;
	  List<int[]> orangesToRott = new ArrayList<>();
	  for(int i = 0; i < grid.length; i++) {
		  for(int j = 0; j < grid[0].length; j++) {
			  if(grid[i][j] == 1) {
				  if(i-1 >= 0 && grid[i-1][j] == 2) {
					  orangeGoneRotten = true;
					  orangesToRott.add(new int[] {i,j});
				  }
				  else if(i+1<grid.length && grid[i+1][j] == 2){
					  orangeGoneRotten = true;
					  orangesToRott.add(new int[] {i,j});
				  }
				  else if(j+1<grid[0].length && grid[i][j+1] == 2){
					  orangeGoneRotten = true;
					  orangesToRott.add(new int[] {i,j});
				  }
				  else if(j-1>=0 && grid[i][j-1] == 2){
					  orangeGoneRotten = true;
					  orangesToRott.add(new int[] {i,j});
				  }
			  }
		  }
	  }
	  for(int[] orange: orangesToRott) {
		  grid[orange[0]][orange[1]] = 2;
	  }
	  return orangeGoneRotten;
  }

  public int orangesRotting(int[][] grid) {
	  Queue<int[]> q = new LinkedList<>();
	  for(int i = 0; i < grid.length; i++) {
		  for(int j = 0; j < grid[0].length; j++) {
			  if(grid[i][j] == 2)
				  q.add(new int[] {i,j});
		  }
	  }
	  List<int[]> cr;
	  int row;
	  int col;
	  int counter = 0;
	  while(!q.isEmpty()) {
		  cr = new ArrayList<>();
		  while(!q.isEmpty())
			  cr.add(q.poll());
		  counter++;
		  for(int[] ro: cr) {
			  row = ro[0];
			  col = ro[1];
			  if(row - 1 >= 0 && grid[row-1][col] == 1) {
				  grid[row-1][col] = 2;
				  q.add(new int[] {row-1,col});
			  }
			  if(row + 1 < grid.length && grid[row+1][col] == 1) {
				  grid[row+1][col] = 2;
				  q.add(new int[] {row+1,col});
			  }
			  if(col - 1 >= 0 && grid[row][col-1] == 1) {
				  grid[row][col-1] = 2;
				  q.add(new int[] {row,col-1});
			  }
			  if(col + 1 < grid[0].length && grid[row][col + 1] == 1) {
				  grid[row][col+1] = 2;
				  q.add(new int[] {row,col+1});
			  }
				  
		  }
	  }
	  for(int i = 0; i < grid.length; i++) {
		  for(int j = 0; j < grid[0].length; j++) {
			  if(grid[i][j] == 1)
				  return -1;
		  }
	  }
	  if(counter == 0)
		  return 0;
	  return counter-1;
	  
	  
	  
	  
	  
  }  
	
	
	
	
    
    
}
