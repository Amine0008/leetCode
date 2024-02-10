package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AsFarFromLandAsPossibleN1162 {

	public int maxDistanceM1(int[][] grid) {
		if(invalidGrid(grid))
			return -1;
		int longestDistance = 0;
		int holder;
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if(grid[i][j] == 1)
					continue;
				holder = bfs(grid,i,j);
				if(longestDistance < holder)
					longestDistance = holder;
			}
		}
		return longestDistance;

	}
    
	public boolean invalidGrid(int[][] grid){
		boolean noLand = true;
		boolean noWater = true;
		for(int i = 0; i < grid.length; i++){
			if(!noLand && !noWater)
				return false;
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j] == 1)
					noLand = false;
				if(grid[i][j] == 0)
					noWater = false;
			}
		}
		return noLand || noWater;
	}


	public int bfs(int[][] grid, int sourceRow, int sourceColumn){
		Set<String> visitedCells = new HashSet<>();
		visitedCells.add(sourceRow+","+sourceColumn);
		int waveCounter = 0;
		LinkedList<int[]> waveNodes = new LinkedList<>();
		waveNodes.addLast(new int[]{sourceRow,sourceColumn});
		int size,r,c,nbR,nbC;
		int[] node;
		while(!waveNodes.isEmpty()){
			waveCounter++;
			size = waveNodes.size();
			for(int i = 0; i < size; i++){
				node = waveNodes.removeFirst();
				r = node[0];
				c = node[1];
				for(int[] nbNode: new int[][]{{r+1,c},{r-1,c},{r,c+1},{r,c-1}}){
					nbR = nbNode[0];
					nbC = nbNode[1];
					if(nbR < 0 || nbC < 0 || nbR == grid.length || nbC == grid.length)
						continue;
					if(visitedCells.contains(nbR+","+nbC))
						continue;
					if(grid[nbR][nbC] == 1)
						return waveCounter;
					visitedCells.add(nbR+","+nbC);
					waveNodes.add(new int[]{nbR,nbC});

				}
			}
		}
		return -1;
	}


	public int maxDistance(int[][] grid) {

		LinkedList<int[]> waveNodes = new LinkedList<>();
		int[] node;
		int size, waveCounter = 0, r, c, nbR, nbC ;
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid.length; j++){
				if(grid[i][j] == 1){
					waveNodes.add(new int[]{i,j});
				}
			}
		}

		if(waveNodes.isEmpty() || waveNodes.size() == grid.length* grid.length)
			return -1;
		while(!waveNodes.isEmpty()){
			size = waveNodes.size();
			for(int i = 0; i < size; i++){
				node  = waveNodes.removeFirst();
				r = node[0];
				c = node[1];
				for(int[] nbNode: new int[][]{{r+1,c},{r-1,c},{r,c+1},{r,c-1}}){
					nbR = nbNode[0];
					nbC = nbNode[1];
					if(nbR < 0 || nbC < 0 || nbR == grid.length || nbC == grid.length)
						continue;
					if(grid[nbR][nbC] == 1)
						continue;
					grid[nbR][nbC] = 1;
					waveNodes.addLast(new int[]{nbR,nbC});

				}
			}
			if(!waveNodes.isEmpty())
				waveCounter++;
		}
		return waveCounter;
	}










    
}
