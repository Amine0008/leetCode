package heaps;

import java.util.*;

public class FindMedianFromDataStreamN295 {

    class MedianFinder {
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;

        public MedianFinder() {
            this.maxHeap = new PriorityQueue<>((a,b)->b-a);
            this.minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
                if(maxHeap.size() == minHeap.size() || minHeap.size() > maxHeap.size())
                    maxHeap.add(num);
                else{
                    minHeap.add(maxHeap.remove());
                    maxHeap.add(num);
                }
            }
            else if(minHeap.isEmpty() ||minHeap.peek() <= num) {
                if(minHeap.size() == maxHeap.size() || maxHeap.size() > minHeap.size())
                    minHeap.add(num);
                else{
                    maxHeap.add(minHeap.remove());
                    minHeap.add(num);
                }
            }
            else {
                if(minHeap.size() == maxHeap.size())
                    minHeap.add(num);
                else{
                    PriorityQueue<Integer> heapWithLowerSize = minHeap.size() > maxHeap.size() ? maxHeap : minHeap;
                    heapWithLowerSize.add(num);
                }
            }

        }

        public double findMedian() {
            if(minHeap.size() == maxHeap.size())
                return (double) (minHeap.peek() + maxHeap.peek()) /2;
            PriorityQueue<Integer> heapWithHigherSize = minHeap.size() > maxHeap.size() ? minHeap : maxHeap;
            return heapWithHigherSize.peek();
        }
    }
}
