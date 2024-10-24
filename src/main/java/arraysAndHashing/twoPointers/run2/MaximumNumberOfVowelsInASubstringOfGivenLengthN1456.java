package arraysAndHashing.twoPointers.run2;

public class MaximumNumberOfVowelsInASubstringOfGivenLengthN1456 {

    public int maxVowels(String s, int k) {
        if(s.length() < k)
            return 0;
        int maxCount = 0;
        int currentCount = 0;
        for(int i = 0; i < k; i++){
            if(isVowel(s.charAt(i)))
                currentCount++;
        }
        maxCount = currentCount;
        int l = 1;
        int r;
        int lengthOfS = s.length();
        while(l < lengthOfS + 1- k) {
            r = l+k-1;
            if(isVowel(s.charAt(l-1)))
                currentCount--;
            if(isVowel(s.charAt(r)))
                currentCount++;
            if(currentCount > maxCount)
                maxCount = currentCount;
            l++;
        }
        return maxCount;
    }

    public boolean isVowel(char c) {
        return c ==  'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
