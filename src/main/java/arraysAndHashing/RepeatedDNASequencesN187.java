package arraysAndHashing;

import java.util.*;
import java.util.stream.Collectors;

public class RepeatedDNASequencesN187 {

    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 11)
            return Collections.emptyList();
        Set<String> allSubsequences = new HashSet<>();
        Set<String> repeatedSubsequences = new HashSet<>();
        String current;
        for(int i = 0; i <= s.length()-10 ; i++) {
            current = s.substring(i,i+10);
            if(repeatedSubsequences.contains(current))
                continue;
            if(allSubsequences.contains(current))
                repeatedSubsequences.add(current);
            else
                allSubsequences.add(current);
        }
        return new ArrayList<>(repeatedSubsequences);
    }
}
