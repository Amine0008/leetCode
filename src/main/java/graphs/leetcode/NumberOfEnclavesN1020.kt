package graphs.leetcode

import java.util.LinkedList

class Solution {
    fun numEnclaves(grid: Array<IntArray>): Int {
        for( i in intArrayOf(0,grid.size-1)){
            for(j in grid[0].indices){
                if(grid[i][j] == 1)
                    bfs(intArrayOf(i,j),grid);
            }
        }
        for(j in intArrayOf(0,grid[0].size-1)){
            for(i in grid.indices){
                if(grid[i][j] == 1)
                    bfs(intArrayOf(i,j),grid);
            }
        }
        var counter = 0;
        for(i in 1..<grid.size-1){
            for(j in 1..<grid[0].size-1){
                if(grid[i][j] == 1)
                    counter++;
            }
        }
        return counter;

    }

    fun bfs(source:IntArray, grid: Array<IntArray>){
        var waveSize:Int;
        var currentCell: IntArray;
        val waveCells = LinkedList<IntArray>();
        var r:Int;
        var c:Int;
        grid[source[0]][source[1]] = 2;
        waveCells.addFirst(source);

        while(!waveCells.isEmpty()){
            waveSize = waveCells.size;
            for( i in 1..waveSize){
                currentCell = waveCells.removeFirst();
                r = currentCell[0];
                c = currentCell[1];

                for(adj in listOf(intArrayOf(r+1,c), intArrayOf(r-1,c), intArrayOf(r,c+1), intArrayOf(r,c-1))){
                    if(adj[0] < 0 || adj[0] == grid.size || adj[1] < 0 || adj[1] == grid[0].size || grid[adj[0]][adj[1]] != 1)
                        continue;
                    grid[adj[0]][adj[1]] = 2;
                    waveCells.addLast(intArrayOf(adj[0],adj[1]));
                }
            }

        }


    }

}