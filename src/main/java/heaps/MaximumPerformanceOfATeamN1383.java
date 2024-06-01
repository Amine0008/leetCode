package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeamN1383 {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Integer[] engineersByEff = new Integer[n];
        for(int i = 0; i <n; i++){
            engineersByEff[i] = i;
        }
        Arrays.sort(engineersByEff, (a,b) -> efficiency[b] - efficiency[a]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long heapSum = 0;
        long highestPerf = (long)speed[engineersByEff[0]] * efficiency[engineersByEff[0]];
        long highestPerfTeamWithThisEng;
        for(int i = 1; i < n; i++){
            heapSum+=speed[engineersByEff[i-1]];
            minHeap.add(speed[engineersByEff[i-1]]);
            if(minHeap.size() == k) {
                heapSum-= minHeap.remove();
            }
            highestPerfTeamWithThisEng
                = (heapSum + speed[engineersByEff[i]])* efficiency[engineersByEff[i]];
            if(highestPerfTeamWithThisEng > highestPerf)
                highestPerf = highestPerfTeamWithThisEng;
        }
        return (int) (highestPerf % (long)(1e9 + 7));


    }
}
