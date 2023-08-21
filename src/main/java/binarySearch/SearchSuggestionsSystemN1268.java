package binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class SearchSuggestionsSystemN1268 {

	public static void main(String[] args) {
		String[] products = new String[] {"bags","baggage","banner","box","cloths"};
		String searchword = "bags";
		suggestedProducts(products,searchword);
	}
	
       public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
    	   Arrays.sort(products);
    	   int left = 0;
    	   int right = products.length-1;
    	   List<List<String>> result = new ArrayList<>();
    	   for(int i = 0; i<searchWord.length();i++) {
    		  result.add(new ArrayList<>());
    	   }
    	   boolean rightFound = false;
    	   boolean leftFound = false;
    	   while(left <= right && !leftFound && !rightFound) {
    		   if(products[left].charAt(0) != searchWord.charAt(0))
    			   left ++;
    		   else 
    			   leftFound = true;
    		   if(products[right].charAt(0) != searchWord.charAt(0))
    			   right --;
    		   else
    			   rightFound = true;
    	   }
    	   
    	   if(left<0)
    		   return result;
    	   for(int i = 0; i<searchWord.length(); i++) {
    		   List<String> prefixResult = result.get(i);
    		   
    		   for(int j = left; j<=right; j++) {
    			   if(prefixResult.size() == 3)
    				   break;
    			   if(products[j].length()>=i+1 &&  products[j].charAt(i) == searchWord.charAt(i))
    				   prefixResult.add(products[j]);
    			   else {
    				   if(prefixResult.size() > 0)
    					   right = j-1;
    				   else
    					   left = j+1;
    			   }
//    			   if(products[right-j+left].charAt(i) != searchWord.charAt(i))
//    				   right = right - 1;
    				   
    			   
    		   }
    	   }
    	   return result;
    }
    

}
