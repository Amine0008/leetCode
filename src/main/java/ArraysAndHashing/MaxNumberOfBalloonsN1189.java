package ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfBalloonsN1189 {
	
	 public int maxNumberOfBalloons(String text) {
//	     
		 int[] balloonCounter = new int[5];
		 
		 
		 for(int i = 0; i < text.length(); i++) {
			 switch(text.charAt(i)) {
			 	case 'b': balloonCounter[0]++; break;
			 	case 'a': balloonCounter[1]++; break;
			 	case 'l': balloonCounter[2]++; break;
			 	case 'o': balloonCounter[3]++; break;
			 	case 'n': balloonCounter[4]++; break;
			 }
		
		 }
		 balloonCounter[1] /=2;
		 balloonCounter[2] /=2;
		 
		 int min = balloonCounter[0];
		 for(int i = 0; i <= 4; i++) {
			 if(balloonCounter[i]<min)
				 min = balloonCounter[i];
		 }
		 return min;
    }
	 
   	 public int maxNumberOfBalloons2(String text) {
	        
		 Map<String, Integer> balloonMapCounter = new HashMap<>();
		 balloonMapCounter.put("b",0);
		 balloonMapCounter.put("a",0);
		 balloonMapCounter.put("l",0);
		 balloonMapCounter.put("o",0);
		 balloonMapCounter.put("n",0);
		 
		 for(int i = 0; i < text.length(); i++) {
			 if(balloonMapCounter.containsKey(text.charAt(i)+""))
				 balloonMapCounter.put(text.charAt(i)+"",balloonMapCounter.get(text.charAt(i)+"")+1);
		 }
		 int maximunNumberOfBallons = Math.min(balloonMapCounter.get("b"), balloonMapCounter.get("a"));
		 maximunNumberOfBallons = Math.min(maximunNumberOfBallons, balloonMapCounter.get("n"));
		 
		 if(maximunNumberOfBallons == 0)
			 return 0;
		 
		 
		 for(int i = maximunNumberOfBallons; i>0; i--) {
			 if(balloonMapCounter.get("l")>= 2*i && balloonMapCounter.get("o")>= 2*i)
				 return i;
		 }
		 return 0;
    }	

}
