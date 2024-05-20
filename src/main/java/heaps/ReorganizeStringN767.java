package heaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeStringN767 {

    public String reorganizeString(String s) {
        Map<Character, Integer> charCounterMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!charCounterMap.containsKey(s.charAt(i)))
                charCounterMap.put(s.charAt(i), 0);
            charCounterMap.put(s.charAt(i), charCounterMap.get(s.charAt(i)) + 1);
        }
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(char charkey: charCounterMap.keySet()){
            maxHeap.add(new int[]{charkey, charCounterMap.get(charkey)});
        }
        int previousChar = -1;
        int[] holder1,holder2;
        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            holder1 = maxHeap.remove();
            if(holder1[0] != previousChar){
                sb.append((char)holder1[0]);
                holder1[1]--;
                if(holder1[1] != 0)
                    maxHeap.add(holder1);
            previousChar = holder1[0];
            continue;
            }
            if(maxHeap.isEmpty())
                return "";
            holder2 = maxHeap.remove();
            sb.append((char)holder2[0]);
            holder2[1]--;
            if(holder2[1] != 0)
                maxHeap.add(holder2);
            previousChar = holder2[0];
            maxHeap.add(holder1);

        }
        return sb.toString();


    }

}
