package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NQueensN51 {
	
	public static void main(String[] args) {
		NQueensN51 q = new NQueensN51();
		System.out.println(q.solveNQueens(4)); 
	}
	
    public List<List<String>> solveNQueens(int n) {
    	char[][] board = new char[n][n];
    	List<List<String>> result = new ArrayList<>();
    	for(char[] r: board) {
    		Arrays.fill(r,'T');
    	}
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board.length; j++) {
    			List<int[]> listOfInvalidCellsForLastQueen = putQueenAt(i,j,board);
    			result.addAll(backTrack(i,j,board, n-1, listOfInvalidCellsForLastQueen));
        		revert(board,listOfInvalidCellsForLastQueen);

    		}
    	}
    	return result;
    	
    }
    
    List<int[]> putQueenAt(int row, int column, char[][] board){
    	board[row][column] = 'Q';
    	List<int[]> invalidCellsForQueen = new ArrayList<>();
    	invalidCellsForQueen.add(new int[] {row,column});
    	
    	for(int i = 0; i < board.length; i++) {
    		if(board[row][i] == 'T') {
    			board[row][i] = 'F';
    			invalidCellsForQueen.add(new int[] {row,i});
    		}
    		if(board[i][column] == 'T') {
    			board[i][column] = 'F';
    			invalidCellsForQueen.add(new int[] {i,column});
    		}
    		for(int j = 0; j < board.length; j++) {
    			if( ( i-j == row - column || i+j == row+column) && board[i][j] == 'T') {
    				board[i][j] = 'F';
    				invalidCellsForQueen.add(new int[] {i,j});
    			}
    		}
    	}
    	return invalidCellsForQueen;
    }
    
    List<List<String>> backTrack(int qr, int qc, char[][] board, int numberOfQueensLeft, List<int[]> listOfInvalidCellsForLastQueen){
    	List<List<String>> result = new ArrayList<>();
    	if(numberOfQueensLeft == 0) {
    		List<String> boardCopy = new ArrayList<>();
    		String s;
    		for(char[] cr: board) {
    			s = new String(cr);
    			s = s.replace('T', '.');
    			s = s.replace('F', '.');
    			boardCopy.add(s);
    			
    		}
    		result.add(boardCopy);
    		revert(board,listOfInvalidCellsForLastQueen);
    		return result;
    	}
    	for(int i = qr; i < board.length; i++) {
    		for(int j = 0; j < board.length; j++) {
    			if(board[i][j]=='T') {
    	  			List<int[]> listOfInvalidCellsForNewQueen = putQueenAt(i,j,board);
    	  			List<List<String>> r = backTrack(i,j, board, numberOfQueensLeft-1, listOfInvalidCellsForNewQueen);
    				revert(board,listOfInvalidCellsForNewQueen);
    				result.addAll(r);
    			}
    		}
		}
		revert(board,listOfInvalidCellsForLastQueen);
		return result;
    	
    }
    
    void revert(char[][] board, List<int[]> listOfInvalidCellsForLastQueen ) {
    	for(int[] cell: listOfInvalidCellsForLastQueen) {
    		board[cell[0]][cell[1]] = 'T';
    	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
