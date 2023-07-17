package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MinStackN155 {
	
	class MinStack {
		Map<Integer, Stack<Integer>> map ;
	    Integer currentMin = Integer.MIN_VALUE;
		Stack<Integer> stack ;	
		public MinStack() {
	    	Map<Integer, Stack<Integer>> map = new HashMap<>();
	    	stack = new Stack<>();
		}
	    
	    public void push(int val) {
	        
	    	if(val<currentMin)
	        	currentMin = val;
	        
	        if(!map.containsKey(val))
	        	map.put(val, new Stack<>());
	        
	        map.get(val).push(currentMin);
	        
	        stack.push(val);
	    }
	    
	    public void pop() {
	    	int poppedValue = stack.pop();
	    	if(stack.isEmpty()) {
	    		currentMin = Integer.MAX_VALUE;
	    		map = new HashMap<>();
	    		return;
	    	}
	    	map.get(poppedValue).pop();
	    	currentMin = map.get(stack.peek()).peek();
	        
	    }
	    
	    public int top() {
	        return stack.peek();
	    }
	    
	    public int getMin() {
	        return this.currentMin;
	    }
	}

	
	class MinStack2 {
		
		Stack<Integer> mins;
		Stack<Integer> values;
	    public MinStack2() {
	        mins = new Stack<>();
	        values = new Stack<>();
	    }
	    
	    public void push(int val) {
	        if(mins.isEmpty()) {
	        	mins.push(val);
	        	values.push(val);
	        }
	        else {
	        	if(val>mins.peek()) {
	        		mins.push(mins.peek());
	        	}
	        	else {
	        		mins.push(val);
	        	}
	        	values.push(val);
	        }
	    }
	    
	    public void pop() {
	        values.pop();
	        mins.pop();
	    }
	    
	    public int top() {
	        return values.peek();
	    }
	    
	    public int getMin() {
	        return mins.peek();
	    }
	}
}
