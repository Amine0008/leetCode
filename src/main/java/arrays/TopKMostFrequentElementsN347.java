package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKMostFrequentElementsN347 {
	
	public static void main(String [] args) {
		
			int[] nums = new int[] {5,6,4,8,5,4,5,9};
			Queue<Integer> q = new PriorityQueue<>((a,b)->b-a);
			for(int i = 0; i<nums.length;i++) {
				q.add(nums[i]);
			}
			System.out.println(q);
			System.out.println(q.poll());
		
	}

	
	  public static int[] topKFrequent(int[] nums, int k) {
	        Map<Integer,Integer> entriesCounterMap = new HashMap<>();
	        for(int i = 0;i < nums.length; i++) {
	        	if(!entriesCounterMap.containsKey(nums[i]))
	        		entriesCounterMap.put(nums[i], 0);
	        	entriesCounterMap.put(nums[i], entriesCounterMap.get(nums[i])+1);
	        }
	        List<Integer> counters =  new ArrayList<>(entriesCounterMap.values());
	        Collections.sort(counters,Comparator.reverseOrder());
	        counters = counters.subList(0, k);
	        List<Integer> result = new ArrayList<>();
	        List<Integer> keys = new ArrayList<> (entriesCounterMap.keySet());
	        for(int i = 0; i < counters.size(); i++) {
	        	for(int j = 0; j < keys.size(); j++) {
	        		if(entriesCounterMap.get(keys.get(j)).equals(counters.get(i))) {
	        			if(result.contains(keys.get(j)))
	        				continue;
	        			result.add(keys.get(j));
	        			break;
	        		}
	        			
	        	}
	        }
	        return result.stream().mapToInt(Integer::intValue).toArray();
	        
    }
	  public static int[] topKFrequent2(int[] nums, int k) {
		  Map<Integer,Integer> entriesCounterMap = new HashMap<>();
	        for(int i = 0;i < nums.length; i++) {
	        	if(!entriesCounterMap.containsKey(nums[i]))
	        		entriesCounterMap.put(nums[i], 0);
	        	entriesCounterMap.put(nums[i], entriesCounterMap.get(nums[i])+1);
	        }
	        Map<Integer,List<Integer>> inverseCounterEntriesMap = new HashMap<>();
	        List<Integer> keys = new ArrayList<>(entriesCounterMap.keySet());
	        for(int i = 0; i < keys.size(); i++) {
	        	if(!inverseCounterEntriesMap.containsKey(entriesCounterMap.get(keys.get(i))))
	        		inverseCounterEntriesMap.put(entriesCounterMap.get(keys.get(i)),new ArrayList<>());
	    		inverseCounterEntriesMap.get(entriesCounterMap.get(keys.get(i))).add(keys.get(i));

	        }	        
	        List<Integer> counters = new ArrayList<>(inverseCounterEntriesMap.keySet());
	        Collections.sort(counters,Comparator.reverseOrder());
	        List<Integer> results = new ArrayList<>();
	        int position = 0;
	        while(results.size() < k) {
	        	results.addAll(inverseCounterEntriesMap.get(counters.get(position)));
	        	position++;
	        }
	        
	        
	        return results.stream().mapToInt(Integer::intValue).toArray();
	  }
	  
	  
	
}
