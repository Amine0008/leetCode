package graphs.implementation.list;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {

  List<GraphNode> nodeList = new ArrayList<GraphNode>();

  public Graph(List<GraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public void addUndirectedEdge(int i, int j) {
    GraphNode first = nodeList.get(i);
    GraphNode second = nodeList.get(j);
    first.neighbors.add(second);
    second.neighbors.add(first);
  }

  public void addDirectedEdge(int i, int j) {
	  nodeList.get(i).neighbors.add(nodeList.get(j));
  }
  
  public String toString() {
    StringBuilder s = new StringBuilder();
    for (int i = 0; i < nodeList.size(); i++) {
      s.append(nodeList.get(i).name + ": ");
      for (int j =0; j < nodeList.get(i).neighbors.size(); j++) {
        if (j == nodeList.get(i).neighbors.size()-1 ) {
          s.append((nodeList.get(i).neighbors.get(j).name) );
        } else {
          s.append((nodeList.get(i).neighbors.get(j).name) + " -> ");
        }
      }
      s.append("\n");
    }
    return s.toString();
  }

  public String bfs(int startingNodeIndex) {
	  if(nodeList.size() == 0)
		  return "";
	  StringBuilder sb  = new StringBuilder();
	  Queue<Integer> myQ = new LinkedList<>();
	  GraphNode currentNode = nodeList.get(startingNodeIndex);
	  myQ.add(startingNodeIndex);
	  currentNode.isVisited = true;
	  while(!myQ.isEmpty()) {
		 currentNode = nodeList.get(myQ.poll());
		 sb.append(currentNode.name);
		 for(GraphNode node : currentNode.neighbors) {
			 if(node.isVisited)
				 continue;
			 myQ.add(node.index);
			 node.isVisited = true;
		 }
	  }
	  return sb.toString();
   }
  
  public String dfs(int startingIndex) {
	  return dfsTraversal(nodeList.get(startingIndex));
  }
  
  public String dfsTraversal(GraphNode node) {
	  if(node.isVisited)
		  return "";
	  node.isVisited = true;
	  StringBuilder sb = new StringBuilder();
	  for(GraphNode neighbor: node.neighbors) {
		  sb.append(dfsTraversal(neighbor));
	  }
	  return node.name+sb.toString();
  }
  
  public Stack<GraphNode> topologicalSort(){
	  Stack<GraphNode> stack = new Stack<>();
	  for(GraphNode node : nodeList) {
		  dfsTopSort(node, stack);
	  }
	  return stack;
	  
  }
  public void dfsTopSort(GraphNode node, Stack<GraphNode> stack) {
	  if(node.isVisited)
		  return;
	  node.isVisited = true;
	  for(GraphNode neighbor : node.neighbors) {
		  dfsTopSort(neighbor, stack);
	  }
	  stack.add(node);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  


}
