package graphs.leetcode;

import java.util.LinkedList;

public class NumberOfClosedIslandsN1254 {
    public int closedIsland(int[][] grid) {
        int closedIslands = 0;
         boolean islandTouchesBorder;
        for(int i = 1; i < grid.length-1; i++){
            for(int j = 1; j < grid[0].length-1; j++){
                if(grid[i][j] != 0)
                    continue;
                islandTouchesBorder = bfs(new int[]{i,j},grid);
                if(!islandTouchesBorder)
                    closedIslands++;
            }
        }
        return closedIslands;
    }

    boolean bfs(int[] source, int[][] grid){
        boolean touchesBorder = false;
        int size;
        LinkedList<int[]> bfsWaves = new LinkedList<>();
        bfsWaves.add(source);
        grid[source[0]][source[1]] = 2;
        int[] cell;int r,c;
        while(!bfsWaves.isEmpty()){
            size  = bfsWaves.size();
            for(int i = 0; i < size; i++){
                cell = bfsWaves.removeFirst();
                r = cell[0];
                c = cell[1];
                for(int[] adj : new int[][]{{r,c+1},{r,c-1},{r+1,c},{r-1,c}}){
                    if(adj[0] <0 || adj[0]== grid.length || adj[1]<0 || adj[1] == grid[0].length)
                        continue;
                    if(grid[adj[0]][adj[1]] != 0)
                        continue;
                    if(!touchesBorder && (adj[0] == 0 || adj[0] == grid.length-1 || adj[1] == 0 || adj[1] == grid[0].length-1))
                        touchesBorder = true;
                    grid[adj[0]][adj[1]] = 2;
                    bfsWaves.addLast(new int[]{adj[0],adj[1]});
                }

            }
        }
        return touchesBorder;
    }

}
