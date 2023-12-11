package graphs.leetcode;

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegionsN130 {
	
	public static void main(String[] args) {
		char[][] board = new char[][] {
			{'X','O','X','O','X','O'},
			{'O','X','O','X','O','X'},
			{'X','O','X','O','X','O'},
			{'O','X','O','X','O','X'}};
		
	
	}

    public void solve(char[][] board) {
    	// mark all non-surrounded regions (O -> M)
    	for(int i = 0; i <=1; i++ ) {
	    	for(int j = 0; j < board[0].length; j++) {
	    		if( i == 1) {
	    			if(board[board.length-1][j] == 'O')
	    				bfsMark(board.length-1,j,board);
	    		}
	    		else {
	    			if(board[0][j] == 'O')
	    				bfsMark(0,j,board);
	    		}
	    			
	    	}
    	}
    	
    	for(int j = 0; j <= 1; j++) {
    		for(int i = 0; i < board.length; i++) {
    			if(j == 1) {
    				if(board[i][board[0].length - 1] == 'O')
    					bfsMark(i,board[0].length-1,board);
    			}
    			else {
    				if(board[i][j] == 'O')
    					bfsMark(i,j,board);
    			}
    		}
    	}
    	for(char[] row: board) {
    		System.out.println(row);
    	}
    
    	//flip unmarked regions
    	for(int i = 1; i < board.length-1; i++) {
    		for(int j = 1; j < board[0].length-1; j++) {
    			if(board[i][j] == 'O')
    				bfsFlip(i,j,board);
    		}
    	}
    	//unmark regions
    	for(int i = 0; i <=1; i++ ) {
	    	for(int j = 0; j < board[0].length; j++) {
	    		if( i == 1) {
	    			if(board[board.length-1][j] == 'M')
	    				bfsUnmark(board.length-1,j,board);
	    		}
	    		else {
	    			if(board[0][j] == 'M')
	    				bfsUnmark(0,j,board);
	    		}
	    			
	    	}
    	}
    	
    	for(int j = 0; j <= 1; j++) {
    		for(int i = 0; i < board.length; i++) {
    			if(j == 1) {
    				if(board[i][board[0].length - 1] == 'M')
    					bfsUnmark(i,board[0].length-1,board);
    			}
    			else {
    				if(board[i][j] == 'M')
    					bfsUnmark(i,j,board);
    			}
    		}
    	}
    	
    }
    void bfsMark(int row, int column, char[][] board) {
    	if(row < 0 || column < 0 || row == board.length || column == board[0].length)
    		return;
    	if(board[row][column] != 'O')
    		return;
    	board[row][column] = 'M';
    	bfsMark(row+1,column,board);
    	bfsMark(row-1,column,board);
    	bfsMark(row,column+1,board);
    	bfsMark(row,column-1,board);
    }
    void bfsFlip(int row, int column, char[][] board) {
    	if(board[row][column] != 'O')
    		return;
    	board[row][column] = 'X';
    	bfsFlip(row+1,column,board);
    	bfsFlip(row-1,column,board);
    	bfsFlip(row,column+1,board);
    	bfsFlip(row,column-1,board);
    	
    }
    
    void bfsUnmark(int row, int column, char[][] board) {
    	if(row < 0 || column < 0 || row == board.length || column == board[0].length)
    		return;
    	if(board[row][column] != 'M')
    		return;
    	board[row][column] = 'O';
    	bfsUnmark(row+1,column,board);
    	bfsUnmark(row-1,column,board);
    	bfsUnmark(row,column+1,board);
    	bfsUnmark(row,column-1,board);
    }
    
    
    
	
	
	
	
}
