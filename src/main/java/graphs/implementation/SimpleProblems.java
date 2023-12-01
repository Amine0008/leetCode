package graphs.implementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class SimpleProblems {
	
	public static void main(String[] args) {
		Map<Integer, int[]> graph = new HashMap<>();
		graph.put(0, new int[] {8,1,5});
		graph.put(1, new int[] {0});
		graph.put(5, new int[] {0,8});
		graph.put(8, new int[] {0,5});
		graph.put(2, new int[] {3,4});
		graph.put(3, new int[] {2,4});
		graph.put(4, new int[] {3,2});

		System.out.println(sizeOfLargestComponent(graph));
		
	}
	
	//directed and non cyclical
	public static String depthFirstTraversal(char startingPoint, Map<Character, char[]> graph) {
		Stack<Character> stack  = new Stack<>();
		stack.push(startingPoint);
		Character currentHolder;
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			currentHolder = stack.pop();
			sb.append(currentHolder);
			for(char c : graph.get(currentHolder)) {
				stack.push(c);
			}
		}
		return sb.toString();
	}

	public static String depthFirstTraversalRecursively(char node, Map<Character, char[]> graph) {
		if(graph.get(node).length == 0)
			return ""+node;
		String result = "";
		for(char c : graph.get(node)) {
			result += depthFirstTraversalRecursively(c, graph);
		}
		return node+result;
	}
	
	public static String breadthFirstTraversal(char startingPoint, Map<Character, char[]> graph) {
		Queue<Character> myQ = new LinkedList<>();
		myQ.add(startingPoint);
		StringBuilder sb = new StringBuilder();
		Character nodeHolder;
		while(!myQ.isEmpty()) {
			nodeHolder = myQ.poll();
			sb.append(nodeHolder);
			for(Character c : graph.get(nodeHolder)) {
				myQ.add(c);
			}
		}
		return sb.toString();
		
	}
	
	public static String breadthFirstTraversalRecursively(char startingPoint,
			Map<Character, char[]> graph) {
		Queue<Character> nodesQ = new LinkedList<>();
		nodesQ.add(startingPoint);
		return bfs(nodesQ, graph);
	}
	
	private static String bfs(Queue<Character> nodesQ, 
			Map<Character, char[]> graph) {
		if(nodesQ.isEmpty())
			return "";
		Character head = nodesQ.poll();
		for(Character c : graph.get(head)) {
			nodesQ.add(c);
		}
		return head+""+bfs(nodesQ, graph);
	
	}
	
	
	//directed and non cyclical
	public static boolean thereIsAPath(Character src, Character dest, Map<Character, char[]> graph) {
		return dfsThereIsPath(src, dest, graph);
	}
	private static boolean dfsThereIsPath(Character current, Character dest, Map<Character, char[]> graph) {
		if(current.equals(dest))
			return true;
		for(Character c : graph.get(current)) {
			if(dfsThereIsPath(c, dest,graph))
				return true;
		}
		return false;
	}
	
	//directed and non cyclical
	public static boolean thereIsAPathBFS(char src, char des, Map<Character, char[]> graph) {
		Queue<Character> myQ = new LinkedList<>();
		myQ.add(src);
		Character nodeHolder;
		while(!myQ.isEmpty()) {
			nodeHolder = myQ.poll();
			if(nodeHolder == des)
				return true;
			for(Character c: graph.get(nodeHolder)) {
				myQ.add(c);
			}
		}
		return false;
		
	}

	//undirected
	public static boolean  thereIsAPath2(char src, char dest, Map<Character, char[]> graph ) {
		Set<Character> visitedNodes = new HashSet<>();
		return dfsDirectedAndCyclical(src, dest, graph, visitedNodes);
	}
	
	private static  boolean dfsDirectedAndCyclical(char current, char dest, Map<Character, char[]> graph, Set<Character> visitedNodes ) {
		if(visitedNodes.contains(current))
			return false;
		if(current == dest)
			return true;
		visitedNodes.add(current);
		for(Character c : graph.get(current)) {
			if(dfsDirectedAndCyclical(c, dest, graph, visitedNodes))
				return true;
		}
		return false;
	}
	

	//undirected
	public static int countComponents(Map<Integer, int[]> graph) {
		Set<Integer> visitedNodes = new HashSet<>();
		int count = 0;
		for(Integer node: graph.keySet()) {
			if(!visitedNodes.contains(node)) {
				count++;
				dfsCountComponents(node, graph, visitedNodes);
			}
		}
		return count;
	}
	private static  void dfsCountComponents(Integer node, 
			Map<Integer, int[]> graph, 
			Set<Integer> visitedNodes) {
		if(visitedNodes.contains(node))
			return;
		visitedNodes.add(node);
		for(Integer n : graph.get(node)) {
			dfsCountComponents(n, graph, visitedNodes);
		}
	}

	//undirected
	public static int sizeOfLargestComponent(Map<Integer, int[]> graph) {
		int largestSize = 0;
		Set<Integer> visitedNodes = new HashSet<>();
		int holder;
		for(Integer node : graph.keySet()) {
			if(visitedNodes.contains(node))
				continue;
			holder = dfsComponentSize(node, graph, visitedNodes);
			if(holder > largestSize)
				largestSize = holder;
		}
		return largestSize;
	}
	private static int dfsComponentSize(int current, Map<Integer, int[]> graph, Set<Integer> visitedNodes) {
		if(visitedNodes.contains(current))
			return 0;
		visitedNodes.add(current);
		int counter = 0; 
		for(int n : graph.get(current)) {
			counter += dfsComponentSize(n,graph,visitedNodes);
		}
		return 1+counter;
	}
	
	public static Map<Character, List<Character>> buildGraph(List<List<String>> graphEdges){
		Map<Character, List<Character>> graph = new HashMap<>();
		for(List<String> edge: graphEdges) {
			if(!graph.containsKey(edge.get(0).charAt(0))) {
				graph.put(edge.get(0).charAt(0), new ArrayList<>());
			}
			if(!graph.containsKey(edge.get(1).charAt(0))) {
				graph.put(edge.get(1).charAt(0), new ArrayList<>());
			}
			graph.get(edge.get(0).charAt(0)).add(edge.get(1).charAt(0));
			graph.get(edge.get(1).charAt(0)).add(edge.get(0).charAt(0));

		}
		return graph;
	}
	
	public static int getLengthOfShortestPath(
			Map<Character, List<Character>> graph,
			char start,
			char target) {
		int edgeCounter = 0;
		Queue<Character> myQ = new LinkedList<>();
		Set<Character> visitedNodes = new HashSet<>();
		
		myQ.add(start);
		myQ.add('*');
		visitedNodes.add(start);
		char holder;
		while(!myQ.isEmpty()) {
			holder = myQ.poll();
			if(holder == '*') {
				if(!myQ.isEmpty())
					myQ.add('*');
				edgeCounter++;
				continue;
			}
			if(holder == target)
				return edgeCounter;
			for(Character c: graph.get(holder)) {
				if(!visitedNodes.contains(c)) {
					visitedNodes.add(c);
					myQ.add(c);
				}
			}
		}
		return -1;
		
	
	}
	public static int getLengthOfShortestPath2(
			Map<Character, List<Character>> graph,
			char start,
			char target) {
		Queue<NodeAndDistance> myQ = new LinkedList<>();
		Set<Character> visitedNodes = new HashSet<>();
		if(start == target)
			return 0;
		myQ.add(new NodeAndDistance(start,0));
		visitedNodes.add(start);
		NodeAndDistance holder;
		while(!myQ.isEmpty()) {
			holder = myQ.poll();
			for(Character c : graph.get(holder.node)) {
				if(c == target)
					return holder.distance+1;
				if(!visitedNodes.contains(c)) {
					visitedNodes.add(c);
					myQ.add(new NodeAndDistance(c,holder.distance+1));
				}
			}
		}
		return -1;
		
		
	}
	static class NodeAndDistance{
		char node;
		int distance;
		NodeAndDistance(char node, int distance){
			this.node = node;
			this.distance = distance;
		}
	}
	
	public static int minimumIsland(List<List<String>> grid) {
		String[][] myGrid = new String[grid.size()][grid.get(0).size()];
		for(int i = 0; i < grid.size(); i++) {
			for(int j = 0; j < grid.get(0).size(); j++) {
				myGrid[i][j] = grid.get(i).get(j);
			}	
		}
		int minSize = Integer.MAX_VALUE;
		int holder;
		for(int i = 0; i < grid.size(); i++) {
			for(int j = 0; j < grid.get(0).size(); j++) {
				if(myGrid[i][j] == "W" || myGrid[i][j] == "VL")
					continue;
				holder = traverseLand(myGrid, i, j);
				if(holder < minSize)
					minSize = holder;
			}
		}
		return minSize;
	}
	
	public static int traverseLand(String[][] grid, int i, int j) {
		if(i == grid.length || i < 0 || j < 0 || j == grid[0].length)
			return 0;
		if(grid[i][j] == "W" || grid[i][j]== "VL")
			return 0;
		
		grid[i][j] =  "VL";
		return 1+ traverseLand(grid, i+1,j)
				+ traverseLand(grid, i-1,j)
				+ traverseLand(grid, i,j+1)
				+ traverseLand(grid, i,j-1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
