package graphs.leetcode;

import java.util.*;

public class ReconstructItineraryN332 {

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ticket: tickets){
            graph.computeIfAbsent(ticket.get(0),(k)->new PriorityQueue<>());
            graph.computeIfAbsent(ticket.get(1),(k)->new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }
        return dfs("JFK",graph);
    }


    public LinkedList<String> dfs(String source,  Map<String, PriorityQueue<String>> graph){
        LinkedList<String> result = new LinkedList<>();
        Stack<LinkedList<String>> stack = new Stack<>();
        while(!graph.get(source).isEmpty()){
            stack.add(dfs(graph.get(source).remove(),graph));
        }
        while(!stack.empty()){
            result.addAll(stack.pop());
        }
        result.addFirst(source);
        return result;
    }






}
