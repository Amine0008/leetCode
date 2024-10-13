package arraysAndHashing.twoPointers.run2;

import java.util.Arrays;

public class RotateArrayN189 {

    public void rotate(int[] nums, int k) {
        int[] result = nums.clone();

        for(int i = 0; i < nums.length; i++){
            nums[(i+k)%nums.length] = result[i];
        }

    }
}


