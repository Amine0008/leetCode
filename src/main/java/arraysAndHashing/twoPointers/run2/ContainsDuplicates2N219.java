package arraysAndHashing.twoPointers.run2;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates2N219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= k && i < nums.length; i++) {
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        if(set.contains(nums[0]))
            return true;
        for(int i = 1; i < nums.length; i++){
            set.remove(nums[i]);
            if(i+k < nums.length) {
                if(set.contains(nums[i+k]))
                    return true;
                set.add(nums[i+k]);
            }
            if(set.contains(nums[i]))
                return true;
        }
        return false;
    }

}
