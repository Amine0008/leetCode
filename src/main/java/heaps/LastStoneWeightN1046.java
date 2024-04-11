package heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeightN1046 {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(Integer weight: stones) {
            maxHeap.add(weight);
        }
        int stoneX;
        int stoneY;
        while(maxHeap.size() > 1) {
            stoneX = maxHeap.remove();
            stoneY = maxHeap.remove();
            if(stoneX != stoneY)
                maxHeap.add(Math.abs(stoneX - stoneY));
        }
        if(maxHeap.isEmpty())
            return 0;
        return maxHeap.remove();

    }

}
