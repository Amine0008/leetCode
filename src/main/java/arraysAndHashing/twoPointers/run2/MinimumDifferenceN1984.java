package arraysAndHashing.twoPointers.run2;

import java.util.Arrays;

public class MinimumDifferenceN1984 {

    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int currentMin = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(i+k-1 >= nums.length)
                return currentMin;
            currentMin = Math.min(currentMin, nums[i + k - 1] - nums[i]);
        }
        return currentMin;
    }

}
