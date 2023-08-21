package arraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalTriangleN118 {

	
	public static void main(String[] args) {
	}
	
    public List<List<Integer>> generate(int numRows) {
    	
        List<List<Integer>> result= new ArrayList<>(numRows); 
    	result.add((ArrayList<Integer>) Arrays.stream(new int[] {1})
                .boxed()
                .collect(Collectors.toList()));
        for(int i = 1 ; i<numRows; i++) {
        	int[] row = new int[i+1];
        	row[0] = 1;
    		row[row.length-1] = 1;
        	for(int j = 1; j < row.length -1; j++) {
        		row[j] = result.get(i-1).get(j-1)+result.get(i-1).get(j);
        	}
        	result.add((ArrayList<Integer>) Arrays.stream(row)
                    .boxed()
                    .collect(Collectors.toList()));
        }
        return result;
        
    }

}
