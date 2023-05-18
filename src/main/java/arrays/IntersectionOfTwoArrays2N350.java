package arrays;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArrays2N350 {

	public static void main(String[] args) {}
	
    public int[] intersect1(int[] nums1, int[] nums2) {
    	ArrayList<Integer> result = new ArrayList<>();
    	HashMap<Integer, Object> visitedIndecies = new HashMap<>();
    	
    	for(int i = 0; i< nums1.length; i++) {
    		for(int j = 0; j < nums2.length; j++) {
    			if(nums1[i] == nums2[j] && !visitedIndecies.containsKey(j)) {
    				visitedIndecies.put(j, null);
    				result.add(nums1[i]);
    				break;
    			}
    		}
    	}   	
    	return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int[] intersect2(int[] nums1, int[] nums2) {
    	ArrayList<Integer> result = new ArrayList<>();
    	HashMap<Integer, Integer> nums1Map = new HashMap<>();
    	HashMap<Integer, Integer> nums2Map = new HashMap<>();
    	
    	for(int i = 0;i < nums1.length;i++) {
    		if(nums1Map.containsKey(nums1[i]))
    			nums1Map.put(nums1[i], nums1Map.get(nums1[i])+1);
    		else
    			nums1Map.put(nums1[i], 1);
    	}
    	for(int i = 0;i < nums2.length;i++) {
    		if(nums2Map.containsKey(nums2[i]))
    			nums2Map.put(nums2[i], nums2Map.get(nums2[i])+1);
    		else
    			nums2Map.put(nums2[i], 1);
    	}
    	nums1Map.keySet().forEach(key -> {
    		if(nums2Map.containsKey(key)) {
    			for(int i = 0;i<Math.min(nums1Map.get(key), nums2Map.get(key));i++) {
    				result.add(key);
    			}
    		}
    	});
    	
    	return result.stream().mapToInt(Integer::intValue).toArray();
    }

    
    public int[] intersect(int[] nums1, int[] nums2) {
    	ArrayList<Integer> result = new ArrayList<>();
    	HashMap<Integer, Integer> nums1Map = new HashMap<>();
    	for(int i = 0; i < nums1.length; i++) {
    		if(nums1Map.containsKey(nums1[i]))
    			nums1Map.put(nums1[i], nums1Map.get(nums1[i])+1);
    		else
    			nums1Map.put(nums1[i], 1);
    	}
    	for(int i = 0; i < nums2.length; i++) {
    		if(nums1Map.containsKey(nums2[i]) && nums1Map.get(nums2[i]) != 0) {
    			result.add(nums2[i]);
    			nums1Map.put(nums2[i],nums1Map.get(nums2[i])-1);
    		}
    	}
    	return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
