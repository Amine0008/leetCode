
package arraysAndHashing;

import java.util.HashMap;

public class TwoSumN1 {
	
	public static void main(String[] args) {
		
		twoSumHashtable(new int[] {3,3},6);
	}
	
	//two sum brute force o(n^2)
	 public int[] twoSumBruteForce(int[] nums, int target) {
		 
		 int[] result = new int[2];
		 for(int i = 0; i < nums.length; i++) {
			 result[0] = i;
			 for(int j = i+1; j < nums.length; j++) {
				 if (j==i)
					 continue;
				 if(nums[i]+nums[j] == target) {
					 result[1] = j;
					 return result;
				 }
					 
			 }
		 }
		 
		 return null;
    }
	 
	 //two sum with hashMap o(n)
	 public static int[] twoSumHashtable(int[] nums, int target) {
		 HashMap<Integer,Integer> map = new HashMap<>();
		 int[] result = new int[2];
		 for(int i = 0;i <nums.length; i++) {
			 if(map.containsKey(nums[i])) {
				 map.replace(nums[i], i);
			 }
			 else 
				 map.put(nums[i], i);
		 }
		 for(int i = 0;i <nums.length; i++) {
			 result[0]= i;
			 if(map.containsKey(target-nums[i]) && !map.get(target-nums[i]).equals(i)) {
				 result[1] = map.get(target-nums[i]);
				 return result;
			 }	 
		 }
		 return null;
    }
}
