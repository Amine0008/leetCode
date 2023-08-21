package arraysAndHashing;


//mala 7arb yazebi
public class MoveZeroesN283 {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] {0,0,1,2,3,0,0};
		moveZeroes(array);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	//001 -> 010
	//0,0,1,2,3,0,0
	//1,0,0,0,54,3
    public static void moveZeroes(int[] nums) { 
    	int positionOfNextZero = nums.length-1;
    	for(int  i = nums.length-1; i>=0 ;i--) {
    		if(nums[i] == 0)
    			positionOfNextZero--;
    		else break;
    	}
    	int numOfconsecutiveZeros = 1;
    	for(int i = 0; i <= positionOfNextZero; i++) {
    		if(nums[i] == 0) {
    			int j = i;
    			while(true) {
    				if(j>= nums.length-1)
    					break;
    				j++;
    				if(nums[j]==0)
    					numOfconsecutiveZeros++;
    				else
    					break;
    			}
    			for(int f = i; f < positionOfNextZero; f++) {
    				if(f+numOfconsecutiveZeros < nums.length)
    					nums[f] = nums[f+numOfconsecutiveZeros];
    			}
    			while(numOfconsecutiveZeros > 0) {
    				nums[positionOfNextZero] = 0;
    				positionOfNextZero--;
    				numOfconsecutiveZeros--;
    			}
    			numOfconsecutiveZeros=1;
    			
    			
    		}
    		
    	}
    }

}
