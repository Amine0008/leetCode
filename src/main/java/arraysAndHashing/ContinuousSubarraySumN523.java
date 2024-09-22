package arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ContinuousSubarraySumN523 {

    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length == 0)
            return false;
        Set<Integer> remainders = new HashSet<>();
        remainders.add(nums[0]%k);
        int sum = nums[0];
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
            if(remainders.contains(sum%k))
                return true;
            remainders.add(sum%k);
        }
        return false;
    }



}
