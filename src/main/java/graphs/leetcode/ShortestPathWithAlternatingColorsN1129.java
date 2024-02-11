package graphs.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ShortestPathWithAlternatingColorsN1129 {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        int[][] graph = new int[n][n];
        for(int[] arr: graph){
            Arrays.fill(arr,-1);
        }
        int[] shortestPathLength = new int[n];
        Arrays.fill(shortestPathLength, -1);
        shortestPathLength[0] = 0;

        // 0 -> blue
        // 1 -> red
        // 2 -> both

        for(int[] redEdge: redEdges){
            graph[redEdge[0]][redEdge[1]] = 1;
        }
        for(int[] blueEdge: blueEdges){
            if(graph[blueEdge[0]][blueEdge[1]] > 0)
                graph[blueEdge[0]][blueEdge[1]] = 2;
            else
                graph[blueEdge[0]][blueEdge[1]] = 0;
        }

        Set<String> visitedNodes = new HashSet<>();
        LinkedList<int[]> waveNodes = new LinkedList<>();
        waveNodes.add(new int[]{0,1});
        waveNodes.add(new int[]{0,0});
        visitedNodes.add(0+","+0);
        visitedNodes.add(0+","+1);
        int size,waveCounter = 0;
        int[] node;
        while(!waveNodes.isEmpty()){
            size = waveNodes.size();
            for(int i = 0; i < size; i++){
                node = waveNodes.removeFirst();
                if(shortestPathLength[node[0]] < 0)
                    shortestPathLength[node[0]] = waveCounter;
                if(node[1] == 0){
                    //add only red adjacent nodes to the next wave
                    for(int j = 0; j < n; j++){
                        if(graph[node[0]][j] < 0)
                            continue;
                        if(visitedNodes.contains(j+","+1))
                            continue;
                        if(graph[node[0]][j] == 1 || graph[node[0]][j] == 2){
                            waveNodes.addLast(new int[]{j,1});
                            visitedNodes.add(j+","+1);
                        }
                    }
                }
                else if(node[1] == 1){
                    //add only blue adjacent nodes to the next wave
                    for(int j = 0; j < n; j++){
                        if(graph[node[0]][j] < 0)
                            continue;
                        if(visitedNodes.contains(j+","+0))
                            continue;
                        if(graph[node[0]][j] == 0 || graph[node[0]][j] == 2){
                            waveNodes.addLast(new int[]{j,0});
                            visitedNodes.add(j+","+0);
                        }
                    }
                }
            }

            if(!waveNodes.isEmpty())
                waveCounter++;
        }




        return shortestPathLength;
    }

}
