package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScoreN2542 {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] nums2Sorted = new int[nums2.length][2];
        int[] nums1Reordered = new int[nums1.length];
        for(int i = 0; i < nums2.length; i++){
            nums2Sorted[i] = new int[]{nums2[i],i};
        }
        Arrays.sort(nums2Sorted,(a, b)-> b[0] - a[0]);
        for(int i = 0; i < nums2Sorted.length; i++){
            nums1Reordered[i] = nums1[nums2Sorted[i][1]];
        }
        long heapSum = 0;
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for(int i = 0; i <= k-2; i++){
            minHeap.add((long)nums1Reordered[i]);
            heapSum+= nums1Reordered[i];
        }
        long currentScore;
        long maxScore = (heapSum + nums1Reordered[k-1]) * nums2Sorted[k-1][0];
        for(int i = k; i < nums2.length; i++) {
            minHeap.add((long)nums1Reordered[i-1]);
            heapSum+=nums1Reordered[i-1];
            if(minHeap.size() == k){
                heapSum-=minHeap.remove();
            }
            currentScore = (heapSum + nums1Reordered[i]) * nums2Sorted[i][0];
            if(currentScore > maxScore )
                maxScore = currentScore;
        }
        return maxScore;
    }
}
