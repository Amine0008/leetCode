package arraysAndHashing.twoPointers.run2;

public class LongestRepeatingCharacterReplacementN424 {


    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int currentMaxFreq;
        int maxLength = 0;
        int left = 0;
        int right = 0;
        counts[s.charAt(0)-65]++;
        while(right <=  s.length() - 1) {
            currentMaxFreq = currentMaxFreq(counts);
            if(right-left+1 - currentMaxFreq <= k) {
                maxLength = Math.max(maxLength, right-left+1);
                right++;
                if(right <= s.length() -1)
                    counts[s.charAt(right)-65]++;
            }
            else{
                left++;
                counts[s.charAt(left-1)-65]--;
            }
        }
        return maxLength;


    }

    public int currentMaxFreq(int[] counts) {
        int currentMax = counts[0];
        for(int i = 1; i < counts.length; i++){
            if(counts[i] > currentMax)
                currentMax = counts[i];
        }
        return currentMax;
    }


}
