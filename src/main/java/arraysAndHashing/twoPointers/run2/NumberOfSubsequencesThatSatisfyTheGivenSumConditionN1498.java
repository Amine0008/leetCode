package arraysAndHashing.twoPointers.run2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class NumberOfSubsequencesThatSatisfyTheGivenSumConditionN1498 {

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        BigInteger big2pow = BigInteger.TWO;
        int resultCount = 0;

        int left = 0;
        int right = nums.length-1;
        while(left <= right) {
            if(nums[left]+nums[right] > target)
                right--;
            else {
                resultCount = (int) (( resultCount +  powOf2(right-left) ) % (long) 1_000_000_007);
                left++;
            }

        }
        return resultCount;

    }

    public int powOf2(int n) {
        return (int)
                (
                    (BigInteger.TWO.pow(n)
                            .remainder(BigInteger.valueOf(1_000_000_007L)))
                            .longValue()
                );
    }
}
