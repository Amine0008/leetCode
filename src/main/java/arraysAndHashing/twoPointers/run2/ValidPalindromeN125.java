package arraysAndHashing.twoPointers.run2;

public class ValidPalindromeN125 {

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if (!isAlpha(s.charAt(left)) && !isNumber(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isAlpha(s.charAt(right)) && !isNumber(s.charAt(right))){
                right--;
                continue;
            }
            if(!sameAlphaNum(s.charAt(left), s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;

    }

    public boolean sameAlphaNum(Character a, Character b){
        a = (a>=65 && a<=90) ? (char) (a + 32) : a;
        b = (b>=65 && b<=90) ? (char) (b + 32) : b;
        return a.equals(b);

    }
    public boolean isAlpha(Character c) {
        return (c>=97 && c<=122) || (c>=65 && c<=90);
    }

    public boolean isNumber(Character c) {
        return c>=48 &&  c<=57;
    }
}
