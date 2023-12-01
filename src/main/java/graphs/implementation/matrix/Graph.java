package graphs.implementation.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
  List<GraphNode> nodeList = new ArrayList<GraphNode>();
  int[][] adjacencyMatrix;

  public Graph(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
    adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
  }

  public void addUndirectedEdge(int i, int j) {
    adjacencyMatrix[i][j] = 1;
    adjacencyMatrix[j][i] = 1;
  }
  
  public void addDirectedWeightedEdge(int i, int j, int weight) {
	  adjacencyMatrix[i][j] = weight;
  }
  
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("   ");
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + " ");
    }
    s.append("\n");
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + ": ");
      for (int j : adjacencyMatrix[i]) {
        s.append((j) + " ");
      }
      s.append("\n");
    }
    return s.toString();
  }

  // get Neighbors
  public ArrayList<GraphNode> getNeighbors(GraphNode node) {
    ArrayList<GraphNode> neighbors = new ArrayList<GraphNode>();
    int nodeIndex = node.index;
    for (int i=0; i<adjacencyMatrix.length; i++) {
      if(adjacencyMatrix[nodeIndex][i]==1) {
        neighbors.add(nodeList.get(i));
      }
    }
    return neighbors;

  }

  public List<int[]> getAdjacentNeighbors(int nodeIndex){
	  List<int[]> neighbors = new ArrayList<>();
	  int[] nodeEdge;
	  for(int i = 0; i < adjacencyMatrix[0].length; i++) {
		  if(adjacencyMatrix[nodeIndex][i] == 0)
			  continue;
		  nodeEdge = new int[2];
		  nodeEdge[0] = i;
		  nodeEdge[1] = adjacencyMatrix[nodeIndex][i];
		  neighbors.add(nodeEdge);
	  }
	  return neighbors;
  }
  
  public String bfs(int startingNodeIndex) {
	  StringBuilder sb = new StringBuilder();
	  // starting at node in index 0
	  if(nodeList.size() == 0)
		  return "";
	  Queue<Integer> myQ = new LinkedList<>();
	  myQ.add(startingNodeIndex);
	  GraphNode currentNode = nodeList.get(startingNodeIndex);
	  GraphNode neighbor;
	  currentNode.isVisited = true;
	  while(!myQ.isEmpty()) {
		  currentNode = nodeList.get(myQ.poll());
		  sb.append(currentNode.name);
		  for(int j = 0; j < nodeList.size(); j++) {
			  if(adjacencyMatrix[currentNode.index][j] == 0)
				  continue;
			  neighbor = nodeList.get(j);
			  if(neighbor.isVisited)
				  continue;
			  myQ.add(j);
			  neighbor.isVisited = true;
		  }
	  }
	  return sb.toString();
  }
  
  
  public void dijkstra(int startingNodeIndex) {
	  GraphNode current = nodeList.get(startingNodeIndex);
	  current.shortestDistanceLenght = 0;
	  PriorityQueue<GraphNode> pq = 
			  new PriorityQueue<>((n1,n2)->n1.shortestDistanceLenght - n2.shortestDistanceLenght);
	  for(GraphNode node : nodeList) {
		  pq.add(node);
	  }
	  GraphNode holder;
	  while(!pq.isEmpty()) {
		  current = pq.peek();
		  current.isVisited = true;
		  for(int[] nodeEdge : getAdjacentNeighbors(current.index)) {
			  holder = nodeList.get(nodeEdge[0]);
			  if(holder.isVisited)
				  continue;
			  if(current.shortestDistanceLenght + nodeEdge[1] < holder.shortestDistanceLenght) {
				  holder.shortestDistanceLenght = current.shortestDistanceLenght + nodeEdge[1];
				  holder.previousNodeInPath = current;
			  }
		  }
		  pq.remove();
	  }
	  
  }
  
  public String printShortestPath(int a) {
	  GraphNode node = nodeList.get(a);
	  if(node.previousNodeInPath == null)
		  return node.name;
	  return printShortestPath(node.previousNodeInPath.index) +"->"+node.name;
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

}
