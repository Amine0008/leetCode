package linkedList.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheN146 {

	static class Node {
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	static class LRUCache {
		int capacity;
		Map<Integer,Integer> cache;
		Node lru;
		Node ru;
		Map<Integer,Node> nodesMap;
	    public LRUCache(int capacity) {
	        this.capacity = capacity;
	        cache = new HashMap<>();
	        nodesMap = new HashMap<>();
	    }
	    public int get(int key) {
	        if(!cache.containsKey(key))
	        	return -1;
	        if(key == ru.val)
	        	return cache.get(key);
	        if(key == lru.val) {
	        	nodesMap.remove(lru.next.val);
	        	lru = lru.next;
	        }
	        else if(nodesMap.containsKey(key)) {
	        	Node n = nodesMap.get(key);
	        	nodesMap.put(n.next.next.val, n);
	        	n.next = n.next.next;
	        }
	        ru.next = new Node(key);
	        nodesMap.put(key, ru);
	        ru = ru.next;
	        return cache.get(key);
	    }
	    
	    public void put(int key, int value) {
	    	if(cache.containsKey(key)) {
    			cache.put(key, value);
    			get(key);
	    	}
	    	else if(cache.size() < capacity) {
	    		if(lru == null) {
	    			ru = new Node(key);
	    			lru = ru;
	    			cache.put(key, value);
	    		}
	    		else {
	    			cache.put(key, value);
	    			get(key);
	    		}
	    	}
	    	else {	    		
	    		cache.put(key, value);
	    		get(key);
	    		cache.remove(lru.val);
	    		lru = lru.next;
	    		nodesMap.remove(lru.val);
	    	}
	    }
	    

	}

}
