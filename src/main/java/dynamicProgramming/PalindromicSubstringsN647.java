package dynamicProgramming;

public class PalindromicSubstringsN647 {
	
    public int countSubstrings(String s) {
    	int counter = s.length();
    	int x;
    	int y;
    	for(int i = 0; i < s.length(); i++) {
    		x = i-1;
    		y = i+1;
    		while(x >= 0 && y < s.length()) {
    			if(s.charAt(x) == s.charAt(y))
    				counter++;
    			else
    				break;
    			y++;
    			x--;
    		}
    	}
    	
    	for(int i = 0; i < s.length(); i++) {
    		x = i;
    		y = i+1;
    		while(x >= 0 && y < s.length()) {
    			if(s.charAt(x) == s.charAt(y))
    				counter++;
    			else
    				break;
    			y++;
    			x--;
    		}
    	}
    	return counter;
    }

}
