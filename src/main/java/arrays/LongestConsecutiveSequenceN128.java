package arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class LongestConsecutiveSequenceN128 {
	

	public static void main(String[] args) {
		//int[] input = new int[]  {0,3,7,2,5,8,4,6,0,1};
		int[] input = new int[]  {1,0,-1};

		longestConsecutive2(input);

	
	}
	
    public int longestConsecutive(int[] nums) {
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i = 0; i<nums.length; i++) {
    		map.put(nums[i],1);
    	}
    	int[] keys =  map.keySet().stream().mapToInt(Integer::intValue).toArray();
    	
    	for(Integer x : keys) {
    		if(map.containsKey(x)) {
    		addOnetoSequence(x,x, map);
    		}
    	}
    	 int[] values = map.values().stream().mapToInt(Integer::intValue).toArray();
    	 if(values.length == 0)
    		 return 0;
    	 int result = values[0];
    	 for(int i = 0; i<values.length; i++) {
    		 if(values[i]>result)
    			 result = values[i];
    	 }
    	 return result;
    }
    
    public void addOnetoSequence(int originalKey,int sequenceKey, Map<Integer,Integer> map) {
    	if(map.containsKey(sequenceKey-1)) {
    		map.put(originalKey, map.get(originalKey)+map.get(sequenceKey-1));
    		addOnetoSequence(originalKey,sequenceKey-1,map);
    		map.remove(sequenceKey-1);
    	}
    }
    

    public static int longestConsecutive2(int[] nums) {
    	
    	Map<Integer, Node> map = new HashMap<>();
    	for(int i = 0; i < nums.length;i++) {
    		map.put(nums[i] , new Node());

    	}
    	for(Integer key: map.keySet()) {
    		if(map.containsKey(key+1))
    			map.get(key+1).addNode(map.get(key));
    	}
    	List<Integer> values = map.values().stream().map(n->n.getSize()).collect(Collectors.toList());
    	if(values.size()==0)
    		return 0;
    	
    	int result = values.get(0);
    	for(int i = 1; i<values.size();i++) {
    		if(values.get(i)>result)
    			result = values.get(i);
    	}
    	return result;
    }
   
    public static class Node {
    	Node nextChild = null;
    	int size = 1;
    	void addNode(Node node){
    		nextChild = node;
    		int result = 1;
    		Node children = nextChild;
    		while(children != null) {
    			result++;
    			children = children.nextChild;
    		}
    		size = result;
    	}
    	int getSize(){
    		return size;
    	}
    }
    
    
    
}
