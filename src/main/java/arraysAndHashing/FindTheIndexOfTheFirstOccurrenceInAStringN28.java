package arraysAndHashing;

public class FindTheIndexOfTheFirstOccurrenceInAStringN28 {

    public int strStr(String haystack, String needle) {
        if(needle.length()>haystack.length())
            return -1;
        int l = 0;
        int r = needle.length()-1;
        boolean isNeedle;
        while(r < haystack.length()){
            isNeedle = true;
            for(int i = l; i <= r; i++){
                if(haystack.charAt(i) != needle.charAt(i-l)){
                    isNeedle = false;
                    break;
                }
            }
            if(isNeedle)
                return l;
            l++;
            r++;
        }
        return -1;
    }

}
