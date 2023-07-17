package Stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesesN22 {

	public static void main(String[] args) {
	}
	
    public List<String> generateParenthesis(int n) {
    	List<String> result = new ArrayList<>();
    	backTrackToHell(result,
    			"(",
    			1,
    			0,
    			n*2);
    
    	return result;
    }
    
    void backTrackToHell(List<String> listOfValidCombinations, 
    		String currentComb, 
    		int numberOfOpen, 
    		int numberOfClosing,
    		int maxParensInComb) {
    	if(currentComb.length() == maxParensInComb) {
    		listOfValidCombinations.add(currentComb);
    		return;
    	}
    	if(numberOfOpen == maxParensInComb/2) { 
    		 backTrackToHell(listOfValidCombinations,currentComb+")",numberOfOpen,numberOfClosing+1,maxParensInComb);
    		 return;
    	}
    	if(numberOfOpen > numberOfClosing) {
    		backTrackToHell(listOfValidCombinations, currentComb+"(",numberOfOpen+1,numberOfClosing, maxParensInComb);
    		backTrackToHell(listOfValidCombinations, currentComb+")",numberOfOpen, numberOfClosing+1, maxParensInComb);
    		return;
    	}
    	if(numberOfOpen == numberOfClosing) {
    		backTrackToHell(listOfValidCombinations, currentComb+"(",numberOfOpen+1, numberOfClosing, maxParensInComb);
    		return;
    	}
    }

}
