package arraysAndHashing.twoPointers.run2;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersN3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int currentMax = 0;
        int lastStopIndex = 1;

        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                lastStopIndex = i;
                break;
            }
            set.add(s.charAt(i));
        }
        currentMax = set.size();

        for(int i = 1; i < s.length(); i++){
            set.remove(s.charAt(i-1));
            for(int j = lastStopIndex; j < s.length(); j++){
                if(set.contains(s.charAt(j))) {
                    lastStopIndex = j;
                    break;
                }
                set.add(s.charAt(j));
                currentMax = set.size();

            }
        }
        return currentMax;

    }
}
