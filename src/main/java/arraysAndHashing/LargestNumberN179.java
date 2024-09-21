package arraysAndHashing;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumberN179 {

    public String largestNumber(int[] nums) {
        String[] stringVals = new String[nums.length];
        int zeroCounter = 0;
        for(int i = 0; i < nums.length; i++){
            stringVals[i] = nums[i]+"";
            if(nums[i] == 0)
                zeroCounter++;
        }
        if(zeroCounter == nums.length)
            return 0+"";

        Arrays.sort(stringVals,
                (a,b)->{
                    if(a.equals(b))
                        return 0;
                    return (new BigInteger(b+a)).compareTo(new BigInteger(a+b));
                });
        StringBuilder sb = new StringBuilder();
        for(String val: stringVals){
            sb.append(val);
        }
        return sb.toString();
    }

}
