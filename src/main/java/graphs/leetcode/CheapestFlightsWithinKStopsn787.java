package graphs.leetcode;

import java.util.*;

public class CheapestFlightsWithinKStopsn787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k = k+2;
        Map<Integer,List<int[]>> adjList = new HashMap<>();

        for(int[] edge: flights){
            if(!adjList.containsKey(edge[0]))
                adjList.put(edge[0], new ArrayList<>());
            if(!adjList.containsKey(edge[1]))
                adjList.put(edge[1], new ArrayList<>());

            adjList.get(edge[0]).add(new int[]{edge[1],edge[2]});
        }

        Map<String,Integer> visitedEdgesWithNodeCounter = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{src,0,1});
        int[] currentEntry;
        int[] holder;
        while(!pq.isEmpty()){
            currentEntry = pq.poll();
            if(currentEntry[0] == dst)
                return currentEntry[1];
            /*if(currentEntry[0] != dst && currentEntry[2] >= k)
                continue;*/
            if(adjList.containsKey(currentEntry[0])){
                for(int[] edge: adjList.get(currentEntry[0])){
                    if(edge[0] != dst && currentEntry[2]+1 >= k)
                        continue;
                    if(visitedEdgesWithNodeCounter.containsKey(currentEntry[0]+","+edge[0])
                        && visitedEdgesWithNodeCounter.get(currentEntry[0]+","+edge[0])<= currentEntry[2]+1)
                        continue;
                    holder = new int[]{edge[0], currentEntry[1]+edge[1],currentEntry[2]+1};

                    pq.add(holder);
                    visitedEdgesWithNodeCounter.put(currentEntry[0]+","+edge[0],currentEntry[2]+1);
                }
            }

        }
        return -1;

    }



}
