package arraysAndHashing.twoPointers.run2;

import java.util.Arrays;

public class BoatsToSavePeopleN881 {

    public int numRescueBoats(int[] people, int limit) {

        int boatCounter = 0;
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        while(l <= r) {
            if(people[l]+people[r] <= limit) {
                boatCounter++;
                l++;
                r--;
            }
            else{
                boatCounter++;
                r--;
            }
        }
        return boatCounter;

    }
}
