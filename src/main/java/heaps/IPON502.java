package heaps;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

public class IPON502 {
    public int findMaximizedCapital(int k,
                                    int w,
                                    int[] profits,
                                    int[] capital) {

        Integer[] projectsByCapital = new Integer[profits.length];
        for(int i = 0; i < profits.length; i++){
            projectsByCapital[i] = i;
        }
        Arrays.sort(projectsByCapital,(a,b)->capital[a]-capital[b]);
        PriorityQueue<Integer> availableProjects = new PriorityQueue<>((a, b) -> b - a);
        int foospIndex = 0;
        while(foospIndex < profits.length && capital[projectsByCapital[foospIndex]] <= w) {
            availableProjects.add(profits[projectsByCapital[foospIndex]]);
            foospIndex++;

        }
        while(k != 0 && !availableProjects.isEmpty()) {
            w+=availableProjects.remove();
            k--;
            while(foospIndex < profits.length && capital[projectsByCapital[foospIndex]] <= w) {
                availableProjects.add(profits[projectsByCapital[foospIndex]]);
                foospIndex++;

            }
        }
        return w;

    }

}
