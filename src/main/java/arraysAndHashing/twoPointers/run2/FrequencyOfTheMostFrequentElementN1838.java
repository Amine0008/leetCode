package arraysAndHashing.twoPointers.run2;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElementN1838 {

    public int maxFrequency(int[] nums, int k) {
        if(nums.length == 1)
            return 1;
        Arrays.sort(nums);
        long cs = nums[0];
        int left = 0;
        int right = 0;
        int currentMax = 1;
        while(left<=right){
            if(  ((long) (right - left + 1) *(long) nums[right]) - cs <= k ) {
                //valid windows
                currentMax = Math.max(currentMax, (right-left+1));
                right++;
                if(right == nums.length)
                    return currentMax;
                cs+=nums[right];
            }
            else {
                cs-=nums[left];
                left++;
            }

        }
        return currentMax;
    }

}
