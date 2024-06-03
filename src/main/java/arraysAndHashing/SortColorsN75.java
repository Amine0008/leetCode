package arraysAndHashing;

public class SortColorsN75 {

    public void sortColors(int[] nums) {
        int redCounter = 0;
        int blueCounter = 0;
        int whiteCounter = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                redCounter++;
            else if(nums[i] == 1)
                whiteCounter++;
            else if(nums[i] == 2)
                blueCounter++;
        }
        for(int i = 0; i < nums.length; i++){
            if(redCounter != 0){
                nums[i] = 0;
                redCounter--;
                continue;
            }
            if(whiteCounter != 0) {
                nums[i] = 1;
                whiteCounter--;
                continue;
            }
            if(blueCounter != 0) {
                nums[i] = 2;
                blueCounter--;
            }


        }


    }


    public void sortColors2(int[] nums) {
        int temp;
        int l = 0;
        int r = nums.length-1;
        int i = 0;
        while(i <= r){
            if(nums[i] == 0){
                temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                i++;
                l++;
                continue;
            }
            if(nums[i] == 2) {
                temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;
                continue;
            }
            i++;
        }

    }
    }
