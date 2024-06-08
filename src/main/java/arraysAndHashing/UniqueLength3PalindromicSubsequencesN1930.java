package arraysAndHashing;

import java.util.*;

public class UniqueLength3PalindromicSubsequencesN1930 {
    public static void main(String[] args){
        UniqueLength3PalindromicSubsequencesN1930 x = new UniqueLength3PalindromicSubsequencesN1930();
        x.countPalindromicSubsequence("bbcbaba");
    }

    public int countPalindromicSubsequence(String s) {
        Map<Character, int[]> charIndicesMap = new HashMap<>();
        int[] arrayHolder;
        for(int i = 0; i < s.length(); i++) {
            if(!charIndicesMap.containsKey(s.charAt(i)))
                charIndicesMap.put(s.charAt(i),new int[]{-1,-1});
            arrayHolder = charIndicesMap.get(s.charAt(i));
            if(arrayHolder[0] == -1)
                arrayHolder[0] = i;
            else if(arrayHolder[1] == -1)
                arrayHolder[1] = i;

            else
                arrayHolder[1] = i;

        }
        int result = 0;
        for(int[] charFirstAndLast: charIndicesMap.values()){
            if(charFirstAndLast[0] == -1 || charFirstAndLast[1] == -1)
                continue;
            if(charFirstAndLast[1]-charFirstAndLast[0] == 1)
                continue;

            Set<Character> uniqueChars = new HashSet<>();

            for(int i = charFirstAndLast[0]+1; i< charFirstAndLast[1]; i++){
                if(!uniqueChars.contains(s.charAt(i))) {
                    result++;
                    uniqueChars.add(s.charAt(i));
                }
            }

        }
        return result;


    }
}
