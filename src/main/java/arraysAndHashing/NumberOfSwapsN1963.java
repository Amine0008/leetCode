package arraysAndHashing;

public class NumberOfSwapsN1963 {

    public int minSwaps(String s) {
        if(s == null || s.length() == 0)
            return 0;

        int swapCounter = 0;
        int availableOpens = 0;

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '[')
                availableOpens++;
            else{
                if(availableOpens != 0){
                    availableOpens--;
                }
                else{
                    swapCounter++;
                    availableOpens++;
                }
            }
        }
        return swapCounter;
    }
}
