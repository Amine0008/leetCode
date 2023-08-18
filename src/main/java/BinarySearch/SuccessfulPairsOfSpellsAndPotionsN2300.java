package BinarySearch;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotionsN2300 {
	
	public static void main(String[]args) {

	}
	
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
     Arrays.sort(potions); 
     int[] result = new int[spells.length];
     
     for(int i = 0; i < spells.length; i++) {
    	 result[i] = getSpellSucessPotionCounter( spells[i], potions, success);
     }
     return result;
    }
    
    public int getSpellSucessPotionCounter( int spellStrength, int[] potions, long successBar) {
    	int right = potions.length - 1;
    	int left = 0;
    	int mid;
    	int firstSuccessPotionIndex = Integer.MAX_VALUE;
    	
    	while(left <= right) {
    		mid = (right-left)/2+left;
    		if((long)potions[mid] * (long)spellStrength >= successBar) {
    			if(mid < firstSuccessPotionIndex)
    				firstSuccessPotionIndex = mid;
    			right = mid - 1;
    		}
    		else 
    			left = mid + 1;
    	}
   		if(firstSuccessPotionIndex == Integer.MAX_VALUE)
			return 0;
		else
			return potions.length-firstSuccessPotionIndex;
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    

}
