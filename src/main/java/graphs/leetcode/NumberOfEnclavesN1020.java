package graphs.leetcode;


import java.util.LinkedList;
import java.util.List;

public class NumberOfEnclavesN1020 {

    public int numEnclaves(int[][] grid) {
        int cellCouter = 0;
        for(int i = 1; i < grid.length-1; i++){
            for(int j = 1; j < grid[0].length-1; j++){
                if(grid[i][j] != 1)
                    continue;
                cellCouter+=bfs(new int[]{i,j},grid);
            }
        }
        return cellCouter;
    }
    public int bfs(int[] source, int[][] grid){
        grid[source[0]][source[1]] = 2;
        int size,r,c;
        LinkedList<int[]> waveCells = new LinkedList<>();
        int[] currentCell;
        waveCells.add(source);
        int cellCounter = 0;
        boolean islandTouchesBorder = false;
        while(!waveCells.isEmpty()){
            size = waveCells.size();
            cellCounter+=size;
            for(int i = 0; i < size; i++) {
                currentCell = waveCells.removeFirst();
                r = currentCell[0];
                c = currentCell[1];
                if(!islandTouchesBorder && (r == 0 || r == grid.length-1 || c == 0 || c == grid[0].length-1))
                    islandTouchesBorder = true;

                for(int[] adj : new int[][]{{r+1,c},{r-1,c},{r,c+1},{r,c-1}}){
                    if(adj[0] < 0 || adj[0] == grid.length || adj[1] < 0 || adj[1] == grid[0].length || grid[adj[0]][adj[1]] != 1)
                        continue;
                    waveCells.addLast(adj);
                    grid[adj[0]][adj[1]] = 2;
                }
            }

        }
        return islandTouchesBorder ? 0 : cellCounter;


    }


    public int numEnclaves2(int[][] grid) {
        for(Integer i: List.of(0,grid.length-1)){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    bfs2(new int[]{i,j},grid);
            }
        }
        for(Integer j: List.of(0,grid[0].length-1)){
            for(int i =  0; i < grid.length; i++){
                if(grid[i][j] == 1)
                    bfs2(new int[]{i,j}, grid);
            }
        }
        int counter = 0;
        for(int i = 1; i < grid.length-1; i++){
            for(int j = 1; j < grid[0].length-1; j++){
                if(grid[i][j] == 1)
                    counter++;
            }
        }
        return counter;


    }

    public void bfs2(int[] source, int[][] grid){
        LinkedList<int[]> waveCells = new LinkedList<>();
        int waveSize,r,c;
        int[] cell;
        waveCells.add(source);
        grid[source[0]][source[1]] = 2;
        while(!waveCells.isEmpty()){
            waveSize = waveCells.size();
            for(int i = 0; i < waveSize; i++){
                cell  = waveCells.removeFirst();
                r = cell[0];
                c = cell[1];
                for(int[] adj: new int[][]{{r+1,c},{r-1,c},{r,c+1},{r,c-1}}){
                    if(adj[0] < 0 || adj[0] == grid.length || adj[1] < 0 || adj[1] == grid[0].length || grid[adj[0]][adj[1]] != 1)
                        continue;
                    grid[adj[0]][adj[1]] = 2 ;
                    waveCells.addLast(adj);
                }
            }

        }



    }



}
