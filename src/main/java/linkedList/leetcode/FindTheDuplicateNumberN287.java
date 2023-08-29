package linkedList.leetcode;

public class FindTheDuplicateNumberN287 {
	
    public int findDuplicate(int[] nums) {
        int f = nums[0];
        int s = nums[1];
        while(f != s) {
        	f = nums[nums[f]];
        	s = nums[s];
        }
        int s2 = nums[0];
        while(s2 != s) {
        	s2 = nums[s2];
        	s = nums[s];
        }
        return s;
    }

}
