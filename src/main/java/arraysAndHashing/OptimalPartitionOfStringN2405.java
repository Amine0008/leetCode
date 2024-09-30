package arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionOfStringN2405 {

    public int partitionString(String s) {
        int pCounter = 0;
        int startIndex = 0;
        Set<Character> charsInP;
        while(startIndex < s.length()){
            pCounter++;
            charsInP = new HashSet<>();
            for(int j = startIndex; j < s.length() && !charsInP.contains(s.charAt(j)); j++){
                startIndex = j;
                charsInP.add(s.charAt(j));
            }
            startIndex++;
        }
        return pCounter;
    }
}
