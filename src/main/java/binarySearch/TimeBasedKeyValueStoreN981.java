package binarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStoreN981 {

	class TimeMap {
		Map<Integer, String> timeValueMap;
		Map<String, List<Integer>> keyTimeTableMap;
	    public TimeMap() {
	        timeValueMap = new HashMap<>();
	        keyTimeTableMap = new HashMap<>();
	    }
	    
	    public void set(String key, String value, int timestamp) {
	        if(!keyTimeTableMap.containsKey(key))
	        	keyTimeTableMap.put(key, new ArrayList<>());
	        keyTimeTableMap.get(key).add(timestamp);
	        timeValueMap.put(timestamp, value);
	    }
	    
	    public String get(String key, int timestamp) {
	        if(!keyTimeTableMap.containsKey(key))
	        	return "";
	        List<Integer> timeTable = keyTimeTableMap.get(key);
	        
	        int left = 0;
	        int right = timeTable.size()-1;
	        int mid;
	        int result = -1;
	        
	        while(left <= right) {
	        	mid = (right-left)/2+left;
	        	if(timeTable.get(mid) == timestamp)
	        		return timeValueMap.get(timeTable.get(mid));
	        	if(timeTable.get(mid) < timestamp) {
	        		left = mid +1;
	        		result = mid;
	        	}
	        	else
	        		right = mid - 1;
	        }
	        if(result == -1)
	        	return "";
    		return timeValueMap.get(timeTable.get(result)); 
	    }
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
