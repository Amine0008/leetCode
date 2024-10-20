package arraysAndHashing.twoPointers.run2;

public class PermutationInStringN567 {

    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] s1Map = new int[26];
        //'a': 97 (decimal ASCII)
        int s1Length = s1.length();
        for(char c: s1.toCharArray()) {
            s1Map[c-97]++;
        }
        int[] holderMap = new int[26];
        for(int i = 0; i < s1Length; i++){
            holderMap[s2.charAt(i)-97]++;
        }
        if(isPermutation(s1Map, holderMap))
            return true;

        for(int i = 1; i <= s2.length()-s1Length; i++) {
            holderMap[s2.charAt(i-1)-97]--;
            holderMap[s2.charAt(i+s1Length-1)-97]++;
            if(isPermutation(s1Map, holderMap))
                return true;
        }
        return false;

    }

    public boolean isPermutation(int[] chars1, int[] chars2) {
        for(int i = 0; i < 26; i++){
            if(chars1[i] != chars2[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion2(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] s1Map = new int[26];
        //'a': 97 (decimal ASCII)
        int s1Length = s1.length();
        for(char c: s1.toCharArray()) {
            s1Map[c-97]++;
        }
        int[] holderMap = new int[26];
        for(int i = 0; i < s1Length; i++){
            holderMap[s2.charAt(i)-97]++;
        }
        int numOfMatches = 0;
        for(int i = 0; i < 26; i++){
            if(holderMap[i] == s1Map[i])
                numOfMatches++;
        }
        if(numOfMatches == 26)
            return true;
        char removedChar, newChar;
        for(int i = 1; i <= s2.length()-s1Length; i++) {
            removedChar = (char)(s2.charAt(i-1)-97);
            newChar = (char)(s2.charAt(i+s1Length-1)-97);
            if(removedChar == newChar)
                continue;

            if(s1Map[removedChar] == holderMap[removedChar])
                numOfMatches--;
            if(s1Map[newChar] == holderMap[newChar])
                numOfMatches--;
            holderMap[removedChar]--;
            holderMap[newChar]++;

            if(s1Map[removedChar] == holderMap[removedChar])
                numOfMatches++;
            if(s1Map[newChar] == holderMap[newChar])
                numOfMatches++;

            if(numOfMatches == 26)
                return true;
        }
        return false;

    }

}
