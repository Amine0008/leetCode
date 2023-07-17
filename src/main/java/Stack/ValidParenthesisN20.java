package Stack;

import java.util.Stack;

public class ValidParenthesisN20 {
	
	
	public static boolean isValid2(String s) {
	     int countedPairs = 0;
	     int openCounter = 0; 
	     int closedCounter =0;
		for(int i = s.length()-1; i>=0; i--) {
			if(!isOpen(s.charAt(i))) {
				closedCounter++;
				continue;
			}
			openCounter++;
			if(!isOpen(s.charAt(i+1))) {
				if(openCharComp(s.charAt(i))!=s.charAt(i+1))
					return false;
				else
					countedPairs++;
			}
			else {
				if(2*countedPairs+i+1>s.length()-1)
					return false;
				if(openCharComp(s.charAt(i))!=s.charAt(2*countedPairs+i+1))
					return false;
				else
					countedPairs++;
			}
			
		}
		
		return true;
	    }
	
	public static boolean isOpen(char c) {
		if(c=='('||c=='{'|c=='[')
			return true;
		return false;
	}
	public static  char openCharComp(char c) {
		switch(c) {
			case '{': return '}';
			case '(': return ')';
		}
		return ']';
	}

    public boolean isValid(String s) {
        Stack<Character> closingParans = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i)=='[' || s.charAt(i)=='{' || s.charAt(i)=='(')
        		closingParans.add(s.charAt(i));
        	else {
        		if(s.charAt(i) == '}') {
        			if(closingParans.isEmpty() || '{' != closingParans.pop())
        				return false;
        		}
        		else if(s.charAt(i) == ']') {
           			if(closingParans.isEmpty() ||'[' != closingParans.pop())
        				return false;
        		}
        		else if(s.charAt(i) == ')') {
           			if(closingParans.isEmpty() ||'(' != closingParans.pop())
        				return false;
        		}
        	}
        }
        if(!closingParans.isEmpty())
        	return false;
    	
        
    	return true;
    }	
	
}
