package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumNumberOfVerticesToReachAllNodesN1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> result = new HashSet<>();
        for(int i = 0; i < n; i++){
            result .add(i);
        }

        for(List<Integer> edge: edges){
            result.remove(edge.get(1));
        }
        return result.stream().toList();
    }

    public List<Integer> findSmallestSetOfVertices2(int n, List<List<Integer>> edges) {
        int[] incEdge = new int[n];
        for(List<Integer> edge: edges){
            incEdge[edge.get(1)] = 1;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(incEdge[i] == 0)
                result.add(i);
        }
        return result;
    }


    }
