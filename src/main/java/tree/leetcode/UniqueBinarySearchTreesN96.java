package tree.leetcode;

public class UniqueBinarySearchTreesN96 {
	
	public static void main(String[] args) {
		System.out.print(numTrees(4));
	}
    
	public static int numTrees(int n) {
		if(n == 0 || n== 1)
			return 1;
		if(n==2)
			return 2;
		if(n==3)
			return 5;
		if(n==4)
			return 14;
		if(n==5)
			return 42;
		int sum = 0;
		for(int i = 1; i<= n; i++) {
			sum += numTrees(i-1)*numTrees(n-i);
		}
		return sum;
	}

}
