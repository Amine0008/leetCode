package arraysAndHashing.twoPointers.run2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesfromSortedArrayN26 {

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0)
            return 0;
        int na = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                continue;
            nums[na] = nums[i];
            na++;
        }
        return na;

    }
}
