package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountWordsN2085 {

	public static void main(String[] args) {
		
	}
    public int countWords(String[] words1, String[] words2) {
        Integer counter = 0;
        
        HashMap<String,Integer> fMap = new HashMap<>();
        HashMap<String,Integer> sMap = new HashMap<>();
        
        
        for(int i = 0; i<Math.max(words1.length, words2.length);i++) {
        	if(i < words1.length) {
        		if(fMap.containsKey(words1[i])) {
        			fMap.put(words1[i], fMap.get(words1[i])+1);
        		}
        		else
        			fMap.put(words1[i], 1);
        	}
        	if(i<words2.length) {
        		if(sMap.containsKey(words2[i])) {
        			sMap.put(words2[i], sMap.get(words2[i])+1);
        		}
        		else
        			sMap.put(words2[i], 1);
        	}	
        }
        
        List<String> list=  new ArrayList<>(fMap.keySet());
        for(int i =0;i<list.size();i++) {
        	if(fMap.get(list.get(i)) == 1 && Integer.valueOf(1).equals(sMap.get(list.get(i))))
        		counter++;
        }
    	return counter;
    }

}
