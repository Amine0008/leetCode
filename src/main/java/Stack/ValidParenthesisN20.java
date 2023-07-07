package Stack;

import java.util.Stack;

public class ValidParenthesisN20 {
	public static void main(String[] args) {
		isValid("()");
	}
	
	public static boolean isValid(String s) {
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

}
