package arraysAndHashing.twoPointers.run2;

public class ValidPalindrome2N680 {
    public static void main(String[] args) {
        validPalindrome("eeccccbebaeeabebccceea");
    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left < right) {
            if(s.charAt(left) != s.charAt(right)){
                return isPalindrome(s,left, right-1) || isPalindrome(s,left+1, right);
            }
            left++;
            right--;
        }
        return true;
    }


    public static boolean isPalindrome(String s, int left, int right){
        while(left < right) {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
