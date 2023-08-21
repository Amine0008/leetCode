package arraysAndHashing.twoPointers;

public class ValidPalindromeN125 {

	
	public boolean isPalindrome(String s) {

		// ASCII 0:48
		// ASCII 9:57
		
		// ASCII a:97
		// ASCII z:122
		
		s = s.toLowerCase();
		int p1 = 0;
		int p2 = s.length()-1;
		
		while(p1 < p2 ) {
			if(s.charAt(p1) < 0 || s.charAt(p1) > 57 && s.charAt(p1) < 97 || s.charAt(p1) > 122) {
				p1++;
				continue;
			}
				
			if(s.charAt(p2) < 0 || s.charAt(p2) > 57 && s.charAt(p2) < 97 || s.charAt(p2) > 122) {
				p2--;
				continue;
			}
			if(s.charAt(p1) != s.charAt(p2))
				return false;
			else {
				p1++;
				p2--;
			}
			
			
		}
		
		return true;
	}

}
