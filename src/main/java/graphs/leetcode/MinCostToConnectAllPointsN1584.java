package graphs.leetcode;

import java.util.*;

public class MinCostToConnectAllPointsN1584 {

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        q.add(new int[]{0,0});
        int[] node;
        Set<Integer> visited = new HashSet<>();
        int result = 0;
        while(!q.isEmpty()){
            if(visited.size() == points.length)
                return result;
            do {node = q.remove();}while(visited.contains(node[1]));
            result += node[0];
            visited.add(node[1]);
            for(int i = 0; i < points.length; i++){
                if(visited.contains(i))
                    continue;
                q.add(new int[]{cost(points[node[1]],points[i]),i});
            }


        }
        return result;


    }

    public int minCostConnectPoints3(int[][] points) {

        //iterative prim's algorithm
        Set<Integer> mst = new HashSet<>();
        Set<Integer> notInMst = new HashSet<>();
        for(int i= 1; i < points.length; i++){
            notInMst.add(i);
        }

        mst.add(0);
        int[] newNode;
        int result = 0;
        int costHolder;
        while(mst.size() != points.length){
            newNode = new int[] { Integer.MAX_VALUE,-1};
            for(Integer nodeInMst: mst){
                for(Integer i: notInMst){
                    costHolder = cost(points[nodeInMst],points[i]);
                    if(costHolder < newNode[0]) {
                        newNode[0] = costHolder;
                        newNode[1] = i;
                    }
                }
            }
            result += newNode[0];
            mst.add(newNode[1]);
            notInMst.remove(newNode[1]);
        }

        return result;
    }

    public int cost(int[] a, int[]b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}
