package graphs.leetcode;

import java.util.HashMap;
import java.util.Map;

public class VerifyingAnAlienDictionaryN953 {

	  public boolean isAlienSorted(String[] words, String order) {
		  Map<Character,Integer> alphabetOrder = new HashMap<>();
		  for(int i = 0; i < order.length(); i++) {
			  alphabetOrder.put(order.charAt(i), i);
		  }
		  
		  for(int i = 0; i < words.length-1; i++) {
			  if(compare(words[i],words[i+1], alphabetOrder) < 0)
				  return false;
		  }
		  return true;
		  
      }
	  
	  public int compare(String firstWord, String secondWord, Map<Character,Integer> map) {
		  for(int i = 0; i < Math.min(firstWord.length(), secondWord.length()); i++) {
			  if(firstWord.charAt(i) == secondWord.charAt(i))
				  continue;
			  if(map.get(secondWord.charAt(i)) > map.get(firstWord.charAt(i)))
				  return 1;
			  return -1;
		  }
		  if(firstWord.length() == secondWord.length())
			  return 0;
		  if(secondWord.length() > firstWord.length())
			  return 1; 
		  else
			  return -1;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
