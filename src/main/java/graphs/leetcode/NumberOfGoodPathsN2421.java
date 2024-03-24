package graphs.leetcode;

import graphs.implementation.unionFind.CollapsedUnionFind;

import java.util.*;
public class NumberOfGoodPathsN2421 {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Map<Integer,List<Integer>> valNodesMap = new HashMap<>();
        List<Integer> sortedVals;
        for(int i = 0; i < vals.length; i++) {
            if(!valNodesMap.containsKey(vals[i]))
                valNodesMap.put(vals[i], new ArrayList<>());
            valNodesMap.get(vals[i]).add(i);
        }
        for(int[] edge: edges){
            if(!adjList.containsKey(edge[0]))
                adjList.put(edge[0],new ArrayList<>());
            if(!adjList.containsKey(edge[1]))
                adjList.put(edge[1],new ArrayList<>());

            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        sortedVals = new ArrayList<>(valNodesMap.keySet());
        sortedVals.sort((a,b)->a-b);
        UnionFind uf = new UnionFind(adjList.size());
        int result = vals.length;
        List<Integer> nodes;

        for(Integer val: sortedVals){
            for(Integer nodeIndex: valNodesMap.get(val)){
                for(Integer adjIndex: adjList.getOrDefault(nodeIndex,new ArrayList<>())){
                    if(uf.find(adjIndex) != uf.find(nodeIndex) && vals[adjIndex] <= vals[nodeIndex])
                        uf.unionByRank(adjIndex,nodeIndex);
                }
            }
            nodes = valNodesMap.get(val);
            for(int i = 0; i < nodes.size(); i++){
                for(int j = i+1; j < nodes.size(); j++){
                    if(uf.find(nodes.get(i)) == uf.find(nodes.get(j)))
                        result++;
                }

            }

        }
        return result;

    }

    class UnionFind {
        public UnionFind(int n) {
            id = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i)
                id[i] = i;
        }

        public void unionByRank(int u, int v) {
            final int i = find(u);
            final int j = find(v);
            if (i == j)
                return;
            if (rank[i] < rank[j]) {
                id[i] = id[j];
            } else if (rank[i] > rank[j]) {
                id[j] = id[i];
            } else {
                id[i] = id[j];
                ++rank[j];
            }
        }

        public int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }

        private int[] id;
        private int[] rank;
    }
}
