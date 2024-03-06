package graphs.leetcode;

import java.util.*;

public class LargestColorValueInADirectedGraphN1857 {

    public int largestPathValue(String colors, int[][] edges) {

        List<Integer>[] graph  = new ArrayList[colors.length()];
        Map<Integer,int[]> memo = new HashMap<>();
        boolean notVisitedNode[] = new boolean[colors.length()];

        for(int i = 0; i < colors.length(); i++){
            graph[i] = new ArrayList<>();
            memo.put(i,null);
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
        }
        for(int i = 0; i < colors.length(); i++){
            if(!dfs(i,graph,memo,colors, notVisitedNode))
                return -1;
        }
        int result = 0;
        for (int[] nodeFreqs : memo.values()) {
            for (int j = 0; j < 26; j++) {
                if (nodeFreqs[j] > result)
                    result = nodeFreqs[j];
            }
        }
        return result;


    }


    boolean dfs(int sourceNode,
                List<Integer>[] graph,
                Map<Integer,int[]> memo,
                String colors,
                boolean[] visitedNode){
        if(visitedNode[sourceNode])
            return false;
        if(memo.get(sourceNode) != null)
            return true;
        visitedNode[sourceNode] = true;

        for(Integer child: graph[sourceNode]){
            if(memo.get(child) == null)
                if(!dfs(child,graph,memo,colors,visitedNode))
                    return false;
        }
        int[] colorFreq = new int[26];
        int maxHolder;
        for(int i= 0; i < 26; i++){
            maxHolder = 0;
            for(Integer child: graph[sourceNode]){
                if(memo.get(child)[i] > maxHolder)
                    maxHolder = memo.get(child)[i];
            }
            if((colors.charAt(sourceNode) - 97) == i)
                maxHolder++;
            colorFreq[i] = maxHolder;
        }
        memo.put(sourceNode, colorFreq);
        visitedNode[sourceNode] = false;
        return true;
    }

    boolean graphIsCyclic(List<Integer>[] graph ){
        int wavesize;
        LinkedList<Integer> waves;
        Set<Integer> goodNodes = new HashSet<>();
        int node;
        for(int i = 0; i < graph.length; i++){
            waves = new LinkedList<>();
            waves.add(i);

            while(!waves.isEmpty()){
                wavesize = waves.size();
                for(int j = 0; j < wavesize; j++){
                    node = waves.removeFirst();
                    for(Integer child: graph[node]){
                        if(child == i)
                            return true;
                        if(goodNodes.contains(child))
                            continue;
                        waves.addLast(child);
                    }
                }
            }
            goodNodes.add(i);


        }
        return false;

    }

}
