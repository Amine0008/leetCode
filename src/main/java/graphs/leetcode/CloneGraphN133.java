package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraphN133 {
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
    public Node cloneGraph(Node node) {
    	if(node == null)
    		return null;
    	HashMap<Integer,Node> clonedNodes= new HashMap<>();
    	return clone(node, clonedNodes);
    }
    
    public Node clone(Node node, HashMap<Integer,Node> clonedNodes) {
    	if(clonedNodes.containsKey(node.val))
    		return clonedNodes.get(node.val);
    	Node clone = new Node();
    	clone.val = node.val;
    	clone.neighbors = new ArrayList<>();
    	clonedNodes.put(node.val, clone);
    	for(Node neighbor : node.neighbors) {
    		clone.neighbors.add(clone(neighbor, clonedNodes));
    	}
    	return clone;
    }
    
    
    
    
    
    
    
    
    
    
    
}
