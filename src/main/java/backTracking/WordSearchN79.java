package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchN79 {


	public boolean exist(char[][] board, String word) {
	    boolean result = false;
	    boolean [][]visitedPath = new boolean[board.length][board[0].length];

		for(int i = 0; i < board.length; i++) {
	    	for(int j = 0; j< board[0].length; j++) {
	    		result = findword(i,j, word, 0, board, visitedPath);
	    		if(result)
	    			return true;
	    	}
	    }
		return false;
	}
	
	public boolean findword(int row, int column, String word, int charIndex, char[][] board, boolean[][]visitedPath) {
		if(board[row][column] != word.charAt(charIndex))
			return false;
		
		if(charIndex == word.length()-1)
			return true;
		visitedPath[row][column] = true;
		List<int[]> possibleDirections = new ArrayList<>();
		//can we can go up
		if(row != 0 && !visitedPath[row - 1][column])
			possibleDirections.add(new int[] {row - 1,column});
		
		//can we go down
		if(row != board.length-1 && !visitedPath[row + 1][column])
			possibleDirections.add(new int[] {row + 1,column});
		
		//can we go right
		if(column != board[0].length-1 && !visitedPath[row][column + 1])
			possibleDirections.add(new int[] {row,column+1});

		//can we go left
		if(column != 0 && !visitedPath[row][column - 1])
			possibleDirections.add(new int[] {row,column-1});
		boolean result = false;
		for(int[] direction: possibleDirections) {
			result = findword(direction[0], direction[1], word, charIndex + 1, board, visitedPath);
			if(result)
				break;
		}
		visitedPath[row][column]  = false;
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


















}
