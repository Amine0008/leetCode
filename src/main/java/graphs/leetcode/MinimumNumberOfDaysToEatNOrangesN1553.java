package graphs.leetcode;

import java.util.*;

public class MinimumNumberOfDaysToEatNOrangesN1553 {


    public int minDays2(int n) {
        Map<Integer,Integer> minDaysToEatOranges = new HashMap<>();

        minDaysToEatOranges.put(0,0);
        minDaysToEatOranges.put(1,1);
        minDaysToEatOranges.put(2,2);
        minDaysToEatOranges.put(3,2);

        int currentMin;
        int holder;
        for(int i = 4; i <=  n; i++){
            currentMin = 1+minDaysToEatOranges.get(i-1);
            if(i%2 == 0){
                holder = 1+ minDaysToEatOranges.get(i/2);
                if(holder < currentMin)
                    currentMin = holder;
            }
            if(i%3 == 0){
                holder = 1+minDaysToEatOranges.get(i/3);
                if(holder < currentMin)
                    currentMin = holder;
            }
            minDaysToEatOranges.put(i, currentMin);

            if(i%3 == 0){
                for(int j = 0; j < i/3 && j >=0; j++){

                }

            }


        }
        return minDaysToEatOranges.get(n);



    }


    public int minDays(int n) {
        int waveSize;
        LinkedList<Integer> waveNodes = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int dayCounter = 0;
        waveNodes.add(n);
        int node;
        while(!waveNodes.isEmpty()){
            waveSize = waveNodes.size();
            dayCounter++;
            for(int i = 0; i < waveSize; i++){
                node = waveNodes.removeFirst();
                if(node-1 == 0)
                    return dayCounter++;
                if(!visited.contains(node-1)){
                    waveNodes.add(node-1);
                    visited.add(node-1);
                }
                if(node%2 == 0 && !visited.contains(node/2)){
                    waveNodes.add(node/2);
                    visited.add(node/2);
                }
                if(node%3 == 0 && ! visited.contains(node/3)){
                    waveNodes.add(node/3);
                    visited.add(node/3);
                }

            }
        }
        return dayCounter;

    }

}



