package arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class NumberOfPairsOfInterchangeableRectanglesN2001 {

    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double,Integer> ratioRectangleCounterMap = new HashMap<>();
        double ratioHolder;
        for(int[] rectangle: rectangles) {
            ratioHolder = (double)rectangle[0]/(double)rectangle[1];
            if(!ratioRectangleCounterMap.containsKey(ratioHolder))
                ratioRectangleCounterMap.put(ratioHolder,0);
            ratioRectangleCounterMap.put(ratioHolder, ratioRectangleCounterMap.get(ratioHolder)+1);
        }

        long result = 0;
        for(Integer ratioCounter: ratioRectangleCounterMap.values()) {
            result += ((long) ratioCounter *(ratioCounter-1)/2);
        }
        return result;
    }
}
