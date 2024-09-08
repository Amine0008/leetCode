package arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfTheLengthOfTwoPalindromicSubsequencesN2002 {

    public int maxProduct(String s) {
        Map<Integer, Integer> ssLenghtMap = new HashMap<>();
        String sRep;

        for(int i = 1 ; i < (1 << s.length()); i++){
            sRep = getStringFromBin(i, s);
            if(isPalindromic(sRep))
                ssLenghtMap.put(i,sRep.length());
        }

        int maxProduct = 0;
        for(Integer x1: ssLenghtMap.keySet()){
            for(Integer x2: ssLenghtMap.keySet()){
                if((x1 & x2) == 0 && ssLenghtMap.get(x1)*ssLenghtMap.get(x2) > maxProduct)
                    maxProduct = ssLenghtMap.get(x1)*ssLenghtMap.get(x2);
            }
        }
        return maxProduct;

    }

    public String getStringFromBin(int bin, String ogString){
        StringBuilder sb = new StringBuilder();
        for(int i = ogString.length()-1; i >= 0; i--){
            if(((1<<i) & bin) != 0)
                sb.append(ogString.charAt(i));
        }
        return sb.toString();
    }
    public boolean isPalindromic(String s) {
        int l = 0;
        int r = s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
