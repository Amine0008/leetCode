package graphs.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class IsGraphBipartiteN785 {

    public boolean isBipartite(int[][] graph) {
        Set<Integer>[] sets = new Set[]{new HashSet<Integer>(), new HashSet<Integer>()};
        Set<Integer> visitedNodes = new HashSet<>();

        for(int i = 0; i < graph.length; i++){
            if(!bfs(i,sets,visitedNodes,graph))
                return false;
        }
        return true;
    }
    boolean bfs(int sourceNode, Set<Integer>[] sets, Set<Integer> visitedNodes, int[][] graph){
        LinkedList<Integer> waveNodes = new LinkedList<>();
        int waveSize;
        waveNodes.add(sourceNode);
        visitedNodes.add(sourceNode);
        int cNode;
        while(!waveNodes.isEmpty()){
            waveSize = waveNodes.size();
            for(int i = 0; i < waveSize; i++){
                cNode = waveNodes.removeFirst();
                for(int j = 0; j < graph[cNode].length; j++){
                    if(!addNodesToSets(cNode,graph[cNode][j],sets))
                        return false;
                    if(visitedNodes.contains(graph[cNode][j]))
                        continue;
                    waveNodes.addLast(graph[cNode][j]);
                    visitedNodes.add(graph[cNode][j]);
                }
            }
        }
        return true;
    }

    int getSetId(int node, Set<Integer>[] sets){
        if(sets[0].contains(node))
            return 0;
        if(sets[1].contains(node))
            return 1;
        return -1;
    }

    boolean addNodesToSets(int nodeA, int nodeB, Set<Integer>[] sets){
        int setOfA = getSetId(nodeA, sets);
        int setOfB = getSetId(nodeB, sets);

        if(setOfA == setOfB){
            if(setOfA == -1){
                sets[0].add(nodeA);
                sets[1].add(nodeB);
                return true;
            }
            return false;
        }

        if(setOfA != -1 && setOfB != -1)
            return true;

        if(setOfA == -1){
            sets[1-setOfB].add(nodeA);
        }
        if(setOfB == -1){
            sets[1-setOfA].add(nodeB);
        }
        return true;
    }

}
