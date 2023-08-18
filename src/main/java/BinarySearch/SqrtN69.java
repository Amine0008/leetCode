package BinarySearch;

public class SqrtN69 {
	
    public int mySqrt(int x) {
     
    	int start = 1;
    	int end = x;
    	int mid;
    	int result = 0;
    	
    	while(start<=end) {
    		mid = (end - start) / 2 +start;
    		
    		if((long)mid*(long)mid == (long) x)
    			return mid;
    		if((long)mid*(long)mid < (long) x) {
    			start = mid + 1;
    			result = mid;
    		}
    		else
    			end = mid - 1 ;
    	}
    	return result;
    	
    }

}
