package graphs.leetcode;

import java.util.*;

public class EvaluateDivisionN399 {



    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries) {

        Map<String, Map<String,Double>> graph = new HashMap<>();

        String holderS;
        String holderT;
        for(int i = 0; i < equations.size(); i++){
            holderS = equations.get(i).get(0);
            holderT = equations.get(i).get(1);
            if(!graph.containsKey(holderS)){
                graph.put(holderS,new HashMap<>());}

            graph.get(holderS).put(holderT,values[i]);

            if(!graph.containsKey(holderT)){
                graph.put(holderT,new HashMap<>());
            }
            graph.get(holderT).put(holderS,1/values[i]);

        }
        double[] result = new double[queries.size()];


        for(int i = 0; i < queries.size(); i++){
            result[i] = bfs(queries.get(i).get(0),queries.get(i).get(1), graph);
        }
        return result;

    }
    double bfs(String source, String target, Map<String, Map<String,Double>> graph){
        if(!graph.containsKey(source) || !graph.containsKey(target))
            return -1;
        if(source.equals(target))
            return 1;
        int waveSize;
        LinkedList<String[]> waveNodes = new LinkedList<>();
        Set<String> visitedNodes = new HashSet<>();
        waveNodes.addFirst(new String[]{source,""+1});
        String[] node;
        Map<String,Double> adjacentNodes;
        while(!waveNodes.isEmpty()){
            waveSize = waveNodes.size();
            for(int i = 0; i < waveSize; i++){
                node = waveNodes.removeFirst();
                adjacentNodes = graph.get(node[0]);
                for(String adj: adjacentNodes.keySet()){
                    if(visitedNodes.contains(adj))
                        continue;
                    visitedNodes.add(adj);
                    waveNodes.addLast(new String[]{adj, (Double.parseDouble(node[1])*adjacentNodes.get(adj))+""});
                    if(adj.equals(target))
                        return Double.parseDouble(waveNodes.removeLast()[1]);
                }
            }
        }
        return -1;
    }



}
