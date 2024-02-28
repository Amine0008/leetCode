package graphs.leetcode

import java.util.LinkedList
    fun closedIsland(grid: Array<IntArray>): Int {

        var closedIslands: Int = 0;
        for( i in 1..<grid.lastIndex){
            for( j in 1..<grid[0].lastIndex){
                if(grid[i][j] != 0)
                    continue;
                if(!bfs(grid, intArrayOf(i,j)))
                    closedIslands++;
            }
        }
        return closedIslands;
    }

    fun bfs(grid: Array<IntArray>, source:IntArray): Boolean{
        var waveSize:Int = 0;
        var r:Int;
        var c:Int;
        val waveNodes = LinkedList<IntArray>();
        var waveNode = IntArray(2);
        grid[source[0]][source[1]] = 2
        waveNodes.addFirst(source);
        var islandTouchesBorder = false;
        while(!waveNodes.isEmpty()){
            waveSize = waveNodes.size;

            for( i in 1..waveSize){
                waveNode = waveNodes.removeFirst();
                r = waveNode[0];
                c = waveNode[1];
                if(!islandTouchesBorder && (r == 0 || r == grid.size-1 || c == 0 || c == grid[0].size-1))
                    islandTouchesBorder = true;
                for( adj in listOf(intArrayOf(r+1,c), intArrayOf(r-1,c), intArrayOf(r,c+1), intArrayOf(r,c-1))){
                    if(adj[0] == grid.size || adj[0] < 0 || adj[1] == grid[0].size || adj[1] < 0 || grid[adj[0]][adj[1]] != 0)
                        continue;
                    grid[adj[0]][adj[1]] = 2;
                    waveNodes.addLast(adj);

                }

            }
        }
        return islandTouchesBorder;
    }