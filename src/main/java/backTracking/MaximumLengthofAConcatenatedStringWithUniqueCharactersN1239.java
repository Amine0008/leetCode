package backTracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthofAConcatenatedStringWithUniqueCharactersN1239 {

	
	public int maxLength(List<String> arr) {
		Set<Character> uniqueChars = new HashSet<>();	   
		int[] currentMax = new int[1];
		comb(currentMax, uniqueChars, arr, 0);
		return currentMax[0];
    }
	
	public void comb(int[] currentMax, Set<Character> sequenceChars, List<String> choices, int choiceIndex) {
		
		if(choiceIndex == choices.size()) {
			if(sequenceChars.size() > currentMax[0])
				currentMax[0] = sequenceChars.size();
			return;
		}
		
		String s = choices.get(choiceIndex);
		boolean thereIsDuplicates = false;
		int lastPositionAdded = 0;
		for(int i = 0; i < s.length(); i++ ) {
			if(sequenceChars.contains(s.charAt(i))) {
				lastPositionAdded = i-1;
				thereIsDuplicates = true;
				break;
			}
			sequenceChars.add(s.charAt(i));
		}
		if(thereIsDuplicates) {
			for(int i = 0; i <= lastPositionAdded; i++ ) {
				sequenceChars.remove(s.charAt(i));
			}
			comb(currentMax, sequenceChars, choices, choiceIndex+1);
		}
		else {
			comb(currentMax, sequenceChars, choices, choiceIndex+1);
			for(int i = 0; i < s.length(); i++ ) {
				sequenceChars.remove(s.charAt(i));
			}
			comb(currentMax, sequenceChars, choices, choiceIndex+1);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
