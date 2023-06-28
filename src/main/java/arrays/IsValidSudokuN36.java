package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class IsValidSudokuN36 {

	public static void main(String[]args) {
		char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},
		                                {'6','.','.','1','9','5','.','.','.'},
		                                {'.','9','8','.','.','.','.','6','.'},
		                                {'8','.','.','.','6','.','.','.','3'},
		                                {'4','.','.','8','.','3','.','.','1'},
		                                {'7','.','.','.','2','.','.','.','6'},
		                                {'.','6','.','.','.','.','2','8','.'},
		                                {'.','.','.','4','1','9','.','.','5'},
		                                {'.','.','.','.','8','.','.','7','9'}};
		
        char[][] board2 = new char[][] {{'.','.','.','.','.','.','.','.','.'},
        								{'.','.','.','.','.','6','.','.','.'},
        								{'.','.','.','.','.','.','.','.','.'},
        								
        								{'.','.','.',   '.','8','.',     '.','.','.'},
        								{'9','.','.',   '.','7','5',     '.','.','.'},
        								{'.','.','.',   '.','5','.',     '.','8','.'},
        								
        								{'.','.','9',	'.','.','.',	'.','.','.'},
        								{'2','.','6',	'.','.','.',	'.','.','.'},
        								{'.','.','.',	'.','.','.',	'.','.','.'}}
;
		                                
		                                
		                                
        isValidSudoku2(board2); 
	}
	 
	
    public static boolean isValidSudoku(char[][] board) {
    	Set<Character> rowSet;
    	Set<Character> columnSet;
    	
     for(int i = 0; i<board.length;i++) {
    	 rowSet = new HashSet<>();
    	 columnSet = new HashSet<>();
    	 for(int j = 0;j<board[i].length;j++) {
    		 if(board[i][j] != '.') {
    			 if(board[i][j] > 57 || board[i][j] < 49 || rowSet.contains(board[i][j]))
        			 return false;
        		 rowSet.add(board[i][j]);
        		 
    		 }
    		 if(board[j][i] != '.') {
        		 if(board[j][i] > 57 || board[j][i] < 49 || columnSet.contains(board[j][i]))
        			 return false;
        		 columnSet.add(board[j][i]);
    		 }

    	 }
     }
     Set<Character> matrixSet ;
     for(int m = 0; m < 7; m = m+3) {
    	 for(int k = 0; k < 7 ;k=k+3) {
    		 matrixSet = new HashSet<>();
    		   for(int i= 0+m; i < 3+m ; i++) {
    		    	 for(int j = 0+k ;j < 3+k; j++) {
    		    		 if(board[i][j] != '.') {
    	 		    		 if(board[i][j] > 57 || board[i][j] < 49 || matrixSet.contains(board[i][j]))
        		    			 return false;
        		    		 matrixSet.add(board[i][j]);
    		    		 }
   
    		    	 }
    		     }
    	 }
     }
     return true;

    }
/*    
    m->0
    	k->0
    	k->3
    	k->6
   m->3
	    k->0
	 	k->3
	 	k->6
	m->6
		k->0
	 	k->3
	 	k->6
		
*/
    public static boolean isValidSudoku2(char[][] board) {
    	Set<Character> rowSet;
    	Set<Character> columnSet;
    	
    	HashMap<String,Set<Character>> subMatricesSetsMap = new HashMap<>();	
    	
     for(int i = 0; i<board.length;i++) {
    	 rowSet = new HashSet<>();
    	 columnSet = new HashSet<>();
    	 for(int j = 0;j<board[i].length;j++) {
    		 if(board[i][j] != '.') {
    			 if(board[i][j] > 57 || board[i][j] < 49 || rowSet.contains(board[i][j]))
        			 return false;
        		 rowSet.add(board[i][j]);
        		 
        		 if(!subMatricesSetsMap.containsKey(i/3+""+j/3)) {
        			 subMatricesSetsMap.put(i/3+""+j/3, new HashSet<>());

        		 }
        		 
        		 else {
        			 if(subMatricesSetsMap.get(i/3+""+j/3).contains(board[i][j]))
        				 return false;
        		 }
    			 subMatricesSetsMap.get(i/3+""+j/3).add(board[i][j]);

    		 }
    		 if(board[j][i] != '.') {
        		 if(board[j][i] > 57 || board[j][i] < 49 || columnSet.contains(board[j][i]))
        			 return false;
        		 columnSet.add(board[j][i]);
    		 }

    	 }
     
    	
    	    	
    }
     return true;

    }

}
