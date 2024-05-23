package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CarPoolingN1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)->a[1]-b[1]);
        int cpc = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int[] trip: trips) {
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= trip[1]){
                cpc-= minHeap.remove()[1];
            }
            if(capacity-cpc >= trip[0]){
                cpc+=trip[0];
                minHeap.add(new int[]{trip[2],trip[0]});
            }
            else
                return false;
        }
        while(!minHeap.isEmpty()){
            cpc-=minHeap.remove()[1];
        }
        return cpc == 0;

    }
}
