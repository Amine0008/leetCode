package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversableN1579 {

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Map<Integer, List<int[]>> typeEdgesMap = new HashMap<>();
        typeEdgesMap.put(1, new ArrayList<>());
        typeEdgesMap.put(2, new ArrayList<>());
        typeEdgesMap.put(3, new ArrayList<>());
        for(int[] edge: edges){
            typeEdgesMap.get(edge[0]).add(edge);
        }
        UnionFind aliceUF = new UnionFind(n+1);
        UnionFind bobUF = new UnionFind(n+1);

        int aliceEdgesUsedCounter = 0;
        int bobEdgesUsedCounter = 0;
        int commonEdge = 0;

        for(int[] edge: typeEdgesMap.get(3)){
            if(aliceUF.find(edge[1]) == aliceUF.find(edge[2]))
                continue;
            aliceUF.unionByRank(edge[1],edge[2]);
            bobUF.unionByRank(edge[1],edge[2]);
            aliceEdgesUsedCounter++;
            bobEdgesUsedCounter++;
            commonEdge++;
        }
        if(aliceEdgesUsedCounter == n-1)
            return (typeEdgesMap.get(1).size()+typeEdgesMap.get(2).size()+typeEdgesMap.get(3).size())
                            - aliceEdgesUsedCounter;

        for(int[] edge: typeEdgesMap.get(1)){
            if(aliceUF.find(edge[1]) == aliceUF.find(edge[2]))
                continue;
            aliceUF.unionByRank(edge[1],edge[2]);
            aliceEdgesUsedCounter++;
        }
        if(aliceEdgesUsedCounter != n-1)
            return -1;

        for(int[] edge: typeEdgesMap.get(2)){
            if(bobUF.find(edge[1]) == bobUF.find(edge[2]))
                continue;
            bobUF.unionByRank(edge[1],edge[2]);
            bobEdgesUsedCounter++;
        }
        if(bobEdgesUsedCounter != n-1)
            return -1;
        return (typeEdgesMap.get(1).size()+typeEdgesMap.get(2).size()+typeEdgesMap.get(3).size())
                - (aliceEdgesUsedCounter+bobEdgesUsedCounter-commonEdge);


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
