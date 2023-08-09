package ArraysAndHashing;

public class PlusOneN66 {

	public static void main(String[] args) {
	}
	
	
    public int[] plusOne(int[] digits) {
    	return incrementElement(digits,digits.length-1);
    }
    
    private int[] incrementElement(int[] digits, int index) {
    	if(index == -1) {
    		int[] newdigits = new int[digits.length+1];
    		for(int i = digits.length-1;i>0;i--) {
    			newdigits[i] = digits[i];
    		}
    		newdigits[0] = 1;
    		return newdigits;
    		
    	}
    	if(digits[index]<9) {
    		digits[index] = digits[index] + 1;
    		return digits;
    	}
    	else {
    		digits[index] = 0;
    		return incrementElement(digits,index-1);
    	}
    		
    }

}
