package arraysAndHashing;

public class FirstMissingPositiveN41 {

    public int firstMissingPositive(int[] nums) {
       boolean[] holder = new boolean[2];
       int n  = nums.length;
       for(int i = 0; i < n; i++) {
           if(nums[i] <= 0)
               nums[i] = n+2;
       }
       for(int i = 0; i < n; i++){
           if(Math.abs(nums[i]) >= n+2)
               continue;
           if(Math.abs(nums[i]) == n){
               holder[0] = true;
               continue;
           }
           if(Math.abs(nums[i]) == n+1) {
               holder[1] = true;
               continue;
           }

           nums[Math.abs(nums[i])] = - Math.abs(nums[Math.abs(nums[i])]);
       }
           for(int i = 1; i < n; i++){
               if(nums[i] > 0)
                   return i;
           }
       if(!holder[0])
           return n;
       return n+1;
    }
}
