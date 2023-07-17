package Stack;

import java.util.Stack;

public class EvaluateReversePolishNotationN150 {

	public static void main(String[] args) {
		System.out.println(
				evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
	}
	
    public static int evalRPN(String[] tokens) {
    	Stack<Integer> stack = new Stack<>();   
    	
    	int firstPop;
    	int secondPop;
    	
    	for(String token: tokens) {
    		if(!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
    			stack.add(Integer.valueOf(token));
    		}
    		else {
    			
    			firstPop = stack.pop();
    			secondPop = stack.pop();
    			
    			if(token.equals("+"))
    				stack.add(secondPop+firstPop);
    			else if(token.equals("-"))
    				stack.add(secondPop - firstPop);
    			else if (token.equals("*"))
    				stack.add(secondPop * firstPop);
    			else if (token.equals("/"))
    				stack.add(secondPop/firstPop);
    		}
    	}
    	return stack.pop();
    	
    }
}
