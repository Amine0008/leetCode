package stack;

import java.util.Stack;

public class BaseBallGameN682 {

	public static void main(String[] args) {

	}
	
	  public int calPoints(String[] operations) {
		  Stack<Integer> record = new Stack<>();
		  int last;
		  int newEntry;
		  int sum = 0;
		  for(String s: operations) {
			  if(s.equals("C")) {
				record.pop();  
			  }	
			  else if(s.equals("D")) {
				  record.add(record.peek()*2);
			  }
			  else if(s.equals("+")) {
				  last = record.pop();
				  newEntry = record.peek()+last;
				  record.add(last);
				  record.add(newEntry);
			  }
			  else {
				  record.add(Integer.valueOf(s));
			  }
		  }
		  for(Integer x: record) {
			  sum+=x;
		  }
		  
		  return sum;
	  }

}
