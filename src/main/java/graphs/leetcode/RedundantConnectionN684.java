package graphs.leetcode;

import java.util.Arrays;

public class RedundantConnectionN684 {
    public class CollapsedUnionFind {

        int[] parents;

        public CollapsedUnionFind(int numberOfNodes) {
            parents = new int[numberOfNodes];
            Arrays.fill(parents, -1);
        }

        public int find(int nodeIndex) {
            //will return the index for the root node of this node's set
            return parents[nodeIndex] < 0 ? nodeIndex : parents[nodeIndex];
        }
        public void union(int firstNodeIndex, int secondNodeIndex) {
            if(parents[firstNodeIndex] == parents[secondNodeIndex] && parents[secondNodeIndex] > 0)
                return;
            int firstSetParent;
            int secondSetParent;
            if(parents[firstNodeIndex] < 0)
                firstSetParent = firstNodeIndex;
            else
                firstSetParent = parents[firstNodeIndex];
            if(parents[secondNodeIndex] < 0)
                secondSetParent = secondNodeIndex;
            else
                secondSetParent = parents[secondNodeIndex];
            for(int i = 0; i < parents.length; i++) {
                if(parents[i] == secondSetParent)
                    parents[i] = firstSetParent;
            }
            parents[firstSetParent] += parents[secondSetParent] ;
            parents[secondSetParent] = firstSetParent;


        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        CollapsedUnionFind unionFindDS = new CollapsedUnionFind(edges.length+1);

        for(int[] edge: edges){
            if(unionFindDS.find(edge[0]) == unionFindDS.find(edge[1]))
                return edge;
            unionFindDS.union(edge[0],edge[1]);
        }
        return null;
    }
}
