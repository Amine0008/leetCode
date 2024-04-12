package heaps;

import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestPointsToOriginN973 {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxDistHeap = new PriorityQueue<>((a,b)->pointDistanceToOrigin(b)>pointDistanceToOrigin(a)?1:-1);
        for(int[] point: points) {
            if(maxDistHeap.size() < k) {
                maxDistHeap.add(point);
                continue;
            }
            if(pointDistanceToOrigin(point) >= pointDistanceToOrigin(maxDistHeap.peek()))
                continue;
            maxDistHeap.remove();
            maxDistHeap.add(point);
        }
        int[][] resultPoints = new int[k][];
        int index = 0;
        for(int[] point: maxDistHeap){
            resultPoints[index] = point;
            index++;
        }
        return resultPoints;
    }

    public double pointDistanceToOrigin(int[] point) {
        return Math.sqrt(point[0]*point[0]+point[1]*point[1]);
    }
}
