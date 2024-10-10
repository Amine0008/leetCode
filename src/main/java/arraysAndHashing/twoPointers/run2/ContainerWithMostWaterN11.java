package arraysAndHashing.twoPointers.run2;

public class ContainerWithMostWaterN11 {

    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxWater = Integer.MIN_VALUE;
        while(left < right) {
            maxWater = Math.max(maxWater, (right-left)*Math.min(height[left],height[right]));
            if(height[left]>height[right])
                right--;
            else
                left++;
        }
        return maxWater;
    }
}
