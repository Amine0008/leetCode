package Stack;

import java.util.Stack;

public class DailyTemperaturesN739 {
	
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        result[temperatures.length-1] = 0;
    	
        //currentTempsWithNoWarmerWeather
        Stack<Integer> temps = new Stack<>();
        
        for(int i = 0; i < temperatures.length; i++) {
        	if(temps.isEmpty()) {
        		temps.add(i);
        		continue;
        	}
        	while(!temps.isEmpty() && temperatures[i] > temperatures[temps.peek()]) {
        		result[temps.peek()] = i-temps.peek();
        		temps.pop();
        	}
        	temps.add(i);
        	
        	
        }
        
    	return result; 
    }

    
    
    public int[] dailyTemperaturesTest(int[] temperatures) {
    	int[] answer = new int [temperatures.length];
    	Stack<Integer> tempIndices = new Stack<>();
    	for(int i = 0; i<temperatures.length; i++) {
    		while(!tempIndices.isEmpty()&&temperatures[i]>temperatures[tempIndices.peek()]) {
    			answer[tempIndices.peek()] = i-tempIndices.peek();
    			tempIndices.pop();
    		}
    		tempIndices.add(i);
    	}
    	
    	return answer;
    }
}
