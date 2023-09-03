package linkedList.leetcode;

import java.util.HashMap;
import java.util.Map;


public class LFUCacheN460 {
	
	public static void main(String[] args) {
		LFUCache lfu = new 	LFUCache(2);
		lfu.put(1,1);
		lfu.put(2,2);
		lfu.get(1);
		lfu.put(3,3);
		lfu.get(2);
		lfu.get(3);
		lfu.put(4, 4);
		lfu.get(1);
		lfu.get(3);
		lfu.get(4);
	}
	
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
	    
    public void remove(int key) {
	    	if(lru == null)
	    		return;
	    	if(lru == ru && ru.val == key) {
	    		cache.clear();
	    		nodesMap.clear();
	    		lru = null;
	    		ru = null;
	    	}
	    	else if(key == lru.val) {
	    		cache.remove(lru.val);
	    		lru = lru.next;
	    		nodesMap.remove(lru.val);
	    	}
	    	else if(key == ru.val) {
	    		cache.remove(key);
	    		ru = nodesMap.get(ru.val);
	    		nodesMap.remove(key);
	    		ru.next = null;
	    	}
	    	else {
	    		cache.remove(key);
		    	Node temp = nodesMap.get(key);
		    	nodesMap.remove(key);
		    	nodesMap.remove(temp.next.next.val);
		    	temp.next = temp.next.next;
		    	nodesMap.put(temp.next.val, temp);

	    	}
	    
	    }

	}
	static class LFUCache {
		int capacity;
		Map<Integer, Integer> keyValueMap;
		Map<Integer, Integer> keyFrequencyMap;
		Map<Integer, LRUCache> frequencyLruMap;
		Map<Integer, Node> keyLruNodeMap;
		
		//currentLeastFrequency
		int clf = 0;
	    public LFUCache(int capacity) {
	    	this.capacity = capacity;
	    	keyValueMap = new HashMap<>();
	    	keyFrequencyMap = new HashMap<>();
	    	frequencyLruMap = new HashMap<>();
	    }
	    
	    public int get(int key) {
	    	if(!keyValueMap.containsKey(key))
	    		return -1;
	    	int oldFrequency = keyFrequencyMap.get(key);
	    	int newFrequency = oldFrequency + 1;
	    	frequencyLruMap.get(oldFrequency).remove(key);
	    	if(!frequencyLruMap.containsKey(newFrequency))
	    		frequencyLruMap.put(newFrequency, new LRUCache(capacity));
	    	frequencyLruMap.get(newFrequency).put(key, 0);
	    	keyFrequencyMap.put(key, newFrequency);
	    	if(newFrequency < clf)
	    		clf = newFrequency;
	    	else if(oldFrequency == clf && frequencyLruMap.get(oldFrequency).lru == null)
	    		clf = newFrequency;
	    	return keyValueMap.get(key);
	    	
	    }
	    
	    public void put(int key, int value) {
	    	if(keyValueMap.containsKey(key)) {
	    		keyValueMap.put(key, value);
	    		get(key);
	    		return;
	    	}
	    	if(keyValueMap.size() == capacity) {
	    		LRUCache lruForClf= frequencyLruMap.get(clf);
	    		int lfuKey = lruForClf.lru.val;
	    		keyValueMap.remove(lfuKey);
	    		keyFrequencyMap.remove(lfuKey);
	    		lruForClf.remove(lruForClf.lru.val);
	    		if(lruForClf.lru == null)
	    			clf = 0;
	    	}
	    	keyValueMap.put(key, value);
	    	keyFrequencyMap.put(key, 0);
	    	if(!frequencyLruMap.containsKey(0))
	    		frequencyLruMap.put(0, new LRUCache(1));
	    	get(key);
	    	
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}

}
