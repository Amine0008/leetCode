package heaps;

import java.util.*;

public class TaskSchedulerN621 {


    public int leastInterval(char[] tasks, int n) {
        int t = 0, tec = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        Queue<int[]> groupQ = new LinkedList<>();
        Map<Integer,Integer> tasksCounterMap = new HashMap<>();
        for(char c: tasks) {
            if(!tasksCounterMap.containsKey((int)c))
                tasksCounterMap.put((int) c,0);
            tasksCounterMap.put((int) c,tasksCounterMap.get((int) c) + 1 ) ;
        }
        maxHeap.addAll(tasksCounterMap.values());

        int[] groupHolder;
        int largestGroup;
        while(tec < tasks.length) {
            if(!groupQ.isEmpty()){
                groupHolder = groupQ.peek();
                if(groupHolder[1] <= t){
                    maxHeap.add(groupHolder[0]);
                    groupQ.remove();
                }
            }
            if(!maxHeap.isEmpty()) {
                largestGroup = maxHeap.remove();
                tec++;
                if(largestGroup-1 > 0)
                    groupQ.add(new int[]{largestGroup-1,t+1+n});
            }
            t++;
        }
        return t;
    }


}
