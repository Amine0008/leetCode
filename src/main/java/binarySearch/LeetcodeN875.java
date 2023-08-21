package binarySearch;

public class LeetcodeN875 {

	public static void main(String[] args) {

		int[] piles = new int[]{312884470};
		minEatingSpeed(piles,312884469);
		
	}
	
    public static int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = piles[0];
        for(int i = 0; i<piles.length; i++) {
        	if(piles[i] > maxSpeed)
        		maxSpeed = piles[i];
        }
        
        int left = 1;
        int right = maxSpeed;
        int mid;
        int result = 1;
        int hoursTaken;
        while(left <= right) {
        	mid = (right-left)/2+left;
        	hoursTaken = 0;
        	for(int i = 0; i<piles.length; i++) {
        		if(piles[i]%mid == 0)
        			hoursTaken +=piles[i]/mid;
        		else {
        			hoursTaken += ( 1  + (piles[i]/mid));
        		}
        	}
        	if(hoursTaken == h) {
        		result = mid;
        		right = mid - 1;
        	}
        	else if(hoursTaken>h) {
        		left = mid + 1;
        	}
        	else 
        		right = mid - 1;
        		
        }
    	return result;	
    }

}
