package graphs.leetcode;

import java.util.Arrays;

public class PathWithMaximumProbabilityN1514 {
    public double maxProbability(int n,
                                 int[][] edges,
                                 double[] succProb,
                                 int start_node,
                                 int end_node) {

        double[] cost = new double[n];
        Arrays.fill(cost,0);
        cost[start_node] = 1;
        int index;
        boolean aCostWasUpdated;
        for(int i = 0; i < n-1; i++) {
            index = 0;
            aCostWasUpdated = false;
            for(int[] edge: edges) {
                if(cost[edge[1]] < cost[edge[0]]*succProb[index]) {
                    cost[edge[1]] = cost[edge[0]] * succProb[index];
                    aCostWasUpdated = true;
                }
                if(cost[edge[0]] < cost[edge[1]] * succProb[index]){
                    cost[edge[0]] = cost[edge[1]] * succProb[index];
                    aCostWasUpdated = true;
                }
                index++;
            }
            if(!aCostWasUpdated)
                break;
        }
        return cost[end_node];



    }

}
