package graphs.leetcode;

import java.util.*;

public class DetonateTheMaximumBombsN2101 {

    public int maximumDetonation(int[][] bombs) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < bombs.length; i++){
            graph.put(i, new ArrayList<>());
            for(int j = 0; j < bombs.length; j++){
                if( i == j)
                    continue;
                if(bombTwoIsInRange(bombs[i][0],bombs[i][1],bombs[j][0],bombs[j][1],bombs[i][2]))
                    graph.get(i).add(j);
            }
        }

        int currentMax = 0;
        Set<Integer> visitedBombs = new HashSet<>();
        int countHolder;
        for(int i = 0; i < bombs.length; i++){
            if(visitedBombs.contains(i))
                continue;
            countHolder = bfs(i,graph,visitedBombs);
            if(currentMax < countHolder)
                currentMax = countHolder;
        }
        return currentMax;

    }



    int bfs(int source,
            Map<Integer, List<Integer>> graph,
            Set<Integer> outerVisitedNodes){
        int waveSize;
        LinkedList<Integer> waveNodes = new LinkedList<>();

        Set<Integer> explodedBombs = new HashSet<>();
        explodedBombs.add(source);
        waveNodes.add(source);
        int currentNode;
        int counter = 1;
        outerVisitedNodes.add(source);
        while(!waveNodes.isEmpty()){
            waveSize = waveNodes.size();
            for(int i = 0; i < waveSize; i++){
                currentNode = waveNodes.removeFirst();
                for(Integer adjNode: graph.get(currentNode)){
                    if(explodedBombs.contains(adjNode))
                        continue;
                    explodedBombs.add(adjNode);
                    outerVisitedNodes.add(adjNode);
                    waveNodes.addLast(adjNode);
                    counter++;
                }

            }
        }
        return counter;



    }

    boolean bombTwoIsInRange(int x1, int y1, int x2, int y2, int bombOneRadius){
        return Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y2-y1,2)) <= bombOneRadius;
    }











}
