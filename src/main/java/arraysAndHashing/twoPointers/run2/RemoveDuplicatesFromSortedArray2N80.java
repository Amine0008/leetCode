package arraysAndHashing.twoPointers.run2;

public class RemoveDuplicatesFromSortedArray2N80 {

    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
            return 2;

        int na = nums[0] == nums[1] ? 2 : 1;
        for(int i = na; i < nums.length; i++){
            if(nums[i] == nums[i-1])
                continue;
            nums[na] = nums[i];
            na++;
            if(i+1 < nums.length && nums[i] == nums[i+1]) {
                i++;
                nums[na] = nums[i+1];
                na++;
            }
        }
        return na;
    }
}
