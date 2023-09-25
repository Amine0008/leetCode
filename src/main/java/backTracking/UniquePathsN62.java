package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquePathsN62 {

	public static void main(String[] args) {
		boolean[][] maze = new boolean[][] {
			{true,true,true},
			{true,true,true},
			{true,true,true}};
		Map<String, int[][]> result = uniqiePathFourDirections(maze);
		int[][] holder;
		for(String x: result.keySet()) {
			holder = result.get(x);
			for(int[] y:holder) {
				System.out.println(Arrays.toString(y));
			}
			System.out.println(x);
			System.out.println();
		}
	}
	
    public static List<String> uniquePaths(int m, int n) {
    	return traverseUniquePaths("",m-1,n-1);
    }
    private static List<String> traverseUniquePaths(String path,int row, int column) {
    	
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
    private int traverseUniquePaths(int row, int column, Map<String,Long> memo) {
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

    public static  List<String> uniquePathsWithBlackades(boolean[][] maze){
    	return findPaths("", 0, 0,maze);
    }
    
    private static List<String> findPaths(String path, int currentRow, int currentCol, boolean[][] maze){
    	if(currentRow == maze.length-1 && currentCol == (maze[0].length-1))
    		return Arrays.asList(path);
    	if(!maze[currentRow][currentCol])
    		return new ArrayList<>();
    	List<String> result = new ArrayList<>();
    	if(currentRow < maze.length-1)
    		result.addAll(findPaths(path+"D",currentRow+1,currentCol,maze));
    	if(currentCol < maze[0].length-1)
    		result.addAll(findPaths(path+"R",currentRow,currentCol+1,maze));
    	
    	return result;
    }

    
    public static  Map<String, int[][]> uniqiePathFourDirections(boolean[][] matrix){
    	Map<String, int[][]> result = new HashMap<>();
    	int[][] paths = new int[matrix.length][matrix[0].length];
    	
    	traverseWithFourDirections("", 0, 0, matrix, result, paths, 1);
    	return result;
    }
    
    private static void traverseWithFourDirections(String path,
    		int currentRow, 
    		int currentColumn, 
    		boolean[][] matrix, 
    		Map<String, int[][]> result,
    		int[][] showPath,
    		int step) {
    	showPath[currentRow][currentColumn] = step;
    	
    	if(currentRow == matrix.length - 1 && currentColumn == matrix[0].length - 1) {
    		
    		int[][] p = new int [showPath.length][showPath[0].length];
    		for(int i = 0; i<showPath.length; i++ ) {
    			p[i] = Arrays.copyOf(showPath[i],showPath[i].length);
    		}
    		result.put(path, p);
    		
    		return;
    	}
    	matrix[currentRow][currentColumn] = false;
    	
    	//LEFT
    	if(currentColumn-1>=0 && matrix[currentRow][currentColumn - 1])
    		traverseWithFourDirections(path+"L", currentRow, currentColumn-1, matrix, result, showPath, step+1);
    	
    	//UP
    	if(currentRow-1 >= 0 && matrix[currentRow - 1][currentColumn])
    		traverseWithFourDirections(path+"U", currentRow - 1, currentColumn, matrix, result, showPath,step+1);
    	
    	//RIGHT
    	if(currentColumn + 1 < matrix[0].length && matrix[currentRow][currentColumn + 1])
    		traverseWithFourDirections(path+"R", currentRow, currentColumn + 1, matrix, result, showPath,step+1);
    	
    	//DOWN
    	if(currentRow + 1 < matrix.length && matrix[currentRow + 1][currentColumn])
    		traverseWithFourDirections(path+"D", currentRow + 1, currentColumn, matrix, result, showPath,step+1);
    	
    	
    	//original matrix has no obstacles
    	matrix[currentRow][currentColumn] = true;
    	showPath[currentRow][currentColumn] = 0;
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    



}

