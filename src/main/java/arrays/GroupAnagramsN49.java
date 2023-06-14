package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupAnagramsN49 {

	public static void main(String[] args) {
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> anagramsMap = new HashMap<>();
		String key;
		for(int i = 0; i < strs.length; i++) {
			key = lowerCaseAndSortString(strs[i]);
			if(!anagramsMap.containsKey(key))
				anagramsMap.put(key, new ArrayList<>());
			anagramsMap.get(key).add(strs[i]);
		}		
		return  anagramsMap.values().stream().collect(Collectors.toList());
    }
	
	private String lowerCaseAndSortString(String s) {
		char[] x = s.toLowerCase().toCharArray();
		Arrays.sort(x);
		return new String(x);
	}
}
