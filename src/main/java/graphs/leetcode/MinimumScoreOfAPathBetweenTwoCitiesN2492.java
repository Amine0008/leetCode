package graphs.leetcode;

import java.util.*;

public class MinimumScoreOfAPathBetweenTwoCitiesN2492 {

    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph  = new ArrayList[n+1];
        for(int[] road: roads){
            if(graph[road[0]] == null)
                graph[road[0]] = new ArrayList<>();
            if(graph[road[1]] == null)
                graph[road[1]] = new ArrayList<>();

            graph[road[0]].add(new int[]{road[1],road[2]});
            graph[road[1]].add(new int[]{road[0],road[2]});

        }
        int
                waveSize,
                shortestRoad = Integer.MAX_VALUE,
                node;
        LinkedList<Integer> waveNodes = new LinkedList<>();
        waveNodes.add(1);
        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(1);
        while(!waveNodes.isEmpty()){
            waveSize = waveNodes.size();
            for(int i = 0; i < waveSize; i++){
                node = waveNodes.removeFirst();
                for(int[] nb : graph[node]){
                    if(shortestRoad > nb[1])
                        shortestRoad = nb[1];
                    if(visitedNodes.contains(nb[0]))
                        continue;
                    visitedNodes.add(nb[0]);
                    waveNodes.add(nb[0]);
                }
            }
        }
        return shortestRoad;


    }


}
