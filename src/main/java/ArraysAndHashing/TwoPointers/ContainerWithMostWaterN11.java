package ArraysAndHashing.TwoPointers;

public class ContainerWithMostWaterN11 {
	public static void main(String[] args) {
		
	}
	
	
	
	 public int maxArea(int[] height) {
		 int maxArea = 0;
		 int l;
		 int r;
		 for(int i = 0; i < height.length; i++) {
			 l = 0;
			 r = height.length-1;
			 
			 while(l <= i && r >= i) {
				 if( Math.abs(l-i) == Math.abs(r-i)) {
					 if(height[r] >= height[i]) {
						 if(Math.abs(r-i)*height[i] > maxArea)
							 maxArea = Math.abs(r-i)*height[i];
						 break;
					 }
					 else if(height[l] >= height[i]) {
						 if(Math.abs(l-i)*height[i]> maxArea)
							 maxArea = Math.abs(l-i)*height[i];
						 break;
					 }
					 l++;
					 r--;
				 }
				 else if(Math.abs(i-r) > Math.abs(i-l)) {
					 if(height[r] >= height[i]) {
						 if(Math.abs(i-r)*height[i] > maxArea)
							 maxArea = Math.abs(i-r)*height[i];
						 break;
					 }
					 r--;
				 }
				 else if(Math.abs(i-l) > Math.abs(i-r)) {
					 if(height[l] >= height[i]) {
						 if(Math.abs(i-l)*height[i] > maxArea)
							 maxArea = Math.abs(i-l)*height[i];
						 break;
					 }
					 l++;
				 }
			 }
		 }
		 
		 return maxArea;
	 }

	public int maxArea2(int[] height) {
		int maxArea = 0; 
		int l = 0; 
		int r = height.length - 1;
		int interArea;
		while(l < r) {
			interArea = (r-l)*Math.min(height[r], height[l]);
			if(interArea > maxArea)
				maxArea = interArea;
			if(height[r]>height[l])
				l++;
			else
				r--;
		}
		return maxArea;
	}
	
}
