package graphs.leetcode;

import java.util.*;

public class NetworDelayTimeN743 {
    
    public int networkDelayTime2(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjacentNodesOf = new HashMap<>();
        //creating the adjacency list
        for(int[] edge: times){
            if(!adjacentNodesOf.containsKey(edge[0]))
                adjacentNodesOf.put(edge[0], new ArrayList<>());
            if(!adjacentNodesOf.containsKey(edge[1]))
                adjacentNodesOf.put(edge[1], new ArrayList<>());
            adjacentNodesOf.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] currentCostOf = new int[n+1];
        Arrays.fill(currentCostOf,Integer.MAX_VALUE);
        currentCostOf[k] = 0;
        Set<Integer> visitedNodes = new HashSet<>();
        PriorityQueue<int[]> nodeCostQ = new PriorityQueue<>((a,b)->a[1]-b[1]);
        nodeCostQ.add(new int[]{k,0});
        PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
        int[] nodeWithLowestCost;
        while(!nodeCostQ.isEmpty()){
            nodeWithLowestCost = nodeCostQ.poll();
            if(visitedNodes.contains(nodeWithLowestCost[0]))
                continue;
            visitedNodes.add(nodeWithLowestCost[0]);
            result.add(nodeWithLowestCost[1]);
            currentCostOf[nodeWithLowestCost[0]] = nodeWithLowestCost[1];
            for(int[] nodeCost: adjacentNodesOf.get(nodeWithLowestCost[0])){
                if(visitedNodes.contains(nodeCost[0]))
                    continue;
                if(nodeWithLowestCost[1] + nodeCost[1] < currentCostOf[nodeCost[0]]) {
                    currentCostOf[nodeCost[0]] = nodeWithLowestCost[1] + nodeCost[1];
                    nodeCostQ.add(new int[]{nodeCost[0], currentCostOf[nodeCost[0]]});
                }
            }
        }
        if(visitedNodes.size() != n)
            return -1;
        return result.peek();

    }

}
