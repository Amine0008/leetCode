package graphs.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindClosestNodeToGivenTwoNodesN2359 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dist1 = createDistanceArray(edges,node1);
        int[] dist2 = createDistanceArray(edges, node2);
        int index = -1;
        int distance = Integer.MAX_VALUE;
        for(int i = 0; i < edges.length; i++){
            if(dist1[i]<0 || dist2[i] <0)
                continue;
            if(Math.max(dist1[i],dist2[i]) < distance){
                index = i;
                distance = Math.max(dist1[i],dist2[i]);
            }
        }
        return index;

    }

    public int[] createDistanceArray(int[] edges, int source) {
        Set<Integer> visitedNodes = new HashSet<>();
        visitedNodes.add(source);
        int waveCounter = 0;
        int currentNode = source;
        int[] distances = new int[edges.length];
        Arrays.fill(distances,-1);
        distances[source] = 0;
        while(currentNode >= 0){
            currentNode = edges[currentNode];
            if( currentNode < 0 || visitedNodes.contains(currentNode))
                return distances;
            visitedNodes.add(currentNode);
            waveCounter++;
            distances[currentNode] = waveCounter;
        }
        return distances;
    }

}
