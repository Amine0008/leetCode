package arraysAndHashing.twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSumN15 {
	
	public static void main(String[] args) {
		System.out.println(threeSum(new int [] {-2,0,0,2,2}));
	}
	
	
	public static  List<List<Integer>> threeSum(int[] nums) {
		 Arrays.sort(nums);
		 List<List<Integer>> result = new ArrayList<>();
		 	int p1;
		 	int p2;
		 
		 
		for(int i = 0; i < nums.length-2; i++) {
		 	if(i !=0 && nums[i] == nums[i-1])
		 		continue;
			 p1 = i+1;
			 p2 = nums.length-1;
			 
			 while(p1 < p2) {
				 if(p1-1 > i &&  nums[p1] == nums[p1-1]) {
					 p1++;
				 }
				 if(p2+1 <= nums.length -1 && nums[p2] == nums[p2+1]) {
					 p2--;
					 continue;
				 }
				 if(nums[p1]+nums[p2] == -nums[i]) {
					result.add(Arrays.asList(nums[i],nums[p2],nums[p1]));
				 	 p1++;
					 p2--;
					 continue;				
					}
				 if((-nums[i]) > nums[p1]+nums[p2])
					 p1++;
				 else
					 p2--;
			 }
			 
		 }
		 return result;
	 }
}
