package arraysAndHashing;

public class NondecreasingArrayN665 {
    public boolean checkPossibility(int[] nums) {
        int counter = 0;
        int currentMax = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(nums[i] < currentMax){
                counter++;
                if(counter == 2)
                    return false;

                if(i == 1)
                    currentMax = nums[i];
                else{
                    if(nums[i] >= nums[i-2])
                        currentMax = nums[i];
                    else
                        currentMax = nums[i-1];
                }
            }
            else
                currentMax = Math.max(currentMax, nums[i]);
        }
        return true;
    }

}
