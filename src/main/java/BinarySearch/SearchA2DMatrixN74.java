package BinarySearch;

public class SearchA2DMatrixN74 {

	
	public static void main(String[] args) {
		
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
    	int rowIndexToSearch = getRowContainingTarget(matrix, target);
    	if(rowIndexToSearch == -1)
    		return false;
    	int left = 0; 
    	int right = matrix[rowIndexToSearch].length - 1;
    	int mid;
    	
    	while(left <= right) {
    		mid = (right-left)/2+left;
    		if(matrix[rowIndexToSearch][mid]>target)
    			right = mid - 1;
    		else if(matrix[rowIndexToSearch][mid]<target)
    			left = mid + 1;
    		else
    			return true;
    	}
    	return false; 
    }
    public int getRowContainingTarget(int[][] matrix, int target) {
    	int lastCol = matrix[0].length-1;
    	int left = 0;
    	int right = matrix.length-1;
    	int mid;
    	
    	while(left <= right) {
    		mid = (right-left) / 2 + left;
    		if(target > matrix[mid][lastCol])
    			left = mid + 1;
    		else {
    			if(target<matrix[mid][0])
    				right = mid - 1;
    			else
    				return mid;
    		}
    			
    	}
    	return -1;
    }
}
