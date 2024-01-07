package graphs.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrixN1091 {
    
	public int shortestPathBinaryMatrix(int[][] grid) {
       Queue<int[]> q = new LinkedList<>();
       int wave = 1;
       
       if(grid[0][0] != 0)
    	   return -1;
       q.add(new int[] {0,0});
       List<int[]> currentWave;
       int r;
       int c;
       while(!q.isEmpty()) {
    	   currentWave = new ArrayList<>();
    	   while(!q.isEmpty()) {
    		   currentWave.add(q.poll());
    	   }
    	   for(int[] waveCell :currentWave) {
    		   r = waveCell[0];
    		   c = waveCell[1];
    		   if(r == grid.length-1 && c == grid.length-1)
    			   return wave;
    		   grid[r][c] = -1;
    		   
    		   for(int[] adjacent: new int[][] {{r+1,c},{r+1,c-1},{r+1,c+1},
    			   {r-1,c},{r-1,c+1},{r-1,c-1},{r,c+1},{r,c-1}}) {
    			   if(adjacent[0] >= 0 && adjacent[0]<grid.length
    					   &&adjacent[1]>=0 && adjacent[1]<grid.length
    					   &&grid[adjacent[0]][adjacent[1]] == 0) {
    				   q.add(adjacent);
    				   grid[adjacent[0]][adjacent[1]] = -1;
    			   }
    				   
    		   
    	   }
    	   
       }
    	   wave++;
    }
	return -1;
	
	
	
	
	
	
	
	
	}
	
	

}
