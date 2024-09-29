package arraysAndHashing;

public class NumberOfZeroFilledSubarraysN2348 {

    public long zeroFilledSubarray(int[] nums) {

        int currentP = 0;
        int groupCount;
        long subarraysCount = 0;

        while(currentP < nums.length)
        {
            if(nums[currentP] != 0)
            {
                currentP++;
                continue;
            }
            groupCount = 1;
            for(int i = currentP+1; i < nums.length; i++)
            {
                if(nums[i] != 0){
                    currentP = i;
                    break;
                }
                currentP = i;
                groupCount++;

            }
            currentP++;
            subarraysCount+=((long) groupCount *(groupCount+1)/2);

        }
        return subarraysCount;

    }

}
