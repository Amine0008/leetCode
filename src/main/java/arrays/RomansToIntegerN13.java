package arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomansToIntegerN13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public int romanToInt(String s) {
    	int result = 0;
    	  Map<String, Integer> map = new LinkedHashMap<>();
          map.put("M",1000);
          map.put("CM",900);
          map.put("D",500);
          map.put("CD",400);
          map.put("C",100);
          map.put("XC",90);
          map.put("L",50);
          map.put("XL",40);
          map.put("X",10);
          map.put("IX",9);
          map.put("V",5);
          map.put("IV",4);
          map.put("I",1);
          
          for(int i = 0; i < s.length(); i++) {
        	//  if(i != s.length()-1 && map.containsKey(s.charAt(i)+""+s.charAt(i+1))) {
        	  if( i != s.length()-1 && map.get(""+s.charAt(i)) < map.get(""+s.charAt(i+1))) {
        		  result+=map.get(s.charAt(i)+""+s.charAt(i+1));
        		  i++;
        	  }else
        		  result+=map.get(""+s.charAt(i));
        	 
          }
        return result;
    }
	  	


}
