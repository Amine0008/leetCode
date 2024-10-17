package arraysAndHashing.twoPointers.run2;

import java.util.Arrays;


public class ArrayWithElementsNotEqualToAverageOfNeighborsN1968 {
    
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int holder;
        for(int i = 1; i <= nums.length-1; i+=2) {
            holder = nums[i-1];
            nums[i-1] = nums[i];
            nums[i] = holder;
        }
        return nums;
    }
}
