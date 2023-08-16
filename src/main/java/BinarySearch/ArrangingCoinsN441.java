package BinarySearch;

public class ArrangingCoinsN441 {
    
	public int arrangeCoins(int n) {
		
		int start = 1;
		int end = n;
		int mid = 0;
		
		while(end-start>1) {
			mid = (end - start) / 2 + start;
			if(rowFilled(mid,n))
				start = mid;
			else
				end = mid;
		}
		if(rowFilled(mid, n))
			return mid;
		return mid - 1;
		
    }
	
	public boolean rowFilled(int row, int n) {
		return (long)((long)row*(1+(long)row))/2 <= (long)n;
	}
}
