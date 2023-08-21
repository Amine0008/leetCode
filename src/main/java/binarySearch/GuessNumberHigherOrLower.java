package binarySearch;

public class GuessNumberHigherOrLower {
	
	
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int middle ;
        int guess;
        while(start <= end) {
        	middle = (end-start/2)+start;
        	guess = this.guess(middle);
        	if(guess == 0)
        		return middle;
        	if(guess<0)
        		end = middle - 1;
        	else
        		start = middle + 1;
        
        	
        }
        return -1;
        
    }
    
    
    public int guess(int num) {
    	return -1;
    }
}
