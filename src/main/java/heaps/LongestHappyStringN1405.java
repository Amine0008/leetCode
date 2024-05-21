package heaps;

import java.util.PriorityQueue;

public class LongestHappyStringN1405 {

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        char lc = '*';
        char slc = '*';
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)->y[1]-x[1]);
        if(a != 0)
            maxHeap.add(new int[]{'a',a});
        if(b != 0)
            maxHeap.add(new int[]{'b', b});
        if(c != 0)
            maxHeap.add(new int[]{'c',c});
        assert !maxHeap.isEmpty();
        int[] holder1;
        int[] holder2;
        while(!maxHeap.isEmpty()){
            holder1 = maxHeap.remove();
            if(lc == slc && holder1[0] == lc) {
                if(maxHeap.isEmpty())
                    return sb.toString();
                holder2 = maxHeap.remove();
                sb.append((char)holder2[0]);
                holder2[1]--;
                slc = lc;
                lc = (char)holder2[0];
                maxHeap.add(holder1);
                if(holder2[1] != 0)
                    maxHeap.add(holder2);
            }
            else {
                sb.append((char)holder1[0]);
                holder1[1]--;
                slc = lc;
                lc = (char)holder1[0];
                if(holder1[1] != 0)
                    maxHeap.add(holder1);
            }
        }
        return sb.toString();
    }

}
