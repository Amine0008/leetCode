package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestoreIPAddressesN93 {

	
    public List<String> restoreIpAddresses(String s) {
    	List<List<String>> result = new ArrayList<>();
    	backtracking(new ArrayList<>(), s, 3, result);
    	List<String> processedResult = new ArrayList<>();
    	
    	for(List<String> addressElements: result) {
    		StringBuilder address = new StringBuilder();
    		for(String element: addressElements) {
    			address.append(element);
    			address.append('.');
    		}
    		processedResult.add(address.substring(0, address.length()-1));
    	}
    	return processedResult;
    }
    
    public void backtracking(List<String> list, String currentVal, int dotsLeft, List<List<String>> result) {
    	if(dotsLeft == 0) {
    		if(currentVal.length() == 0)
    			return;
    		if(currentVal.length() > 1 && currentVal.charAt(0) == '0')
    			return;
    		if(currentVal.length() > 3 || Integer.parseInt(currentVal) > 255)
    			return;
    		List<String> copy = new ArrayList<>(list);
    		copy.add(currentVal);
    		result.add(copy);
    		return;
    	}
    		List<String> possibleNextElements = possibleNumbers(currentVal);
    		for(String x: possibleNextElements) {
    			list.add(x);
    			backtracking(list, currentVal.substring(x.length()), dotsLeft - 1, result);
    			list.remove(list.size() - 1);
    		}
    	
    }
    
    public List<String> possibleNumbers(String s){
    	if(s.length() == 0)
    		return new ArrayList<>();
    	if(s.charAt(0) == '0')
    		return new ArrayList<>(Arrays.asList(new String[] {"0"}));
    	List<String> result = new ArrayList<>();
    	String holder ; 
    	int intholder;
    	for(int i = 0; i < s.length(); i++) {
    		holder = s.substring(0, i + 1);
    		intholder = Integer.parseInt(holder);
    		if(intholder >= 0 && intholder <= 255)
    			result.add(holder);
    		else
    			break;
    	}
    	return result;
    }


}
