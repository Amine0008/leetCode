package arraysAndHashing;

import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanN12 {

	public static void main(String[] args) {
		
	}
	
	public String intToRoman(int num) {
		//   4 → IV
		//   9 → IX
		//  40 → XL
		//  90 → XC
		// 400 → CD
		// 900 → CM
		String result ="";
        Map<Integer, String> map = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        for(Integer x: map.keySet()) {
        	if(num == 0)
        		break;
        if(num/x > 0)
        	for(int i = 1; i<=num/x; i++) {
        		result+=map.get(x);
        	}
        num = num % x;
        
        }
		return result;
    }

}
