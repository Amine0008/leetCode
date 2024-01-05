package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class ShortestBridgeN934 {

	public static void main(String[] args) {
		ShortestBridgeN934 x = new ShortestBridgeN934();
		x.shortestBridge(new int[][]{{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}});
	}
	
    public int shortestBridge(int[][] grid) {
    	List<int[]> beachNodes = markIslands(grid);
    	return realBfs(beachNodes,grid);
    }
    
    
    public int realBfs(List<int[]> startingNodes,int[][] grid) {
    	Queue<int[]> q = new LinkedList<>();
    	for(int[] cell:startingNodes) {
        	q.add(cell);
    	}
    	Set<String> visitedCells = new HashSet<>();
    	
    	List<int[]> cells;
    	int wave = -1;
    	while(!q.isEmpty()) {
    		cells = new ArrayList<>();
    		while(!q.isEmpty()) {
    			cells.add(q.poll());
    		}
    		for(int[] cell:cells) {
    			visitedCells.add(cell[0]+","+cell[1]);
    			if(grid[cell[0]][cell[1]] == 1)
    				return wave;
    			int r = cell[0];
    			int c = cell[1];
    			if(!visitedCells.contains((r+1)+","+c) && cellIsValidForNextWave(r+1,c,grid))
    				q.add(new int[] {r+1,c});
    			if(!visitedCells.contains(r+","+(c+1)) && cellIsValidForNextWave(r,c+1,grid))
    				q.add(new int[] {r,c+1});
    			if(!visitedCells.contains((r-1)+","+c) && cellIsValidForNextWave(r-1,c,grid))
    				q.add(new int[] {r-1,c});
    			if(!visitedCells.contains(r+","+(c-1)) && cellIsValidForNextWave(r,c-1,grid))
    				q.add(new int[] {r,c-1});
    			
    		}
    		wave++;
    	}
    	return wave;
    	 
    }
    
    public boolean cellIsValidForNextWave(int row, int column, int[][] grid) {
    	if(row < 0 || row == grid.length)
    		return false;
    	if(column < 0 || column == grid[0].length)
    		return false;
    	if(grid[row][column] == 0 || grid[row][column] ==1 )
    		return true;
    	return true;
    	
    }

    
    public List<int[]> markIslands(int[][] grid) {
    	List<int[]> islandCells = new ArrayList<>();
    	int[]firstisland = getFirstIslandCoords(grid);
    	dfsMarkIsland(firstisland[0], firstisland[1],grid,islandCells);
    	return islandCells;
    }	
    
    public int[] getFirstIslandCoords(int[][] grid) {
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			if(grid[i][j] == 1)
    				return new int[] {i,j};
    		}
    	}
    	return new int[] {0,0};
    }
    
    public void dfsMarkIsland(int row, int column, int[][] grid,List<int[]> islandCells) {
    	grid[row][column] = 2;
    	//only add beach nodes
    	if(cellTouchesWater(row,column,grid))
    		islandCells.add(new int[] {row,column});
    	for(int[] adjCell: new int[][] { {row+1,column},{row-1,column},{row,column-1},{row,column+1}}) {
    		if(adjCell[0]>=0 && adjCell[0]<grid.length && adjCell[1]>=0 && adjCell[1]<grid[0].length
    				&& grid[adjCell[0]][adjCell[1]] == 1)
    			dfsMarkIsland(adjCell[0],adjCell[1],grid,islandCells);
    	}
	    	
    }
    public boolean cellTouchesWater(int row, int column,int[][] grid) {
    	if(row+1 < grid.length && grid[row+1][column] == 0)
    		return true;
    	if(row-1 >=0 && grid[row-1][column] == 0)
    		return true;
    	if(column+1<grid[0].length && grid[row][column+1] == 0)
    		return true;
    	if(column-1>=0 && grid[row][column-1] == 0)
    		return true;
    	return false;
    }
    
}
