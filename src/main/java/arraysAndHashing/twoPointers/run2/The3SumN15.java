package arraysAndHashing.twoPointers.run2;

import kotlin.Triple;

import java.util.*;

public class The3SumN15 {

    public static void main(String[] args){
        Set<List<Integer>> mySet = new HashSet<>();
        mySet.add(List.of(1,2,3));
        mySet.add(List.of(1,2,3));
        System.out.println("the size : "+mySet.size());
    }
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        int left;
        int right;
        for (int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            left = i+1;
            right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right]+nums[i] ==0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left < right && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] < -nums[i])
                    left++;
                else
                    right--;
            }

        }
        return result;
    }

}
