package ArraysAndHashing;

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
		/*
		//example of removing top k lowest/highest elements from a collection with n elements
		//in nlog(k) with a heap
		
		int[] nums = new int[] {1,2,3,4,5,6};
		
		Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
		for(int i = 0; i < nums.length ; i++) {
			if(i <= 2) {
				maxHeap.add(nums[i]);
				continue;
			}
			if(maxHeap.peek()>nums[i]) {
				maxHeap.poll();
				maxHeap.add(nums[i]);
			}
			
		}
		
		System.out.println(maxHeap);*/
		int[] nums = new int[] {1,1,1,2,2,3};
		topKFrequent0(nums, 2);
		
	}

	
	  public int[] topKFrequent1(int[] nums, int k) {
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
	  public int[] topKFrequent2(int[] nums, int k) {
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
	  public int[] topKFrequent(int[] nums, int k) {
		Map<Integer,Integer> elementFrequencyMap = new HashMap<>();
		  
		for(int i = 0; i<nums.length;i++) {
			if(!elementFrequencyMap.containsKey(nums[i]))
				elementFrequencyMap.put(nums[i], 0);
			elementFrequencyMap.put(nums[i],elementFrequencyMap.get(nums[i])+1);
		}
		Queue<Integer> minFrequencyHeap = 
				new PriorityQueue<>((a,b)->elementFrequencyMap.get(a)-elementFrequencyMap.get(b));
	  
	  List<Integer> mapkeys = new ArrayList<>(elementFrequencyMap.keySet());
	  for(int i = 0; i<mapkeys.size();i++) {
		if(i<k) {
			minFrequencyHeap.add(mapkeys.get(i));
			continue;
		}
		if(elementFrequencyMap.get(mapkeys.get(i))>elementFrequencyMap.get(minFrequencyHeap.peek())) {
			minFrequencyHeap.poll();
			minFrequencyHeap.add(mapkeys.get(i));
		}
		
	  }
	  return  minFrequencyHeap.stream().mapToInt(x->x).toArray();
	  
  }
	  public static int[] topKFrequent0(int[] nums, int k ) {
		  Map<Integer,Integer> frequencyMap = new HashMap<>();
		  for(int i = 0; i<nums.length; i++) {
			  if(!frequencyMap.containsKey(nums[i]))
				  frequencyMap.put(nums[i], 0);
			  frequencyMap.put(nums[i], frequencyMap.get(nums[i])+1);
		  }
		  List<List<Integer>> bucket = new ArrayList<>( nums.length);
		  for(int i = 0; i<nums.length;i++) {
			  bucket.set(i, null);
		  }
		  
		  List<Integer> keys = new ArrayList<>(frequencyMap.keySet());

		  for(int i = 0;i<keys.size(); i++) {
			  if(bucket.get(frequencyMap.get(keys.get(i))) == null)
				 bucket.set(frequencyMap.get(keys.get(i)), new ArrayList<>());
			  bucket.get(frequencyMap.get(keys.get(i))).add(keys.get(i));
		  }
		  
		  List<Integer> result = new ArrayList<>();
		  
		  for(int i = 0; i<bucket.size(); i++) {
			 if(result.size() == k)
				 break;
			  if(bucket.get(i)!= null)
				  result.addAll(bucket.get(i));
			  
		  }
		  
		  return result.stream().mapToInt(x->x).toArray();
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	
	
}
