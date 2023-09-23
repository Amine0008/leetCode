package backTracking;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquePathsN62 {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3,3));
	}
	
	
    public static List<String> uniquePaths(int m, int n) {
    	return traverseUniquePaths("",m-1,n-1);
    }
    
    public static List<String> traverseUniquePaths(String path,int row, int column) {
    	
    	if(row == 0 && column == 0) {
    		return new ArrayList<>(Arrays.asList(path));
    	}
    	List<String> result = new ArrayList<>();
    	if(row != 0)
    		result.addAll(traverseUniquePaths(path+"D",row-1,column));
    	if(column != 0)
    		result.addAll(traverseUniquePaths(path+"R",row,column-1));
    	return result;
    }

    public int uniquePaths2(int m, int n) {
    	Map<String,Long> memo = new HashMap<>();
    	return traverseUniquePaths(m-1,n-1,memo);
    }
    
    
     public int traverseUniquePaths(int row, int column, Map<String,Long> memo) {
    	if(row == 0 || column == 0)
    		return 1;
    	int sum = 0;
    	if(row != 0) {
    		if(memo.containsKey(""+(row-1)+","+column))
    			sum += memo.get(""+(row-1)+","+column);
    		else
    			sum += traverseUniquePaths(row - 1, column, memo);	
    	}
    	
    	if(column != 0) {
    		if(memo.containsKey(""+row+","+(column-1)))
    			sum += memo.get(""+row+","+(column-1));
    		else	
    			sum += traverseUniquePaths(row, column - 1, memo);
    	}
    	if(!memo.containsKey(""+row+","+column))
    		memo.put(""+row+","+column, (long)sum);	
    	return sum;
    }
}
