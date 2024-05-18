package heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SingleThreadeCPUN1834 {

    public int[] getOrder(int[][] tasks) {
        int completedTasks = 0;
        int numberOfTasks = tasks.length;
        int[][] sortedTasks = new int[tasks.length][3];
        for(int i = 0; i < tasks.length; i++){
            sortedTasks[i] = new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(sortedTasks,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });
        long currentTime = sortedTasks[0][0];

        int[] result = new int[numberOfTasks];
        int resultIndex = 0;
        int lastAvailableTask = -1;
        int[] executedTask;
        while(completedTasks < numberOfTasks) {
            if(minHeap.isEmpty() && currentTime < sortedTasks[lastAvailableTask+1][0])
                currentTime = sortedTasks[lastAvailableTask+1][0];
            for(int i = lastAvailableTask+1; i < numberOfTasks; i++){
                if(sortedTasks[i][0] <= currentTime) {
                    minHeap.add(new int[]{sortedTasks[i][1], sortedTasks[i][2]});
                    lastAvailableTask++;
                }
                else
                    break;
            }
            if(minHeap.isEmpty()){
                currentTime++;
                continue;
            }
            executedTask = minHeap.remove();
            currentTime+=executedTask[0];
            result[resultIndex++] = executedTask[1];
            completedTasks++;
        }
        return result;
    }


}
