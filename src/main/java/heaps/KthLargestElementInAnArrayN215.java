package heaps;

import java.util.PriorityQueue;

public class KthLargestElementInAnArrayN215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int x: nums) {
            if(minHeap.size() < k) {
                minHeap.add(x);
                continue;
            }
            if(minHeap.peek() >= x)
                continue;
            minHeap.remove();
            minHeap.add(x);
        }
        return minHeap.remove();


    }
}
