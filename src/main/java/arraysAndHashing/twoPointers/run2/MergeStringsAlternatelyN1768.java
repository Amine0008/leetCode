package arraysAndHashing.twoPointers.run2;

public class MergeStringsAlternatelyN1768 {

    public String mergeAlternately(String word1, String word2) {
        int p1 = 0;
        int p2 = 0;
        boolean word1Turn = true;
        StringBuilder sb = new StringBuilder();
        while(p1 < word1.length() || p2 < word2.length()) {
            if(p1 == word1.length()){
                sb.append(word2.substring(p2));
                break;
            }
            if(p2 == word2.length()){
                sb.append(word1.substring(p1));
                break;
            }
            if(word1Turn){
                sb.append(word1.charAt(p1));
                word1Turn = false;
                p1++;
            }
            else {
                sb.append(word2.charAt(p2));
                word1Turn = true;
                p2++;
            }
        }
        return sb.toString();
    }
}
