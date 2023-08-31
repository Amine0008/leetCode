package linkedList.leetcode;

public class SortAnArrayN912 {
	
	public static void main(String[] args) {}

	
	//implementing merge sort for a normal array
	static void mergeSort(int[] array, int left, int right){
		if(right-left == 0)
			return;
		int mid = (right - left) / 2 + left;
		mergeSort(array, left, mid);
		mergeSort(array, mid+1, right);
		mergeSortedArrays(array,left, right);
	}
	
	static void mergeSortedArrays(int[] array, int left, int right){
		int  mid = (right - left) / 2 + left;
		int[] firstSubArray = new int[mid - left + 1];
		int[] secondSubArray = new int[right - mid];
		int firstCounter = 0;
		int secondCounter = 0;
		for(int i = left; i <= right; i++) {
			if(i <= mid) {
				firstSubArray[firstCounter] = array[i];
				firstCounter++;
			}
			else {
				secondSubArray[secondCounter] = array[i];
				secondCounter++;
			}
		}
		firstCounter = 0;
		secondCounter = 0;
		int j = left;
		while(firstCounter < mid-left+1 && secondCounter < right - mid) {
			if(firstSubArray[firstCounter] > secondSubArray[secondCounter]) {
				array[j] = secondSubArray[secondCounter];
				secondCounter++;
			}
			else {
				array[j] = firstSubArray[firstCounter];
				firstCounter++;
			}
			j++;
		}
		while(firstCounter < mid-left+1) {
			array[j] = firstSubArray[firstCounter];
			firstCounter++;
			j++;
		}
		while(secondCounter < right - mid) {
			array[j] = secondSubArray[secondCounter];
			secondCounter++;
			j++;
		}
		
	}


}
