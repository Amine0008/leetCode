package stack;

import java.util.Stack;

public class FinalPricesN1475 {

	public static void main(String[] args) {
	}
	
	public int[] finalPrices(int[] prices) {
		
		Stack<Integer> stack = new Stack<>();
		stack.push(prices[prices.length-1]);
		int[] answer = new int[prices.length];
		answer[prices.length-1] = prices[prices.length-1];
		
		for(int i = prices.length-2; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek()>prices[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) { 
				stack.push(prices[i]);
				answer[i] = prices[i];
			}
			else {
				answer[i] = prices[i] - stack.peek();
				stack.push(prices[i]);
			}
			
		}
		
		return answer ;
    }
    
	public int[] finalPrices2(int[] prices) {
		int discount;
		for(int i = 0; i<prices.length; i++) {
			discount = 0;
			for(int j = i+1; j<prices.length; j++) {
				if(prices[j]<= prices[i]) {
					discount = prices[j];
					break;
				}
				prices[i] = prices[i]-discount;
					
			}
		}
		
		return prices;
    }
	
	public int[] finalPrices3(int[] prices) {
		Stack<Integer> discounts = new Stack<>();
		discounts.add(0);
		for(int i = prices.length-2; i >= 0; i--) {
			if(prices[i] >=  prices[i+1]) {
				discounts.add(prices[i+1]);
				continue;
			}
			if(prices[i] >= discounts.peek()) {
				discounts.add(discounts.peek());
				continue;
			}
			discounts.add(-1);
			
		}
		
		for(int i =0; i<prices.length; i++) {
			if(discounts.peek() == -1) {
				discounts.pop();
				continue;
			}
				
		prices[i] = prices[i]-discounts.pop();
		}
		
		return prices;
	
	}
	
	
	
	
	
	
	
	
	

}
