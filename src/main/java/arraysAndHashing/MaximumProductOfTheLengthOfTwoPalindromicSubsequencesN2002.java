package arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfTheLengthOfTwoPalindromicSubsequencesN2002 {

    public int maxProduct(String s) {

        String subsequenceString;
        boolean isPalindromic;
        int inputLength = s.length();
        Map<Integer, Integer> map = new HashMap<>();
        int maxProd = 0;
        for(int mask=0;mask<(1<<inputLength);mask++){// generate bitmask from 1 to 2^n

            subsequenceString = getString(mask, s);
            isPalindromic = stringIsPalindromic(subsequenceString);
            if (isPalindromic)
                map.put(mask, subsequenceString.length());


            for (Integer key1 : map.keySet()) {
                for (Integer key2 : map.keySet()) {
                    if ((key1 & key2) == 0)
                        maxProd = Math.max(map.get(key1) * map.get(key2), maxProd);
                }

            }
        }
        return maxProd;
    }

    String getString(int bitmask, String ogString){
        String temp="";
        for(int i=0;i<ogString.length();i++){
            if((bitmask & (1<<i)) !=0) // generate the string from the mask
                temp+=ogString.charAt(i);
        }
        return temp;
    }

    boolean stringIsPalindromic(String s){
        int l = 0;
        int r  = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
