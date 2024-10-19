package arraysAndHashing.twoPointers.run2;

public class NumberOfSubArraysOfSizeKAndAverageGreaterThanOrEqualToThresholdN1343 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        double size = k;
        double target = threshold;
        double currentSum = 0;
        int counter = 0;
        for(int i = 0; i <k; i++){
            currentSum+=arr[i];
        }
        if(currentSum/size >= target)
            counter++;

        for(int i = 1; i < arr.length; i++){
            if(i+k-1 == arr.length)
                break;
            currentSum-=arr[i-1];
            currentSum+=arr[i+k-1];
            if(currentSum/size >= target)
                counter++;
        }
        return counter;

    }
}
