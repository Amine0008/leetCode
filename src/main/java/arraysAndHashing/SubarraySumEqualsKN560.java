package arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsKN560 {

    public int subarraySum(int[] nums, int k) {
        int resultCounter = 0;
        int subArraySum = 0;
        int subArraysFromElementCounter;
        for(int i = 0; i < nums.length; i++){
            subArraysFromElementCounter = 0;
            subArraySum = nums[i];
            if(subArraySum == k)
                subArraysFromElementCounter++;
            for(int j = i+1; j < nums.length; j++) {
                subArraySum+=nums[j];
                if(subArraySum == k)
                    subArraysFromElementCounter++;
            }
            resultCounter+=subArraysFromElementCounter;
        }
        return resultCounter;
    }
    public int subarraySum2(int[] nums, int k) {
        int sum = 0, count = 0, start = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(sum == k) {
                count++;
            }
            if(mp.containsKey(sum-k)) {
                count += mp.get(sum-k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0)+1);

            //System.out.println(count);
        }
        return count;
    }
}
