package graphs.leetcode;

import java.util.ArrayList;
import java.util.List;

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
	
	
	
	
	
	
    
    
}
