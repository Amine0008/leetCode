package binarySearch;

public class CapacityToShipPackagesWithinDDaysN1011 {
	
	public static void main(String[] args) {
//		int[] input = new int[] {1,2,3,4,5,6,7,8,9,10};
//		shipWithinDays(input,5);
	
	}
	
    public int shipWithinDays(int[] weights, int days) {
     
    	int weightsSum = 0;
    	int minCapacity = weights[0];
    	for(int i = 0; i < weights.length; i++) {
    		weightsSum += weights[i];
    		if(weights[i] > minCapacity)
    			minCapacity = weights[i];
    	}
    	
    	//weightsSum == MAX CAPACITY
    	
    	int left = minCapacity;
    	int right = weightsSum;
    	int possibleCapacity = 0;
    	int mid;
    	
    	while(left <= right) {
    		mid = (right-left) / 2 + left;
    	
    	if(canShipWithCapacity(mid, weights, days)) {
    		possibleCapacity = mid;
    		right = mid-1;
    	}
    	else
    		left = mid+1;
    		
    		
    		
    	}
    	return possibleCapacity;
    	
    	
    }
    
    public boolean  canShipWithCapacity(int capacity, int[] weights, int  days) {
    	int numberOfDays = 1;
    	int currentLoad = 0;
    	
    	for(int i = 0; i < weights.length; i++) {
    		if(currentLoad+weights[i] > capacity) {
    			numberOfDays++;
    			currentLoad=weights[i];
    		}
    		else {
    			currentLoad+=weights[i];
    		}
    	}
    	return numberOfDays <= days; 
    	
    }

    
   
}
