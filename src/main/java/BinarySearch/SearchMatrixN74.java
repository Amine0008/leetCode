package BinarySearch;

import java.util.Arrays;

public class SearchMatrixN74 {
	
	public static void main(String[] s) {
		int [][] matrix = new int[][] {{1}};
		System.out.println(searchMatrix2(matrix,1));
	}
	
	public static int binarySearch(int[] nums, int target) {
		int startIndex = 0;
		int endIndex = nums.length -1;
		int middleIndex;
		while(startIndex<=endIndex) {
			if(startIndex == endIndex) {
				if(nums[startIndex] == target)
					return startIndex;
				return -1;
			}
				
			middleIndex = (endIndex-startIndex)/2 +startIndex;
			if(nums[middleIndex] == target)
				return middleIndex;
			if(nums[middleIndex]>target)
				endIndex = middleIndex -1;
			else
				startIndex = middleIndex +1;
		}
		return - 1;
		
	}
	
	  public static boolean searchMatrix(int[][] matrix, int target) {
		  int numOfColumns = matrix[0].length;
		  int[] startIndex = new int[] {0,0};
		  int[] endIndex = new int[] {matrix.length-1, matrix[0].length-1};
		  
		  int[] middleIndex = new int[2];
		  int startIndexEq;
		  int endIndexEq;
		  int middleIndexEq;
		  
		  while(true) {
			  startIndexEq = startIndex[0]*numOfColumns + startIndex[1];
			  endIndexEq = endIndex[0]*numOfColumns + endIndex[1];
			  
			  if(endIndexEq == startIndexEq || endIndexEq-startIndexEq == 1)
				  if(matrix[startIndex[0]][startIndex[1]] == target || matrix[endIndex[0]][endIndex[1]] == target)
					  return true;
				  else
					  return false;
			  else {
				  middleIndexEq = (endIndexEq-startIndexEq)/2 + startIndexEq;
				  middleIndex[0] = middleIndexEq/numOfColumns;
				  middleIndex[1] = middleIndexEq%numOfColumns;
				  
				  if(matrix[ middleIndex[0] ] [ middleIndex[1] ] ==  target)
					  return true;
				  else if(matrix[ middleIndex[0] ] [ middleIndex[1] ] < target) {
					  startIndex[0] = middleIndex[0];
				  	  startIndex[1] = middleIndex[1];
				  }
				  	else {
				  		endIndex[0] = middleIndex[0];
				  		endIndex[1] = middleIndex[1];
				  	}
					  
				  
			  }
		  }
   }
	  
	  public static boolean searchMatrix2(int[][] matrix, int target) {
		  int startRowIndex = 0;
		  int endRowIndex = matrix.length-1;
		  int middleRowIndex;
		  int numOfCols = matrix[0].length-1;
		  int rowIndex = -1;

		  while(true) {
			  middleRowIndex = (endRowIndex-startRowIndex)/2 + startRowIndex;
			  if(startRowIndex == endRowIndex) {
				  rowIndex = startRowIndex;
				  break;
			  }
			  if(middleRowIndex == startRowIndex || middleRowIndex == endRowIndex) {
				  if(matrix[startRowIndex][numOfCols]<target)
					  rowIndex = endRowIndex;
				  else
					  rowIndex = startRowIndex;
				  break;
			  }
			  if(matrix[middleRowIndex][numOfCols]<target)
				  startRowIndex = middleRowIndex;
			  else
				  endRowIndex = middleRowIndex;
		  }
		  if( Arrays.binarySearch(matrix[rowIndex], target)>=0)
			  return true;
		  return false;
		  
	  }  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
