package backTracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioningN131 {
	
    public List<List<String>> partition(String s) {
        return backtracking(new ArrayList<>(),s);
    }
    
    public List<List<String>> backtracking(List<String> list, String currentWord){
    	List<List<String>> result = new ArrayList<>();
    	if(currentWord == null || currentWord.length() == 0) {
    		result.add(new ArrayList<>(list));
    		return result;
    	}
    	List<String> subPalindromes = allPalindromesForStart(currentWord);
    	List<List<String>> holder;
    	for(String x: subPalindromes) {
    		list.add(x);
    		holder = backtracking(list, currentWord.substring(x.length()));
    		list.remove(list.size() - 1);
    		result.addAll(holder);
    	}
    	return result;
    }
    
    public boolean isPalindrome(String s, int end) {
    	int p1 = 0;
    	int p2 = end;
    	while(p1 < p2) {
    		if(s.charAt(p1) != s.charAt(p2))
    			return false;
    		p1++;
    		p2--;
    	}
    	return true;
    }

    List<String> allPalindromesForStart(String s){
    	List<String> palindromes = new ArrayList<>();
    	for(int i = 0; i < s.length(); i++) {
    		if(isPalindrome(s,i))
    			palindromes.add(s.substring(0,i+1));
    	}
    	return palindromes;
    	
    }


}
