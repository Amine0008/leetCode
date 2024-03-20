package graphs.leetcode;

import java.util.*;

public class SwimInRisingWaterN778 {

    public int swimInWater2(int[][] grid) {
        int[][] localMaxOfPathEndingIn = new int[grid.length][grid.length];
        for(int[] row: localMaxOfPathEndingIn){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        localMaxOfPathEndingIn[0][0] = grid[0][0];

        Set<String> visitedCells = new HashSet<>();
        visitedCells.add(0+","+0);
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        int size,r,c;
        int[] node;
        int lmOfPath;
        while(!q.isEmpty()){
            size = q.size();

            for(int i = 0; i < size; i++){
                node = q.removeFirst();
                r = node[0];
                c = node[1];

                for(int[] adj: new int[][]{{r+1,c},{r-1,c},{r,c+1},{r,c-1}}) {
                    if(adj[0] < 0 || adj[0] == grid.length || adj[1] < 0 || adj[1] == grid.length)
                        continue;
                    lmOfPath = Math.min(
                            Math.max(grid[adj[0]][adj[1]],
                                    localMaxOfPathEndingIn[node[0]][node[1]]),
                            localMaxOfPathEndingIn[adj[0]][adj[1]]);
                    if(lmOfPath < localMaxOfPathEndingIn[adj[0]][adj[1]]) {
                        q.addLast(adj);
                        localMaxOfPathEndingIn[adj[0]][adj[1]] = lmOfPath;
                    }
                }
            }
        }
        return localMaxOfPathEndingIn[grid.length-1][grid.length-1];

    }

    public int swimInWater(int[][] grid) {
        int[][] localMaxOfPathEndingIn = new int[grid.length][grid.length];
        for (int[] row : localMaxOfPathEndingIn) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        localMaxOfPathEndingIn[0][0] = grid[0][0];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        Set<String> visitedNodes = new HashSet<>();
        int[] node;
        int lmOfPath, r, c;
        while (!pq.isEmpty() && visitedNodes.size() < grid.length * grid.length) {
            node = pq.poll();
            visitedNodes.add(node[0] + "," + node[1]);
            r = node[0];
            c = node[1];
            for (int[] adj : new int[][]{{r + 1, c}, {r - 1, c}, {r, c + 1}, {r, c - 1}}) {
                if (adj[0] < 0 || adj[0] == grid.length || adj[1] < 0 || adj[1] == grid.length)
                    continue;
                if (visitedNodes.contains(adj[0] + "," + adj[1]))
                    continue;
                lmOfPath = Math.min(
                        Math.max(grid[adj[0]][adj[1]],
                                localMaxOfPathEndingIn[node[0]][node[1]]),
                        localMaxOfPathEndingIn[adj[0]][adj[1]]);
                localMaxOfPathEndingIn[adj[0]][adj[1]] = lmOfPath;
                pq.add(new int[]{adj[0], adj[1], lmOfPath});

            }
        }
        return localMaxOfPathEndingIn[grid.length - 1][grid.length - 1];
    }



}
