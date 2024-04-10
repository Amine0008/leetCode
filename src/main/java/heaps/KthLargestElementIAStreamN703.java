package heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthLargestElementIAStreamN703 {


    class KthLargest {
        PriorityQueue<Integer> minHeap;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            minHeap = new PriorityQueue<>();
            Arrays.sort(nums);
            for(int i = nums.length-1; i >= nums.length-k && i >= 0; i--){
                minHeap.add(nums[i]);
            }

        }

        public int add(int val) {
            if(minHeap.size() < k) {
                minHeap.add(val);
                return minHeap.peek();
            }
            if(minHeap.peek() < val ) {
                minHeap.remove();
                minHeap.add(val);
            }
            return minHeap.peek();

        }
    }

}
