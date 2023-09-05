package tree.implementation;

public class BinaryTreeArrayImpl {
	public static void main(String[] args) {
		BinaryTreeArrayImpl bt = new BinaryTreeArrayImpl(6);
		bt.insert("N1");
		bt.insert("N2");
		bt.insert("N3");
		bt.insert("N4");
		bt.insert("N5");
		bt.insert("N6");
		bt.postOrderTraversal();
		
	}
	
	
	String[] array;
	int lastUsedIndex;
	BinaryTreeArrayImpl(int size){
		//1 indexed 
		//cell at index 0 is not used
		this.array = new String[size+1];
		this.lastUsedIndex = 0;
	}
	public void insert(String value) {
		if(lastUsedIndex == array.length - 1)
			return;
		array[lastUsedIndex+1] = value;
		lastUsedIndex = lastUsedIndex+1;
	}
	
	public void inOrderTraversal() {
		inOrderTraversingFromIndex(1);
	}
	private void inOrderTraversingFromIndex(int index) {
		//index > lastUsedIndex in case we dont want to print null values (array is not full)&
		if(index > array.length-1)
			return;
		inOrderTraversingFromIndex(2*index);
		System.out.print(" "+array[index]);
		inOrderTraversingFromIndex(2*index+1);
	}
	
	public void preOrderTraversal() {
		preOrderTraversing(1);
	}
	private void preOrderTraversing(int index) {
		//index > lastUsedIndex in case we dont want to print null values (array is not full)
		if(index > array.length-1)
			return;
		System.out.print(" "+array[index]);
		preOrderTraversing(2*index);
		preOrderTraversing(2*index+1);
	}
	
	public void postOrderTraversal() {
		postOrderTraversing(1);
	}
	private void postOrderTraversing(int index) {
		if(index > lastUsedIndex)
			return;
		postOrderTraversing(2*index);
		postOrderTraversing(2*index+1);
		System.out.print(" " + array[index]);
	}
	
	
	
	
	

}
