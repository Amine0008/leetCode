package binarySearch;

public class ValidPerfectSquareN367 {

  public boolean isPerfectSquare(int num) {
     
	 long start = 1; 
	 long end = num;
	 long mid; 
	 
	 while(start <= end) {
		 mid = (end - start) / 2 + start;
		 if(mid * mid == num)
			 return true;	
		 if(mid * mid > (long)num)
			 end = mid-1;
		 else
			 start = mid + 1;
	 }
	 return false;
    }
}
