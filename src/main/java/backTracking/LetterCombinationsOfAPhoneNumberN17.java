package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumberN17 {

	
    public List<String> letterCombinations(String digits) {
    	Map<Integer,List<String>> phoneKeyboard = new HashMap<>();
    	phoneKeyboard.put(2, new ArrayList<>(Arrays.asList(new String[]{"a","b","c"})));
    	phoneKeyboard.put(3, new ArrayList<>(Arrays.asList(new String[]{"d","e","f"})));
    	phoneKeyboard.put(4, new ArrayList<>(Arrays.asList(new String[]{"g","h","i"})));
    	phoneKeyboard.put(5, new ArrayList<>(Arrays.asList(new String[]{"j","k","l"})));
    	phoneKeyboard.put(6, new ArrayList<>(Arrays.asList(new String[]{"m","n","o"})));
    	phoneKeyboard.put(7, new ArrayList<>(Arrays.asList( new String[]{"p","q","r","s"})));
    	phoneKeyboard.put(8, new ArrayList<>(Arrays.asList(new String[]{"t","u","v"})));
    	phoneKeyboard.put(9, new ArrayList<>(Arrays.asList(new String[]{"w","x","y","z"})));
    	
    	if(digits.length() == 0)
    		return new ArrayList<>();
    	if(digits.length() == 1)
			return phoneKeyboard.get(Integer.parseInt(digits));
    	return combine("",digits, phoneKeyboard);
    }
    
    List<String> combine(String first, String second, Map<Integer,List<String>> phoneKeyboard){
    		List<String> firstChars;
    		
    		if(first.length() == 0)
    			firstChars = new ArrayList<>();
    		else
    			firstChars = phoneKeyboard.get(Integer.parseInt(first));

    		List<String> secondChars;
    		if(first.length() == 1 && second.length() == 1)
    			secondChars = phoneKeyboard.get(Integer.parseInt(second));
    		else
    			secondChars = combine(second.substring(0,1),second.substring(1,second.length()),phoneKeyboard);
    		int currentSize = secondChars.size();
    		secondChars = new ArrayList<>(secondChars);
    		for(int i = 0; i < firstChars.size(); i++) {
    			for(int j = 0; j < currentSize; j++) {
    				secondChars.add(firstChars.get(i)+""+secondChars.get(j));
    			}
    		}
    		
            if(first.length() != 0)
            	return secondChars.subList(currentSize+1, secondChars.size());
    		return secondChars;
    	
    	
    }
    
    
    public List<String> letterCombinations2(String digits) {
    	Map<Character,String> phoneKeyboard = new HashMap<>();
    	phoneKeyboard.put('2', "abc");
    	phoneKeyboard.put('3', "def");
    	phoneKeyboard.put('4',"ghi");
    	phoneKeyboard.put('5', "jkl");
    	phoneKeyboard.put('6', "mno");
    	phoneKeyboard.put('7', "pqrs");
    	phoneKeyboard.put('8', "tuv");
    	phoneKeyboard.put('9',"wxyz");
    	if(digits.length() == 0)
    		return new ArrayList<>();
    	return combine("",digits,0,phoneKeyboard);
    }
    
    public List<String> combine(String result, String choices,int  choiceIndex, Map<Character,String> keyboard) {
    	if(choiceIndex == choices.length()) {
    		return Arrays.asList(result);
    	}
    	String keyVals = keyboard.get(choices.charAt(choiceIndex));
    	List<String> r = new ArrayList<>();
    	List<String> holder;
    	for(int i = 0; i < keyVals.length(); i++) {
    		 holder = combine(result+keyVals.charAt(i),choices, choiceIndex+1,keyboard);
    		r.addAll(holder);
    	}
    	return r;
    }
    
    
    
    
    
    
    
    
}
