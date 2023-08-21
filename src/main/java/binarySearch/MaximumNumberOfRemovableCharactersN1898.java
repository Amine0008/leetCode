package binarySearch;

import java.util.Arrays;

public class MaximumNumberOfRemovableCharactersN1898 {
	
	public static void main(String[] args) {
		maximumRemovals("abcacb","ab",new int[] {3,1,0});
	Arrays.fill(new int[] {}, 5);
	}
	

	  public static int maximumRemovals(String s, String p, int[] removable) {
		int result = 0;
		int left = 0;
		int right = removable.length-1;
		int mid;
		boolean subArrayIsRemovable = false;
		StringBuilder sb = new StringBuilder(s);
		while(left <= right) {
			mid = (right-left)/2+left;
			subArrayIsRemovable = false;
			for(int i = left;i <=mid; i++) {
				if(isSubsequence(new StringBuilder(sb).replace(removable[i], removable[i]+1, "#").toString(),p)) {
					sb.replace(removable[i], removable[i]+1, "#"); 
					subArrayIsRemovable = true;
					result++;
				}
				else {
					subArrayIsRemovable = false;
					break;
				}
			}
			if(!subArrayIsRemovable)
				return result;
			else
				left = mid+1;
		}
		return result;
		
	  }
    
    public static boolean isSubsequence(String original, String sub) {
    	int startPos = 0;
    	boolean found = false;
    	for(int i = 0; i<sub.length(); i++) {
    		for(int j = startPos; j< original.length(); j++) {
    			if(original.charAt(j) == sub.charAt(i)) {
    				found = true;
    				startPos = j+1; 
    				break;
    			}
    		}
    		if(!found)
    			return false;
    		found = false;
    	}
    	return true;
    }

}
