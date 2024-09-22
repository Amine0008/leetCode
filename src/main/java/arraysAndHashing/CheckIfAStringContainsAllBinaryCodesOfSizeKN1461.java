package arraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class CheckIfAStringContainsAllBinaryCodesOfSizeKN1461 {

    public boolean hasAllCodes(String s, int k) {
        // get all subsequences of length k from s

        Set<String> subsequencesOfS = new HashSet<>();

        for(int i = 0; i <= s.length()-k; i++){
            subsequencesOfS.add(s.substring(i,i+k));
        }

        return subsequencesOfS.size() == Math.pow(2,k);
    }
    public boolean hasAllCodes2(String s, int k) {
        Set<String> allnums = new HashSet<>();
        for(int i = 0; i <= Math.pow(2,k)-1; i++){
            allnums.add(
                    String.format("%"+k+"s", Integer.toBinaryString(i)).replace(' ', '0'));
        }
        String substring;
        for(int i = 0; i <= s.length()-k; i++){
            if(allnums.isEmpty())
                return true;
            substring = s.substring(i,i+k);
            allnums.remove(substring);
        }
        return allnums.isEmpty();
    }
}
