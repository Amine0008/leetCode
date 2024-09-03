package arraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfTheLengthOfTwoPalindromicSubsequencesN2002 {

    public int maxProduct(String s) {
        int maxLength = s.length();
        String binaryRepoHolder;
        Map<String, Integer> map =  new HashMap<>();
        for(int i = 1; i < Math.pow(2, s.length()); i++ ){
            binaryRepoHolder = String.format("%"+maxLength+"s",
                    Integer.toBinaryString(i)).replace(' ', '0');
            if(isPalindromic(binaryRepoHolder,s))
                map.put(binaryRepoHolder, getLength(binaryRepoHolder));

        }
    }

    public int getLength(String binaryString) {
        int counter = 0;
        for(int i =  0; i < binaryString.length(); i++){
            if( binaryString.charAt(i) == '1')
                counter++;
        }
        return counter;
    }

    public boolean isPalindromic(String binaryString, String original){
        int right = binaryString.length()-1;
        int left = 0;
        while(right < left) {
            while(  right >=0 && binaryString.charAt(right) != '1'){
                right--;
            }
            while( binaryString.charAt(left) != '1'){
                left++;
            }
            if(left >= right)
                return true;
            if(original.charAt(left) != original.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
