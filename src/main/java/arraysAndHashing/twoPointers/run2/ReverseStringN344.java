package arraysAndHashing.twoPointers.run2;

public class ReverseStringN344 {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        char holder;
        while(left < right) {
            holder = s[right];
            s[right] = s[left];
            s[left] = holder;
            left++;
            right--;
        }

    }

}

