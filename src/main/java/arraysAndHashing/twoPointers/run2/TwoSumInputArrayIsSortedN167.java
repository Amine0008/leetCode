package arraysAndHashing.twoPointers.run2;

public class TwoSumInputArrayIsSortedN167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        int currentSum;
        int[] result = new int[2];
        while(left < right) {
            currentSum = numbers[left]+numbers[right];
            if(currentSum == target){
                result = new int[]{left+1, right+1};
                break;
            }
            if(currentSum < target)
                left++;
            else
                right--;
        }
        return result;
    }
    public int[] twoSum2(int[] numbers, int target) {
        int holder;
        int[] result = new int[2];
        for(int i = 0; i < numbers.length-1; i++){
            holder = runBinarySearchIteratively(numbers, target - numbers[i], i+1, numbers.length-1);
            if(holder != numbers.length){
                result = new int[]{i+1,holder+1};
                break;
            }
        }
        return result;
    }

    public int runBinarySearchIteratively(int[] sortedArray, int key, int low, int high) {
        int index = sortedArray.length;

        while (low <= high) {
            int mid =(high + low) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }


}
